import {Component, Inject, OnInit, Optional, ViewChild} from '@angular/core';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { _HttpClient } from '@delon/theme';
import { SFSchema, SFUISchema } from '@delon/form';
import {BASE_PATH} from "../../../generated/variables";

@Component({
  selector: 'app-friendlink-edit',
  templateUrl: './edit.component.html',
})
export class FriendlinkEditComponent implements OnInit {
  basePath:string;
  record: any = {};
  i: any;
  schema: SFSchema = {
    properties: {
      name: { type: 'string', title: '名称' },
      type: { type: 'number', title: '类型' ,enum: [
          { label: '友情链接', value: 1 },
          { label: '常用站点', value: 2 },
        ],
        default:1
      },
      link: { type: 'string', title: '链接', format: 'uri' },
      sort: { type: 'number', title: '排名'},
      remark: { type: 'string', title: '备注', maxLength: 140 },
    },
    required: ['name', 'link', 'type'],
  };
  ui: SFUISchema = {
    '*':{
      spanControl:10
    },
    $type: {
      widget: 'select'
    },
    $link: {
      widget: 'string',
    },
    $sort:{
      minimum:1,
      maximum:100
    },
    $remark: {
      widget: 'textarea',
    },
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
      if (this.record.id > 0)
        this.http.get<any>(`${this.basePath}/api/friendlink/getEntity`,{"id":this.record.id})
          .subscribe(res => {
            if(res.code == "88"){
              this.i = res.data;
            }
          });
  }

  save(value: any) {
    let url = `${this.basePath}/api/friendlink/save`;
    if(value.id > 0){
      url = `${this.basePath}/api/friendlink/update`;
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
    );;
  }

  close() {
    this.modal.destroy();
  }
}
