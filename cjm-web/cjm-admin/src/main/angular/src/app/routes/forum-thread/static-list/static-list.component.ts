import {Component, Inject, OnInit, Optional, ViewChild} from '@angular/core';
import {_HttpClient, ModalHelper} from '@delon/theme';
import {SimpleTableColumn, SimpleTableComponent, SimpleTableData} from '@delon/abc';
import {SFSchema} from '@delon/form';
import {ForumThreadService} from "../../../generated/service/forum-thread.service";
import {BASE_PATH} from "../../../generated/variables";
import {NzMessageService} from "ng-zorro-antd";
import {Router} from "@angular/router";

@Component({
  selector: 'app-forum-thread-static-list',
  templateUrl: './static-list.component.html',
})
export class ForumThreadStaticListComponent implements OnInit {
  url: string;
  basePath: string;
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
        {type: 'del', text: '静态化', popTitle: '您正在进行静态化操作', click: (item: any) => this.staticHtml(item)},
        {type: 'none', text: '修改', click: (item: any) => this.upde(item)},

      ]
    }
  ];

  constructor(private http: _HttpClient,
              private modal: ModalHelper,
              private nzSer: NzMessageService,
              private router: Router,
              private forumThreadService: ForumThreadService,
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

  upde(val: any) {
    if(val.id > 0){
      this.router.navigate(['editor'], {
          queryParams : {
            tid: val.id
          }
      });
    }

  }

  //批量静态化
  batchStaticHtml() {
    if (!(this.selectedRows.length > 0)) {
      this.nzSer.error("请至少选择一个进行静态化");
      return;
    }

    const tids = this.selectedRows.map(i => i.id).join(',');

    this.forumThreadService.batchStaticHtml(tids)
      .subscribe(rep => {
        if (rep.code == "88") {
          this.nzSer.success("静态化成功");
          this.st.reload();
          return;
        }
        this.nzSer.error(rep.message);
      });
  }

  //静态化
  staticHtml(val: any) {
    this.forumThreadService.staticHtml(val.id)
      .subscribe(rep => {
        if (rep.code == "88") {
          this.nzSer.success("静态化成功");
          this.st.reload();
          return;
        }
        this.nzSer.error(rep.message);
      });
  }
}
