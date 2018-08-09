import {Component, Inject, OnInit, Optional, ViewChild} from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { SimpleTableColumn, SimpleTableComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import {BASE_PATH} from "../../../generated/variables";
import {NzMessageService} from "ng-zorro-antd";
import {StartupService} from "@core/startup/startup.service";

@Component({
  selector: 'app-forum-thread-view-list',
  templateUrl: './view-list.component.html',
})
export class ForumThreadViewListComponent implements OnInit {
  basePath: string;
  url: string;
  searchSchema: SFSchema = {
    properties: {
      subject: {
        type: 'string',
        title: '标题'
      },
      fname: {
        type: 'string',
        title: '版块名称'
      },
      username: {
        type: 'string',
        title: '用户名'
      },
      threadtype: {
        type: 'number',
        title: '主题类型',
        enum:[
          {label:'----',value:''},
          {label:'原创',value:1},
          {label:'转载',value:2},
          {label:'翻译',value:3},
        ],
        ui:{
          widget:'select'
        }
      },
      status: {
        type: 'number',
        title: '状态',
        enum:[
          {label:'----',value:''},
          {label:'审核中',value:-1},
          {label:'审核失败',value:-2},
          {label:'审核通过',value:0},
        ],
        ui:{
          widget:'select'
        }
      }
    }
  };
  @ViewChild('st') st: SimpleTableComponent;
  columns: SimpleTableColumn[] = [
    {title: '编号', render: 'list_no', className: 'text-center'},
    {title: '标题', index: 'subject', className: 'text-center'},
    {title: '版块名称', index: 'fname', className: 'text-center'},
    {
      title: '主题类型', index: 'threadtype', className: 'text-center', format: (cell: any, row: any) => {
        switch (cell.threadtype) {
          case 1:
            return "原创";
          case 2:
            return "转载";
          default:
            return "翻译";
        }
      }
    },
    {
      title: '状态', index: 'status', className: 'text-center', format: (cell: any, row: any) => {
        switch (cell.status) {
          case -1:
            return "审核中";
          case -2:
            return "审核失败";
          default:
            return "审核通过";
        }
      }
    },
    {
      title: '是否删除', index: 'isdelete', className: 'text-center', format: (cell: any, row: any) => {
        switch (cell.isdelete) {
          case 1:
            return "是";
          default:
            return "否";
        }
      }
    },
    {title: '作者', index: 'username', className: 'text-center'},
    {title: '发表时间', type: 'date', index: 'dateline', className: 'text-center', dateFormat: 'YYYY-MM-DD HH:mm:ss'}

  ];

  constructor(private http: _HttpClient,
              private modal: ModalHelper,
              private nzSer: NzMessageService,
              private startupService:StartupService,
              @Optional() @Inject(BASE_PATH) basePath: string) {
    if (basePath) {
      this.basePath = basePath;
    }
    this.startupService.load();
  }

  ngOnInit() {
    this.url = `${this.basePath}/api/forumThread/viewList`;
  }

  add() {
    // this.modal
    //   .createStatic(FormEditComponent, { i: { id: 0 } })
    //   .subscribe(() => this.st.reload());
  }

}
