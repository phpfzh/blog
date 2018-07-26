import {Component, Inject, OnInit, Optional, ViewChild} from '@angular/core';
import {_HttpClient, ModalHelper} from '@delon/theme';
import {SimpleTableColumn, SimpleTableComponent, SimpleTableData} from '@delon/abc';
import {SFSchema} from '@delon/form';
import {BASE_PATH} from "../../../generated/variables";
import {ifError} from "assert";
import {NzMessageService} from "ng-zorro-antd";

@Component({
  selector: 'app-forum-thread-list',
  templateUrl: './list.component.html',
})
export class ForumThreadListComponent implements OnInit {
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
    {title: '作者', index: 'username', className: 'text-center'},
    {title: '发表时间', type: 'date', index: 'dateline', className: 'text-center', dateFormat: 'YYYY-MM-DD HH:mm:ss'},
    {
      title: '操作',
      buttons: [
        {type: 'del', text: '审核通过', popTitle:'您正在进行审核通过操作', click: (item: any) => this.audit(item,1)},
        {type: 'del', text: '审核失败', popTitle:'您正在进行审核失败操作',click: (item: any) => this.audit(item,0)}

        // { text: '编辑', type: 'static', component: FormEditComponent, click: 'reload' },
      ]
    }
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
    this.url = `${this.basePath}/api/forumThread/list`;
  }

  checkboxChange(list: SimpleTableData[]) {
    this.selectedRows = list;
   }

  //批量审核
  auditBatch(item: number) {
    console.log(this.selectedRows.length)
    if (!(this.selectedRows.length > 0)) {
      this.nzSer.error("请选择一个进行审核");
      return;
    }

    const tids = this.selectedRows.map(i => i.id).join(',');

    this.http.post<any>(`${this.basePath}/api/forumThread/auditBatchForumThread`, null, {"status": item, "tids": tids})
      .subscribe(rep => {
        if (rep.code == "88") {
          this.nzSer.success("操作成功");
          this.st.reload();
          return ;
        }
        this.nzSer.error(rep.message);
      });
  }

  //审核
  audit(val: any,status:number) {
    this.http.post<any>(`${this.basePath}/api/forumThread/auditForumThread`, null, {"status": status, "tid": val.id})
      .subscribe(rep => {
        if (rep.code == "88") {
          this.nzSer.success("操作成功");
          this.st.reload();
          return ;
        }
         this.nzSer.error(rep.message);
      });
  }
}
