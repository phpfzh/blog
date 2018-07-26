import {Component, Inject, OnInit, Optional, ViewChild} from '@angular/core';
import {NzModalRef, NzMessageService} from 'ng-zorro-antd';
import {_HttpClient} from '@delon/theme';
import {SFSchema, SFUISchema} from '@delon/form';
import {BASE_PATH} from "../../../generated/variables";

@Component({
  selector: 'app-forum-forum-edit',
  templateUrl: './edit.component.html',
})
export class ForumForumEditComponent implements OnInit {
  basePath: string;
  record: any = {};
  i: any;
  schema: SFSchema = {
    properties: {
      name: {type: 'string', title: '编号'},
      status: {
        type: 'number', title: '是否显示', enum: [
          { label: '是', value: 1 },
          { label: '否', value: 0 },
        ],
        ui:{
          widget:'select'
        }
      },
      sort: {type: 'number', title: '排序',minimum: 0, maximum: 100,},
    },
    required: ['name', 'sort', 'status'],
  };
  ui: SFUISchema = {
    /*'*': {
      spanLabelFixed: 100,
      grid: {span: 12},
    }*/
    '*':{
      spanControl:10
    }
  };

  constructor(
    private modal: NzModalRef,
    public msgSrv: NzMessageService,
    public http: _HttpClient,
    @Optional() @Inject(BASE_PATH) basePath: string
  ) {
    if (basePath) {
      this.basePath = basePath;
    }
  }

  ngOnInit(): void {
    if (this.record.id > 0)
      this.i = this.record;
    //this.http.get(`/user/${this.record.id}`).subscribe(res => (this.i = res));
  }

  save(value: any) {
    this.http.post<any>(`${this.basePath}/api/forumForum/update`,null,value).subscribe(
      rep => {
        if(rep.code == "88"){
          this.msgSrv.success('保存成功');
          this.modal.close(true);
        }else {
          this.msgSrv.error(rep.message);
        }
      }
    );
  }

  close() {
    this.modal.destroy();
  }
}
