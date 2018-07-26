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
      name: {type: 'string', title: '名称'},
      status: {
        type: 'number', title: '是否显示', enum: [
           { label: '是', value: 1 },
           { label: '否', value: 0 },
        ],
        default:1,
        ui:{
          widget:'select'
        }
      },
      sort: {type: 'number', title: '排序',minimum: 0, maximum: 100},
      threads	: {type: 'number', title: '主题数量',minimum: 0},
      commonts	: {type: 'number', title: '回复数量',minimum: 0},
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
      this.http.get<any>(`${this.basePath}/api/forumForum/getEntity`,{"id":this.record.id})
        .subscribe(res => {
          if(res.code == "88"){
            this.i = res.data;
          }
        });
  }

  save(value: any) {
    let url = `${this.basePath}/api/forumForum/save`;
    if(value.id > 0){
        url = `${this.basePath}/api/forumForum/update`;
    }

    this.http.post<any>(url,null,value).subscribe(
      rep => {
        if(rep.code == "88"){
          this.msgSrv.success(rep.message);
          setTimeout(() => {
            this.modal.close(true);
          },600);
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
