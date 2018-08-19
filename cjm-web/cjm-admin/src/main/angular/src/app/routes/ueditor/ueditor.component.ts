import {
  Component, ElementRef, OnInit, ViewChild, AfterViewInit, ViewEncapsulation, Inject,
  Optional, Injector
} from '@angular/core';
import {SFComponent, SFSchema} from "@delon/form";
import {UEditorComponent} from "ngx-ueditor";
import {NzMessageService, UploadFile} from "ng-zorro-antd";
import {ForumThreadService} from "../../generated/service/forum-thread.service";
import {BASE_PATH} from "../../generated/variables";
import {DA_SERVICE_TOKEN, ITokenService, TokenService} from "@delon/auth";
import {Router} from "@angular/router";
import {HomeIndexService} from "../../generated/service/home-index.service";
import {map} from "rxjs/internal/operators";

declare const UE: any;

@Component({
  selector: 'app-ueditor',
  templateUrl: './ueditor.component.html',
  styleUrls: ['./ueditor.component.less']
})
export class UeditorComponent implements OnInit {

  @ViewChild('full') full: UEditorComponent;
  @ViewChild('sf') sf: SFComponent;
  full_source: string;
  basePath: string;

  schema: SFSchema = {
    properties: {
      subject: {
        type: 'string',
        title: '标题'
      },
      threadtype: {
        type: 'number',
        title: '主题类型',
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
        title: '栏目',
        enum: [],
        ui: {
          widget: 'select'
        }
      },
      usesig: {
        type: 'number',
        title: '是否带签名',
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
    required: ['subject', 'threadtype']
  }
  ;

  constructor(public msg: NzMessageService,
              private el: ElementRef,
              private  homeIndexService: HomeIndexService,
              private router: Router,
              @Inject(DA_SERVICE_TOKEN) private tokenService: ITokenService,
              private forumThreadService: ForumThreadService,
              @Optional() @Inject(BASE_PATH) basePath: string) {
    if (basePath) {
      this.basePath = basePath;
    }
  }

  submit(value: any) {
    const fid = value.fid;
    const threadtype = value.threadtype;
    const subject = value.subject == undefined ? "" : value.subject;
    const content = this.full.Instance.getContent() == undefined ? "" : this.full.Instance.getContent();
    const usesig = value.usesig == undefined ? "" : value.usesig;
    const tags = value.tags == undefined ? "" : value.tags;
    const coverimg = this.coverimg == undefined ? "" : this.coverimg;
    this.forumThreadService.insertForumThread(fid, threadtype, subject, content, tags, usesig, coverimg)
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

  //显示图片
  avatarUrl: string;
  loading: boolean = false;
  coverimg: string;

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

  //放大图片
  previewImage = '';
  previewVisible = false;
  handlePreview = (file: UploadFile) => {
    this.previewImage = file.url || file.thumbUrl;
    this.previewVisible = true;
  }
}
