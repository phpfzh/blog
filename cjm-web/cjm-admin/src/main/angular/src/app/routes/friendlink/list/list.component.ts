import {Component, Inject, OnInit, Optional, ViewChild} from '@angular/core';
import {_HttpClient, ModalHelper} from '@delon/theme';
import {SimpleTableColumn, SimpleTableComponent} from '@delon/abc';
import {SFSchema, SFUISchema} from '@delon/form';
import {BASE_PATH} from "../../../generated/variables";
import {FriendlinkEditComponent} from "../edit/edit.component";
import {NzMessageService} from "ng-zorro-antd";

@Component({
  selector: 'app-friendlink-list',
  templateUrl: './list.component.html',
})
export class FriendlinkListComponent implements OnInit {
  @ViewChild('st') st: SimpleTableComponent;
  url: string;
  basePath: string;

  constructor(private http: _HttpClient,
              private modal: ModalHelper,
              private nzSer: NzMessageService,
              @Optional() @Inject(BASE_PATH) basePath: string) {
    if (basePath) {
      this.basePath = basePath;
    }
  }

  ngOnInit() {
    this.url = `${this.basePath}/api/friendlink/list`;
  }

  searchSchema: SFSchema = {
    properties: {
      name: {
        type: 'string',
        title: '名称'
      },
      type: {
        type: 'number',
        title: '类型',
        enum: [
          {label: '友情链接', value: 1},
          {label: '常用站点', value: 2}
        ]
      }

    }
  };

  ui: SFUISchema = {
    $status: {
      widget: 'select'
    }

  };

  columns: SimpleTableColumn[] = [
    {title: '编号', render: 'list_no',className: 'text-center'},
    {title: '名称', index: 'name',className: 'text-center'},
    {title: '链接', index: 'link',className: 'text-center'},
    {title: '类型', index: 'type', className: 'text-center', format: (cell: any, row: any) => {
        if (cell.type == 1) {
          return '友情链接 ';
        } else if(cell.type == 2) {
          return '常用站点';
        }
      }
    },
    {title: '添加时间', type: 'date', dateFormat: 'YYYY-MM-DD HH:mm:ss', index: 'dateline',className: 'text-center'},
    {
      title: '操作',
      buttons: [
         { text: '编辑', type: 'static', component: FriendlinkEditComponent, click: 'reload' },
         {type: 'del', text: '删除', popTitle: '您确定要删除吗？', click: (item: any) => this.del(item)},
       ]
    }
  ];

  add() {
    this.modal
     .createStatic(FriendlinkEditComponent, { i: { id: 0 } })
     .subscribe(() => this.st.reload());
  }

  del(val: any){
    this.http.post<any>(`${this.basePath}/api/friendlink/del`,{},{"id":val.id}).subscribe(rep => {
      if (rep.code == "88") {
        this.nzSer.success(rep.message);
        this.st.reload();
        return;
      }
      this.nzSer.error(rep.message);
    });
  }
}
