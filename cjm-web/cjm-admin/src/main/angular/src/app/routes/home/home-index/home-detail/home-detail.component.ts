import {Component, OnInit} from '@angular/core';
import {HomeIndexService} from "../../../../generated/service/home-index.service";
import {ActivatedRoute, NavigationEnd, Router} from "@angular/router";
import {DomSanitizer, Title} from "@angular/platform-browser";
import {Thread} from "../../../../generated/model/thread";

@Component({
  selector: 'app-home-detail',
  templateUrl: './home-detail.component.html',
  styleUrls: ['./home.detail.component.less']
})
export class HomeDetailComponent implements OnInit {

  public threadData: Thread;
  tid: any;
  tagFlag: boolean = false;
  detail: boolean = true;
  detailContent: any;

  constructor(private  homeIndexService: HomeIndexService,
              private sanitizer: DomSanitizer,
              private titleService: Title,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.params.subscribe(p => this.tid = p.tid);
    this.homeIndexService.forumThreadView(this.tid).subscribe(rep => {
      if (rep.code == "88") {
        this.detail = true;
        if (rep.data.listtags.length > 0) {
          this.tagFlag = true
        }
        this.threadData = rep.data;
        this.titleService.setTitle(rep.data.subject+"-陈嘉明个人博客");
      } else {
        this.detail = false;
        this.detailContent = rep.message;
      }
    });

  }

}
