import {Component, Inject, OnInit, Optional, ViewChild} from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import {SimpleTableColumn, SimpleTableComponent, SimpleTableData} from '@delon/abc';
import { SFSchema } from '@delon/form';
import {ForumThreadService} from "../../../generated/service/forum-thread.service";
import {BASE_PATH} from "../../../generated/variables";
import {NzMessageService, NzModalRef, NzModalService} from "ng-zorro-antd";
import {ThreadReplayService} from "../../../generated/service/thread-replay.service";

@Component({
  selector: 'app-thread-replay-del-list',
  templateUrl: './del-list.component.html',
})
export class ThreadReplayDelListComponent implements OnInit {
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
    {title: '', type: 'checkbox', index: 'id', className: 'text-center'},
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
              private nzSer: NzMessageService,
              private threadReplayService: ThreadReplayService,
              @Optional() @Inject(BASE_PATH) basePath: string) {
    if (basePath) {
      this.basePath = basePath;
    }
  }

  ngOnInit() {
    this.url = `${this.basePath}/api/forumThreadReplay/viewList`;
  }

  selectedRows: SimpleTableData[] = [];
  checkboxChange(list: SimpleTableData[]) {
    this.selectedRows = list;
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

  delBatch(){
    if (!(this.selectedRows.length > 0)) {
      this.nzSer.error("请至少选择一个进行删除");
      return;
    }

    const tids = this.selectedRows.map(i => i.id).join(',');

    this.threadReplayService.delThreadReplay(tids)
      .subscribe(rep => {
        if (rep.code == "88") {
          this.nzSer.success("操作成功");
          this.st.reload();
          return;
        }
        this.nzSer.error(rep.message);
      });
  }
}
