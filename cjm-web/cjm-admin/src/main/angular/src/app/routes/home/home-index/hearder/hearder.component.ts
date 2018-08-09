import {Component, Input, OnInit} from '@angular/core';
import {HomeIndexService} from "../../../../generated/service/home-index.service";

@Component({
  selector: 'app-home-index-hearder',
  templateUrl: './hearder.component.html',
  styleUrls: ['./hearder.component.less']
})
export class HearderComponent implements OnInit {

  headerdata: any[] = [];

  constructor(private  homeIndexService: HomeIndexService) { }

  ngOnInit() {
    this.homeIndexService.forumList().subscribe(rep => {
      if (rep.code == "88") {
        this.headerdata = rep.data.list
      }
    });
  }

}
