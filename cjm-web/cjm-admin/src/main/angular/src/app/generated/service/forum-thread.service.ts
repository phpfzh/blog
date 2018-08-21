import {Inject, Injectable, Optional} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {BASE_PATH} from "../variables";
import {Configuration} from "../configuration";
import {_HttpClient} from "@delon/theme";
import {Observable} from "rxjs/index";
import {Thread} from "../model/thread";

@Injectable()
export class ForumThreadService {

  protected basePath = 'https://petstore.swagger.io/v2';
  public defaultHeaders = new HttpHeaders();
  public configuration = new Configuration();

  constructor(protected httpClient: _HttpClient,
              protected httpClient2: HttpClient,
              @Optional() @Inject(BASE_PATH) basePath: string, @Optional() configuration: Configuration) {
    if (basePath) {
      this.basePath = basePath;
    }
    if (configuration) {
      this.configuration = configuration;
      this.basePath = basePath || configuration.basePath || this.basePath;
    }
  }

  //批量审核
  auditBatchForumThread(status: number, tids: string): Observable<any> {
    return this.httpClient.post<any>(`${this.basePath}/api/forumThread/auditBatchForumThread`, null, {
      "status": status,
      "tids": tids
    });
  }

//审核
  audit(status: number, tid: string): Observable<any> {
    return this.httpClient.post<any>(`${this.basePath}/api/forumThread/auditForumThread`, null, {
      "status": status,
      "tid": tid
    });
  }

  //恢复
  restore(tid: string): Observable<any> {
    return this.httpClient.post<any>(`${this.basePath}/api/forumThread/auditForumThread`, null, {
      "status": 1,
      "tid": tid
    });
  }

  //批量恢复
  restoreBatchThread(tids: string): Observable<any> {
    return this.httpClient.post<any>(`${this.basePath}/api/forumThread/auditBatchForumThread`, null, {
      "status": 1,
      "tids": tids
    });
  }

  //删除
  delThread(tid: string): Observable<any> {
    return this.httpClient.post<any>(`${this.basePath}/api/forumThread/auditForumThread`, null, {
      "status": 0,
      "tid": tid
    });
  }

  //批量删除
  delBatchThread(tids: string): Observable<any> {
    return this.httpClient.post<any>(`${this.basePath}/api/forumThread/auditBatchForumThread`, null, {
      "status": 0,
      "tids": tids
    });
  }

  transformRequest(data) {
    var str = '';
    for (var i in data) {
      str += i + '=' + data[i] + '&';
    }
    str.substring(0, str.length - 1);
    return str;

  };

  //保存
  insertForumThread(thread: Thread): Observable<any> {
    let headers = this.defaultHeaders;
    headers = headers.set("Content-Type", "application/x-www-form-urlencoded");
    return this.httpClient2.post<any>(`${this.basePath}/api/forumThread/insertForumThread`,
      this.transformRequest(thread),
      {
        headers: headers
      }
    );
  }

  //查询
  getForumThreadByTid(tid: number): Observable<any> {
    return this.httpClient.get<any>(`${this.basePath}/api/forumThread/getForumThreadByTid`, {
      "tid": tid,
    });
  }

  //修改
  updateForumThread(thread:Thread): Observable<any> {
     let headers = this.defaultHeaders;
    headers = headers.set("Content-Type", "application/x-www-form-urlencoded");
    return this.httpClient2.post<any>(`${this.basePath}/api/forumThread/updateForumThread`,
      this.transformRequest(thread),
      {
        headers: headers
      }
    );
  }

  //静态化
  staticHtml(tid: number): Observable<any> {
    return this.httpClient.post<any>(`${this.basePath}/static/staticHtml`, null, {
      "tid": tid
    });
  }

  //批量静态化
  batchStaticHtml(tids: string): Observable<any> {
    return this.httpClient.post<any>(`${this.basePath}/static/batchStaticHtml`, null, {
      "tids": tids
    });
  }
}
