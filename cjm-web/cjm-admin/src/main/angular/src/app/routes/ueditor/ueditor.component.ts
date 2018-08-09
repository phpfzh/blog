import {
  Component, ElementRef, OnInit, ViewChild, AfterViewInit, ViewEncapsulation, Inject,
  Optional
} from '@angular/core';
import {SFComponent, SFSchema} from "@delon/form";
import {UEditorComponent} from "ngx-ueditor";
import {NzMessageService} from "ng-zorro-antd";
import {ForumThreadService} from "../../generated/service/forum-thread.service";
import {BASE_PATH} from "../../generated/variables";
import {TokenService} from "@delon/auth";
import {Router} from "@angular/router";
import {HomeIndexService} from "../../generated/service/home-index.service";
import {map} from "rxjs/internal/operators";

declare const UE: any;

@Component({
  selector: 'app-ueditor',
  templateUrl: './ueditor.component.html',
  styles: []
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
          {label: '是否', value: 0},
        ],
        ui: {
          widget: 'select'
        }
      },
      tags: {
        type: 'string',
        title: 'tags'
      }
      /*content: {
        type: 'string',
        title:
          '',
        ui:
          {
            widget: 'ueditor'
          }
      }*/
    },
    required: ['subject', 'threadtype']
  }
  ;

  constructor(public msg: NzMessageService,
              private el: ElementRef,
              private  homeIndexService: HomeIndexService,
              private forumThreadService: ForumThreadService,
              @Optional() @Inject(BASE_PATH) basePath: string) {
    if (basePath) {
      this.basePath = basePath;
    }
  }

  submit(value: any) {
    const fid = 3;
    const threadtype = value.threadtype;
    const subject = value.subject;
    const content = this.full.Instance.getContent();
    const usesig = value.usesig;
    const tags = value.tags;

    this.forumThreadService.insertForumThread(fid, threadtype, subject, content, tags, usesig)
      .subscribe(rep => {
        if (rep.code == "88") {
          this.msg.success(rep.message);
          return;
        }
        this.msg.error(rep.message);
      })
  }

  ngOnInit() {
    this.homeIndexService.forumList().subscribe(rep => {
      if (rep.code == "88") {
          
      }
      this.schema.properties.fid.enum = [rep.data.name, rep.data.id];
      this.sf.refreshSchema();
    });
  }

  onReady(comp: UEditorComponent) {
    UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
    UE.Editor.prototype.getActionUrl = function (action) {
      console.log("========action======" + action);
      if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadimage') {
        return `${this.basePath}/uploadImage`;
      } else if (action == 'uploadvideo') {
        return `${this.basePath}/uploadVideo`;
      } else {
        return this._bkGetActionUrl.call(this, action);
      }
    }

  }

}
