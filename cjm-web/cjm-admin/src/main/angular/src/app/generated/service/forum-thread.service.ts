import {Inject, Injectable, Optional} from '@angular/core';
import {HttpHeaders} from "@angular/common/http";
import {BASE_PATH} from "../variables";
import {Configuration} from "../configuration";
import {_HttpClient} from "@delon/theme";
import {Observable} from "rxjs/index";

@Injectable()
export class ForumThreadService {

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

//保存
  insertForumThread(fid: number, threadtype: number, subject: string, content: string, tags?: string, usesig?: number): Observable<any> {
    return this.httpClient.post<any>(`${this.basePath}/api/forumThread/insertForumThread`, null, {
      "fid": fid,
      "threadtype": threadtype,
      "subject": subject,
      "content": content,
      "tags": tags,
      "usesig": usesig,
    });
  }


  indexList(pageSize?: any, pageNum?: any, fid?: any): Observable<any> {
    return this.httpClient.get<any>(`${this.basePath}/api/forumThreadApi/list`, {
      "pageNum": pageNum == undefined ? "" : pageNum,
      "pageSize": pageSize == undefined ? "" : pageSize,
      "fid": fid == undefined ? "" : fid,
      "_allow_anonymous": true
    });
  }
}
