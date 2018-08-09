import {Component, Inject, OnInit, Optional, ViewChild} from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import {SimpleTableColumn, SimpleTableComponent, SimpleTableData} from '@delon/abc';
import { SFSchema } from '@delon/form';
import {NzMessageService} from "ng-zorro-antd";
import {ForumThreadService} from "../../../generated/service/forum-thread.service";
import {BASE_PATH} from "../../../generated/variables";
import {StartupService} from "@core/startup/startup.service";

@Component({
  selector: 'app-forum-thread-restore-list',
  templateUrl: './restore-list.component.html',
})
export class ForumThreadRestoreListComponent implements OnInit {
  basePath: string;
  url: string;
  selectedRows: SimpleTableData[] = [];

  searchSchema: SFSchema = {
    properties: {
      no: {
        type: 'string',
        title: '编号'
      }
    }
  };

  @ViewChild('st') st: SimpleTableComponent;
  columns: SimpleTableColumn[] = [
    {title: '', type: 'checkbox', index: 'id', className: 'text-center'},
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
    {title: '发表时间', type: 'date', index: 'dateline', className: 'text-center', dateFormat: 'YYYY-MM-DD HH:mm:ss'},
    {
      title: '操作',
      buttons: [
        {type: 'del', text: '恢复', popTitle: '您正在进行恢复操作', click: (item: any) => this.restore(item)},
      ]
    }
  ];

  constructor(private http: _HttpClient,
              private modal: ModalHelper,
              private nzSer: NzMessageService,
              private forumThreadService :ForumThreadService,
              private startupService:StartupService,
              @Optional() @Inject(BASE_PATH) basePath: string) {
    if (basePath) {
      this.basePath = basePath;
    }
    this.startupService.load();
  }

  ngOnInit() {
    this.url = `${this.basePath}/api/forumThread/restoreList`;
  }

  checkboxChange(list: SimpleTableData[]) {
    this.selectedRows = list;
  }

//批量恢复
  restoreBatch() {
    console.log(this.selectedRows.length)
    if (!(this.selectedRows.length > 0)) {
      this.nzSer.error("请至少选择一个进行恢复");
      return;
    }

    const tids = this.selectedRows.map(i => i.id).join(',');

    this.forumThreadService.restoreBatchThread(tids)
      .subscribe(rep => {
        if (rep.code == "88") {
          this.nzSer.success("恢复成功");
          this.st.reload();
          return;
        }
        this.nzSer.error(rep.message);
      });
  }

  //恢复
  restore(val: any) {
    this.forumThreadService.restore(val.id)
      .subscribe(rep => {
        if (rep.code == "88") {
          this.nzSer.success("恢复成功");
          this.st.reload();
          return;
        }
        this.nzSer.error(rep.message);
      });
  }
}
