import {Component, Inject, OnInit, Optional, ViewChild} from '@angular/core';
import {_HttpClient, ModalHelper} from '@delon/theme';
import {SimpleTableColumn, SimpleTableComponent} from '@delon/abc';
import {SFSchema, SFUISchema} from '@delon/form';
import {BASE_PATH} from "../../../generated/variables";
import {ForumForumEditComponent} from "../edit/edit.component";

@Component({
  selector: 'app-forum-forum-list',
  templateUrl: './list.component.html'

})
export class ForumForumListComponent implements OnInit {
  url: string;
  basePath: string;

  constructor(private http: _HttpClient,
              private modal: ModalHelper,
              @Optional() @Inject(BASE_PATH) basePath: string) {
    if (basePath) {
      this.basePath = basePath;
    }
  }

  ngOnInit() {
    this.url = `${this.basePath}/api/forumForum/list`;
  }

  searchSchema: SFSchema = {
    properties: {
      name: {
        type: 'string',
        title: '名称'
      },
      status: {
        type: 'number',
        title: '是否显示',
        enum: [
          {label: '是', value: 1},
          {label: '否', value: 0}
        ]
      }
    }
  };

  ui: SFUISchema = {
    $status: {
      widget: 'select'
     }

  };

  @ViewChild('st') st: SimpleTableComponent;
  columns: SimpleTableColumn[] = [
    {title: '编号', render: 'list_no', className: 'text-center'},
    {title: '名称', index: 'name', className: 'text-center'},
    {title: '主题数', index: 'threads', className: 'text-center'},
    {title: '评论数', index: 'commonts', className: 'text-center'},
    {title: '排序', index: 'sort', className: 'text-center'},
    {
      title: '是否显示', index: 'status', className: 'text-center', format: (cell: any, row: any) => {
        if (cell.status == 1) {
          return '是';
        } else {
          return '否';
        }
      }
    },
    {title: '添加人', index: 'addusername', className: 'text-center'},
    {title: '添加时间', type: 'date', index: 'addtime', dateFormat: 'YYYY-MM-DD HH:mm:ss', className: 'text-center'},
    {
      title: '操作',
      buttons: [
        {
          text: '编辑', size: 600, type: 'static', component: ForumForumEditComponent, click: 'reload'
        },
      ]
    }
  ];

  add() {
    this.modal
      .createStatic(ForumForumEditComponent, {i: {id: 0}})
      .subscribe(() => this.st.reload());
  }

}
