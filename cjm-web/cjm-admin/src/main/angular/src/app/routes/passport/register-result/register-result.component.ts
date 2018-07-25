import {Component, Inject, OnInit} from '@angular/core';
import { NzMessageService } from 'ng-zorro-antd';
import {DA_SERVICE_TOKEN, ITokenModel, TokenService} from "@delon/auth";

@Component({
  selector: 'passport-register-result',
  templateUrl: './register-result.component.html'
})
export class UserRegisterResultComponent implements OnInit{

  username:any;

  constructor(public msg: NzMessageService,@Inject(DA_SERVICE_TOKEN) private tokenService: TokenService) {}

  ngOnInit(): void {
      const tokenData = this.tokenService.get();
      if(tokenData){
          this.username = tokenData.username;
      }
  }

}
