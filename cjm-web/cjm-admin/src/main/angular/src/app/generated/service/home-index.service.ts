import {Inject, Injectable, Optional} from '@angular/core';
import {HttpHeaders} from "@angular/common/http";
import {BASE_PATH} from "../variables";
import {Configuration} from "../configuration";
import {_HttpClient} from "@delon/theme";
import {Observable} from "rxjs/index";

@Injectable()
export class HomeIndexService {

  protected basePath = 'https://petstore.swagger.io/v2';
  public defaultHeaders = new HttpHeaders();
  public configuration = new Configuration();

  constructor(protected httpClient: _HttpClient, @Optional() @Inject(BASE_PATH) basePath: string, @Optional() configuration: Configuration) {
    if (basePath) {
      this.basePath = basePath;
    }
    if (configuration) {
      this.configuration = configuration;
      this.basePath = basePath || configuration.basePath || this.basePath;
    }
  }

  //查询栏目信息
  forumList(pageSize?: any, pageNum?: any): Observable<any> {
    return this.httpClient.get<any>(`${this.basePath}/api/forumThreadApi/forumList`, {
      "pageNum": pageNum == undefined ? 1 : pageNum,
      "pageSize": pageSize == undefined ? "7" : pageSize,
      "_allow_anonymous": true
    });
  }

  //查询主题列表
  threadList(pageSize?: any, pageNum?: any, fid?: any,orderType?:string): Observable<any> {
    return this.httpClient.get<any>(`${this.basePath}/api/forumThreadApi/list`, {
      "pageNum": pageNum == undefined ? "" : pageNum,
      "pageSize": pageSize == undefined ? "" : pageSize,
      "fid": fid == undefined ? "" : fid,
      "orderType": orderType == undefined ? "" : orderType,
      "_allow_anonymous": true
    });
  }

  //查询主题列表
  viewThreadList(pageSize?: any, pageNum?: any, fid?: any,orderType?:string): Observable<any> {
    return this.httpClient.get<any>(`${this.basePath}/api/forumThreadApi/list`, {
      "pageNum": pageNum == undefined ? "" : pageNum,
      "pageSize": pageSize == undefined ? "" : pageSize,
      "fid": fid == undefined ? "" : fid,
      "orderType": "views",
      "_allow_anonymous": true
    });
  }

  //查询单个主题
  forumThreadView(tid: any): Observable<any> {
    return this.httpClient.get<any>(`${this.basePath}/api/forumThreadApi/forumThreadView`, {
      "tid": tid,
      "_allow_anonymous": true
    });
  }
}
