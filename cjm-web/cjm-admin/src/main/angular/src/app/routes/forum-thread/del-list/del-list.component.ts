import {Component, Inject, OnInit, Optional, ViewChild} from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import {SimpleTableColumn, SimpleTableComponent, SimpleTableData} from '@delon/abc';
import { SFSchema } from '@delon/form';
import {BASE_PATH} from "../../../generated/variables";
import {NzMessageService} from "ng-zorro-antd";

@Component({
  selector: 'app-forum-thread-del-list',
  templateUrl: './del-list.component.html',
})
export class ForumThreadDelListComponent implements OnInit {
  url :string;
  basePath:string;
  selectedRows: SimpleTableData[] = [];
   searchSchema: SFSchema = {
    properties: {
      fname: {
        type: 'string',
        title: '版块名称'
      },
      subject: {
        type: 'string',
        title: '标题'
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
    {title: '作者', index: 'username', className: 'text-center'},
    {title: '发表时间', type: 'date', index: 'dateline', className: 'text-center', dateFormat: 'YYYY-MM-DD HH:mm:ss'}

  ];

  constructor(private http: _HttpClient,
              private modal: ModalHelper,
              private nzSer: NzMessageService,
              @Optional() @Inject(BASE_PATH) basePath: string) {
    if (basePath) {
      this.basePath = basePath;
    }
  }

  ngOnInit() {
    this.url = `${this.basePath}/api/forumThread/delList`;
  }

  checkboxChange(list: SimpleTableData[]) {
    this.selectedRows = list;
  }

  add() {
    // this.modal
    //   .createStatic(FormEditComponent, { i: { id: 0 } })
    //   .subscribe(() => this.st.reload());
  }

}
