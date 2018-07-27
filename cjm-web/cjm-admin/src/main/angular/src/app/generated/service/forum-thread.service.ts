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
  audit(status: number, tid: string) : Observable<any> {
    return this.httpClient.post<any>(`${this.basePath}/api/forumThread/auditForumThread`, null, {
      "status": status,
      "tid": tid
    });
  }

//保存
  insertForumThread(fid:number,threadtype:number,subject:string,content:string,usesig?:number): Observable<any> {
    return this.httpClient.post<any>(`${this.basePath}/api/forumThreadApi/insertForumThread`, null,{
      "fid": fid,
      "threadtype": threadtype,
      "subject": subject,
      "content": content,
      "usesig": usesig,
    });
  }

}
