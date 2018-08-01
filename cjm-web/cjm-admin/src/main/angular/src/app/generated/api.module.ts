import {NgModule, ModuleWithProviders, SkipSelf, Optional} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {Configuration} from './configuration';
import {UserLoginService} from "./service/user-login.service";
import {UserRegisterService} from "./service/user-register.service";
import {ForumThreadService} from "./service/forum-thread.service";
import {ThreadReplayService} from "./service/thread-replay.service";

@NgModule({
  imports: [CommonModule, HttpClientModule],
  declarations: [],
  exports: [],
  providers: [
    UserLoginService,
    UserRegisterService,
    ForumThreadService,
    ThreadReplayService
  ]
})

export class ApiModule {
  public static forRoot(configurationFactory: () => Configuration): ModuleWithProviders {
    return {
      ngModule: ApiModule,
      providers: [{provide: Configuration, useFactory: configurationFactory}]
    }
  }

  constructor(@Optional() @SkipSelf() parentModule: ApiModule) {
    if (parentModule) {
      throw new Error('ApiModule is already loaded. Import your base AppModule only.');
    }
  }
}
