import { Component, OnInit } from '@angular/core';
import {ForumThreadService} from "../../../../generated/service/forum-thread.service";
import {_HttpClient} from "@delon/theme";
import {NzMessageService} from "ng-zorro-antd";

@Component({
  selector: 'app-home-project-list',
  templateUrl: './home-project-list.component.html',
  styleUrls: ['./home.project.list.component.less']
})
export class HomeProjectListComponent implements OnInit {

  q: any = {
    ps: 8,
    categories: [],
    owners: ['zxx'],
  };

  list: any[] = [];

  loading = true;

  constructor(private http: _HttpClient,
              private forumThreadService: ForumThreadService,
              public msg: NzMessageService) {
  }

  ngOnInit() {
    this.getData();
  }

  getData() {
    this.loading = true;
    this.forumThreadService.indexList().subscribe((res: any) => {
      console.log(res);
      this.loading = false;
      if (res.code == "88") {
        this.list = this.list.concat(res.data.list);
      }else{
        this.msg.error(res.message);
      }
    });
    /*this.http.get('/api/list', {count: this.q.ps, "_allow_anonymous": true}).subscribe((res: any) => {
      this.list = this.list.concat(res);
      this.loading = false;
    });*/
  }


}
