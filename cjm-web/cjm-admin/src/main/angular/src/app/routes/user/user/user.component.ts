import {Component, OnInit, ViewChild} from '@angular/core';
import {_HttpClient, ModalHelper} from '@delon/theme';
import {SimpleTableColumn, SimpleTableComponent} from '@delon/abc';
import {SFSchema} from '@delon/form';
import {APIS, User, UserService} from '../../../../generated';

@Component({
  selector: 'app-user-user',
  templateUrl: './user.component.html',
})
export class UserUserComponent implements OnInit {


  url = `/user`;
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
    {title: '编号', index: 'no'},
    {title: '调用次数', type: 'number', index: 'callNo'},
    {title: '头像', type: 'img', width: '50px', index: 'avatar'},
    {title: '时间', type: 'date', index: 'updatedAt'},
    {
      title: '',
      buttons: [
        // { text: '查看', click: (item: any) => `/form/${item.id}` },
        // { text: '编辑', type: 'static', component: FormEditComponent, click: 'reload' },
      ]
    }
  ];
  usertest: User;

  constructor(private http: _HttpClient, private modal: ModalHelper, private userService: UserService) {
    this.usertest = {
      username: '用户名'
    };
  }

  ngOnInit() {
    console.log(this.userService);
  }

  add(event?: any) {
    const entry2: User = Object.assign({}, event);
  }

}
