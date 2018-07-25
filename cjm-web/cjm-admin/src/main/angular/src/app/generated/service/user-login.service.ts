import {Inject, Injectable, Optional} from '@angular/core';
import {_HttpClient} from "@delon/theme";
import {HttpHeaders} from "@angular/common/http";
import {Configuration} from "../configuration";
import {BASE_PATH} from "../variables";
import {Observable} from "rxjs/index";

@Injectable()
export class UserLoginService {

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

  //用户登录
  login(username:string,password:string):Observable<any>{
    return this.httpClient.post<any>(`${this.basePath}/api/login`,null,{"username":username,"password":password,"_allow_anonymous":true})
  }


}
