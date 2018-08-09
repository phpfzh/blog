import {Component, Inject, OnInit, Optional, ViewChild} from '@angular/core';
import {_HttpClient, ModalHelper} from '@delon/theme';
import {SimpleTableColumn, SimpleTableComponent, SimpleTableData} from '@delon/abc';
import {SFSchema} from '@delon/form';
import {ForumThreadService} from "../../../generated/service/forum-thread.service";
import {BASE_PATH} from "../../../generated/variables";
import {NzMessageService, NzModalRef, NzModalService} from "ng-zorro-antd";
import {StartupService} from "@core/startup/startup.service";

@Component({
  selector: 'app-thread-replay-view-list',
  templateUrl: './view-list.component.html',
})
export class ThreadReplayViewListComponent implements OnInit {
  basePath: string;
  url: string;

  searchSchema: SFSchema = {
    properties: {
      tusername: {
        type: 'string',
        title: '被回复用户名'
      },
      username: {
        type: 'string',
        title: '用户名'
      },
      first: {
        type: 'number',
        title: '是否评论',
        enum: [
          {label: '----', value: ''},
          {label: '是', value: 1},
          {label: '否', value: 0}
        ],
        ui: {
          widget: 'select'
        }
      },
      status: {
        type: 'number',
        title: '状态',
        enum: [
          {label: '----', value: ''},
          {label: '审核中', value: -1},
          {label: '审核失败', value: -2},
          {label: '审核通过', value: 0},
        ],
        ui: {
          widget: 'select'
        }
      }
    }
  };
  @ViewChild('st') st: SimpleTableComponent;
  columns: SimpleTableColumn[] = [
    {title: '编号', render: 'list_no', className: 'text-center'},
    {title: '用户名', index: 'username', className: 'text-center'},
    {
      title: '回复用户名', index: 'tusername', className: 'text-center', format: (cell: any, row: any) => {
        if (cell.tusername == "") {
          return "无";
        } else {
          return cell.tusername;
        }
      }
    },
    {
      title: '内容',
      className: 'text-center',
      buttons: [
        {type: 'none', text: '查看', click: (item: any) => this.showMess(item)}
      ]
    },
    {
      title: '是否评论', index: 'first', className: 'text-center', format: (cell: any, row: any) => {
        switch (cell.first) {
          case 1:
            return "是";
          default:
            return "否";
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
    {title: '发表时间', type: 'date', index: 'datetime', className: 'text-center', dateFormat: 'YYYY-MM-DD HH:mm:ss'}
  ];

  constructor(private http: _HttpClient,
              private modal: ModalHelper,
              private modalService: NzModalService,
              private startupService:StartupService,
              @Optional() @Inject(BASE_PATH) basePath: string) {
    if (basePath) {
      this.basePath = basePath;
    }
    this.startupService.load();
  }

  ngOnInit() {
    this.url = `${this.basePath}/api/forumThreadReplay/viewList`;
  }


  showMess(val: any) {
    const mes = val.message;
    const ref: NzModalRef = this.modalService.create({
      nzTitle: '内容图片查看',
      nzContent: mes,
      nzOnOk:() =>{
        ref.close();
      }
    })
    ;
  }
}
