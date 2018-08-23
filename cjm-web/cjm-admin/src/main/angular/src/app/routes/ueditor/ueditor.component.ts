import {
  Component, ElementRef, OnInit, ViewChild, Inject, AfterViewInit,
  Optional
} from '@angular/core';
import {SFComponent, SFSchema} from "@delon/form";
import {UEditorComponent} from "ngx-ueditor";
import {NzMessageService, UploadFile} from "ng-zorro-antd";
import {ForumThreadService} from "../../generated/service/forum-thread.service";
import {BASE_PATH} from "../../generated/variables";
import {DA_SERVICE_TOKEN, ITokenService, TokenService} from "@delon/auth";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {HomeIndexService} from "../../generated/service/home-index.service";
import {map} from "rxjs/internal/operators";
import {Thread} from "../../generated/model/thread";
import {HttpUrlEncodingCodec} from "@angular/common/http";

declare const UE: any;

@Component({
  selector: 'app-ueditor',
  templateUrl: './ueditor.component.html',
  styleUrls: ['./ueditor.component.less'],
  providers: [HttpUrlEncodingCodec]
})
export class UeditorComponent implements OnInit, AfterViewInit {

  @ViewChild('full') full: UEditorComponent;
  @ViewChild('sf') sf: SFComponent;
  full_source: string;
  basePath: string;
  //放大图片
  previewImage = '';
  previewVisible = false;
  //主题id
  tid: number = 0;
  id: number = 0;
  //显示图片
  avatarUrl: string;
  loading: boolean = false;
  coverimg: string;

  schema: SFSchema = {
    properties: {
      subject: {
        type: 'string',
        title: '标题',
        ui: {
          widget: 'textarea'
        }
      },
      threadtype: {
        type: 'number',
        title: '类型:',
        enum: [
          {label: '原创', value: 1},
          {label: '转载', value: 2},
          {label: '翻译', value: 3},
        ],
        ui: {
          widget: 'select'
        }
      },
      fid: {
        type: 'number',
        title: '栏目:',
        enum: [],
        ui: {
          widget: 'select'
        }
      },
      usesig: {
        type: 'number',
        title: '签名:',
        enum: [
          {label: '是', value: 1},
          {label: '否', value: 0},
        ],
        ui: {
          widget: 'select'
        }
      },
      tags: {
        type: 'string',
        title: 'tags'
      }
    },
    required: ['subject', 'threadtype', 'fid']
  }
  ;

  constructor(public msg: NzMessageService,
              private el: ElementRef,
              private  homeIndexService: HomeIndexService,
              private router: Router,
              private route: ActivatedRoute,
              private httpUrlEncodingCodec: HttpUrlEncodingCodec,
              @Inject(DA_SERVICE_TOKEN) private tokenService: ITokenService,
              private forumThreadService: ForumThreadService,
              @Optional() @Inject(BASE_PATH) basePath: string) {
    if (basePath) {
      this.basePath = basePath;
    }
  }

  ngOnInit() {
    const tokenData = this.tokenService.get();
    if (!tokenData.token) {
      this.router.navigate(['/passport/login']);
      return;
    }

    this.homeIndexService.forumList().subscribe(rep => {
      if (rep.code == "88") {
        const enumArrObj = new Array();
        for (let i = 0; i < rep.data.list.length; i++) {
          const obj = {
            label: rep.data.list[i].name,
            value: rep.data.list[i].id
          };
          enumArrObj.push(obj)
        }
        this.schema.properties.fid.enum = enumArrObj;
        this.sf.refreshSchema();
      }
    });

    /* this.route.params.subscribe((params: Params) => {
       this.tid = params['tid'];
     });*/


  }

  ngAfterViewInit() {
    this.route.queryParams.subscribe(queryParams => {
      this.tid = queryParams.tid;
    });

    if (this.tid > 0) {
      this.forumThreadService.getForumThreadByTid(this.tid).subscribe(rep => {
        if (rep.code == "88") {
          this.schema.properties.fid.default = rep.data.fid;
          this.schema.properties.subject.default = rep.data.subject
          this.schema.properties.threadtype.default = rep.data.threadtype;
          this.schema.properties.usesig.default = rep.data.usesig;
          let tags = "";
          for (let i = 0; i < rep.data.listtags.length; i++) {
            tags += rep.data.listtags[i].name + ",";
          }
          this.schema.properties.tags.default = tags;
          this.avatarUrl = rep.data.coverimg;
          this.id = rep.data.id;
          this.full_source = rep.data.content;
          this.sf.refreshSchema();
        }
      });
    }
  }

  onReady(comp: UEditorComponent) {
    UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
    UE.Editor.prototype.getActionUrl = function (action) {
      console.log("========action======" + action);
      if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadimage') {
        return `http://www.chenjiaming.com/uploadImage`;
      } else if (action == 'uploadvideo') {
        return `http://www.chenjiaming.com/uploadVideo`;
      } else {
        return this._bkGetActionUrl.call(this, action);
      }
    }
  }

  //限制文件类型和大小
  beforeUpload = (file: File) => {
    const isLt20M = file.size / 1024 / 1024 < 20;
    if (!isLt20M) {
      this.msg.error('图片不能超过20M!');
    }
    return isLt20M;
  }

  private getBase64(img: File, callback: (img: {}) => void): void {
    const reader = new FileReader();
    reader.addEventListener('load', () => callback(reader.result));
    reader.readAsDataURL(img);
  }


  handleChange(info: { file: UploadFile }): void {
    this.coverimg = info.file.response.url;
    if (info.file.status === 'uploading') {
      this.loading = true;
      return;
    }

    if (info.file.status === 'done') {
      // Get this url from response in real world.
      this.getBase64(info.file.originFileObj, (img: string) => {
        this.loading = false;
        this.avatarUrl = img;
      });
    }
  }


  handlePreview = (file: UploadFile) => {
    this.previewImage = file.url || file.thumbUrl;
    this.previewVisible = true;
  }

  submit(value: any) {
    const thread: Thread = Object.assign({
      content: this.httpUrlEncodingCodec.encodeValue(this.full_source),
      coverimg: this.coverimg == undefined ? "" : this.coverimg,
      tags: value.tags == undefined ? "" : value.tags,
      id: this.id > 0 ? this.id : 0

    }, value);
    console.log(thread + "=====" + JSON.stringify(thread));
    if (this.id > 0) {
      //修改
      this.forumThreadService.updateForumThread(thread)
        .subscribe(rep => {
          if (rep.code == "00") {
            this.msg.error(rep.message);
            return;
          }
          this.msg.success(rep.message);
          new Promise((resolve, reject) => {
            resolve({});
          }).then(() => this.router.navigate(['/index']));
        });
    } else {
      //新增
      this.forumThreadService.insertForumThread(thread)
        .subscribe(rep => {
          if (rep.code == "00") {
            this.msg.error(rep.message);
            return;
          }
          this.msg.success(rep.message);
          new Promise((resolve, reject) => {
            resolve({});
          }).then(() => this.router.navigate(['/index']));
        });
    }
  }

}
