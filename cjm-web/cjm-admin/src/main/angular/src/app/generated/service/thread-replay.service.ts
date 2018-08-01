import {Inject, Injectable, Optional} from '@angular/core';
import {HttpHeaders} from "@angular/common/http";
import {BASE_PATH} from "../variables";
import {Configuration} from "../configuration";
import {_HttpClient} from "@delon/theme";
import {Observable} from "rxjs/index";

@Injectable()
export class ThreadReplayService {

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

//审核
  audit(status: number, repayIds: string,remark?:string) : Observable<any> {
    return this.httpClient.post<any>(`${this.basePath}/api/forumThreadReplay/auditForumThreadReplay`, null, {
      "status": status,
      "repayIds": repayIds,
      "remark":remark
    });
  }

  //删除
  delThreadReplay(repayIds: string) : Observable<any> {
    return this.httpClient.post<any>(`${this.basePath}/api/forumThreadReplay/delBatchForumThreadReplay`, null, {
      "status": 0,
      "repayIds": repayIds
    });
  }

}
