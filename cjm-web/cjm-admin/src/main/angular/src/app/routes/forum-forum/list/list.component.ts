import {Component, Inject, OnInit, Optional, ViewChild} from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { SimpleTableColumn, SimpleTableComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import {BASE_PATH} from "../../../generated/variables";

@Component({
  selector: 'app-forum-forum-list',
  templateUrl: './list.component.html',
})
export class ForumForumListComponent implements OnInit {
  url :string ;
  basePath :string ;
  ngOnInit() {
    this.url = `${this.basePath}/api/forumForum/list`;
  }
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
    { title: '编号', index: 'addtime' },
    { title: '调用次数',  index: 'addusername' },
     { title: '时间', type: 'date', index: 'addtime' },
    {
      title: '',
      buttons: [
        // { text: '查看', click: (item: any) => `/form/${item.id}` },
        // { text: '编辑', type: 'static', component: FormEditComponent, click: 'reload' },
      ]
    }
  ];

  constructor(private http: _HttpClient,
              private modal: ModalHelper,
              @Optional() @Inject(BASE_PATH) basePath: string) {
    if (basePath) {
      this.basePath = basePath;
    }
  }



  add() {
    // this.modal
    //   .createStatic(FormEditComponent, { i: { id: 0 } })
    //   .subscribe(() => this.st.reload());
  }

}
