import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {SFSchema} from "@delon/form";
import {UEditorComponent} from "ngx-ueditor";
import {NzMessageService} from "ng-zorro-antd";
import {ForumThreadService} from "../../generated/service/forum-thread.service";

declare const UE: any;

@Component({
  selector: 'app-ueditor',
  templateUrl: './ueditor.component.html',
  styles: []
})
export class UeditorComponent implements OnInit {

  @ViewChild('full') full: UEditorComponent;
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
      content: {
        type: 'string',
        title:
          '',
        ui:
          {
            widget: 'ueditor'
          }
      }
    },
    required:['content','subject','threadtype']
  }
  ;

  constructor(public msg: NzMessageService,
              private forumThreadService:ForumThreadService) {
  }

  submit(value: any) {
    console.log(JSON.stringify(value))
    const fid = 3;
    const threadtype = value.threadtype;
    const subject = value.subject;
    const content = value.content;
    const usesig = value.usesig;

    this.forumThreadService.insertForumThread(fid,threadtype,subject,content,usesig)
      .subscribe(rep => {
        console.log(rep+"==="+JSON.stringify(rep))
          if(rep.code == "88"){
              this.msg.success(rep.message);
              return;
          }
          this.msg.error(rep.message);
     })
  }

  ngOnInit() {

  }


}
