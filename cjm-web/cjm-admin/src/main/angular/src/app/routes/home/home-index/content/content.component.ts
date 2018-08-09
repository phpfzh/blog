import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {_HttpClient} from "@delon/theme";
import {NzMessageService} from "ng-zorro-antd";
import {ForumThreadService} from "../../../../generated/service/forum-thread.service";

@Component({
  selector: 'app-home-index-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.less']
})
export class ContentComponent {

  @Input() array: any = [1, 2, 3, 4, 5];

  @Input() list: any[] = [];

  @Input() pageIndex: any = 1;

  @Input() total: number;

  @Input() pageSize:number;

  @Output() chPageIndexChange = new EventEmitter<number>();
  @Output() chPageSizeChange = new EventEmitter<number>();

  nzPageIndexChange(va:number){
     this.chPageIndexChange.emit(va);
  }

  nzPageSizeChange(val:number){
    this.chPageSizeChange.emit(val);
  }
}
