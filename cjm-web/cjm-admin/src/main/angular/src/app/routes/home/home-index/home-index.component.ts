import {Component, OnInit} from '@angular/core';
import {HomeIndexService} from "../../../generated/service/home-index.service";

@Component({
  selector: 'app-home-index',
  templateUrl: './home-index.component.html',
  styleUrls: ['./home.component.less']
})
export class HomeIndexComponent implements OnInit {

  pageSize:number = 20;
  total: number;
  list: any[];

  constructor(private  homeIndexService: HomeIndexService) {
  }

  ngOnInit() {
     this.getTheadData(this.pageSize,1);
   }

  chPageIndexChange(val:number){
     this.getTheadData(this.pageSize,val);
  }

  chPageSizeChange(val:number){
    this.pageSize = val;
    this.getTheadData(val,1);
  }

  getTheadData(pageSize?:number,pageNum?:number,fid?:number){
    this.homeIndexService.threadList(pageSize,pageNum,fid).subscribe(rep => {
        if(rep.code == "88"){
           this.list = rep.data.list;
           this.total = rep.data.total;
        }
    });
  }
}
