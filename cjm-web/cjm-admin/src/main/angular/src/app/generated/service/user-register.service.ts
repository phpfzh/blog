import {Inject, Injectable, Optional} from '@angular/core';
import {HttpHeaders} from "@angular/common/http";
import {BASE_PATH} from "../variables";
import {Configuration} from "../configuration";
import {_HttpClient} from "@delon/theme";
import {Observable} from "rxjs/index";

@Injectable()
export class UserRegisterService {
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

  //生成用户名
  generateUserName():Observable<any>{
     return this.httpClient.post<any>(`${this.basePath}/api/generateUserName`,null,{"_allow_anonymous":true});
  }

  //发送注册手机短信验证码
  ssmRegCode(mobile:string):Observable<any>{
    return this.httpClient.post<any>(`${this.basePath}/api/ssmRegCode`,null,{"mobile":mobile,"_allow_anonymous":true});
  }

  //注册
  register(mobile:string,password:string,code:string,username?:string,email?:string):Observable<any>{
    return this.httpClient.post<any>(`${this.basePath}/api/register`,null,{
      "_allow_anonymous":true,
      "mobile":mobile,
      "password":password,
      "code":code,
      "username":username,
      "email":email,
    });
  }
}
