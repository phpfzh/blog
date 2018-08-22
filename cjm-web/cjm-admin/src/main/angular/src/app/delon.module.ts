/**
 * 进一步对基础模块的导入提炼
 * 有关模块注册指导原则请参考：https://github.com/cipchk/ng-alain/issues/180
 */
import {
  NgModule,
  Optional,
  SkipSelf,
  ModuleWithProviders,
} from '@angular/core';
import {RouteReuseStrategy} from '@angular/router';
import {throwIfAlreadyLoaded} from '@core/module-import-guard';

import {NgZorroAntdModule} from 'ng-zorro-antd';
import {ALAIN_I18N_TOKEN, AlainI18NService, AlainThemeModule, WINDOW} from '@delon/theme';
import {DelonABCModule, ReuseTabService, ReuseTabStrategy} from '@delon/abc';
import {DelonAuthModule} from '@delon/auth';
import {DelonACLModule} from '@delon/acl';
import {DelonCacheModule} from '@delon/cache';
import {DelonUtilModule} from '@delon/util';

// region: global config functions

import {AdSimpleTableConfig} from '@delon/abc';

export function simpleTableConfig(): AdSimpleTableConfig {
  return Object.assign(new AdSimpleTableConfig(), <AdSimpleTableConfig>{
    ps:20,
    reqReName: {pi: "pageNum", ps: "pageSize"},
    resReName: {total: "data.total", list: "data.list"},
    pagePlacement: 'right',
    showSizeChanger:true,
    bordered:true
  });
}

import {AdPageHeaderConfig} from '@delon/abc';

export function pageHeaderConfig(): AdPageHeaderConfig {
  return Object.assign(new AdPageHeaderConfig(), {home_i18n: 'home'});
}

import {DelonAuthConfig} from '@delon/auth';

export function delonAuthConfig(): DelonAuthConfig {
  return Object.assign(new DelonAuthConfig(), <DelonAuthConfig>{
    login_url: '/passport/login',
    ignores: [/\/login/, /passport\//, /\/passport\/register-result/],
    token_send_template: 'Bearer ${token}'
  });
}

//api 请求域名定义
import {Configuration} from './generated/configuration';
import {ApiModule} from './generated/api.module';
import {BASE_PATH} from "./generated/variables";

export function apiConfig(): Configuration {
  return new Configuration({
    //这里可以给一些全局默认配置
  });
}

// endregion

@NgModule({
  imports: [
    NgZorroAntdModule.forRoot(),
    AlainThemeModule.forRoot(),
    DelonABCModule.forRoot(),
    DelonAuthModule.forRoot(),
    DelonACLModule.forRoot(),
    DelonCacheModule.forRoot(),
    DelonUtilModule.forRoot(),
    ApiModule.forRoot(apiConfig)
  ],
})
export class DelonModule {
  constructor(
    @Optional()
    @SkipSelf()
      parentModule: DelonModule,
  ) {
    throwIfAlreadyLoaded(parentModule, 'DelonModule');
  }

  static forRoot(): ModuleWithProviders {
    return {
      ngModule: DelonModule,
      providers: [
        // TIPS：若不需要路由复用需要移除以下代码及模板`<reuse-tab></reuse-tab>`
        {
          provide: RouteReuseStrategy,
          useClass: ReuseTabStrategy,
          deps: [ReuseTabService],
        },
        // TIPS：@delon/abc 有大量的全局配置信息，例如设置所有 `simple-table` 的页码默认为 `20` 行
        {provide: AdSimpleTableConfig, useFactory: simpleTableConfig},
        {provide: AdPageHeaderConfig, useFactory: pageHeaderConfig},
        {provide: DelonAuthConfig, useFactory: delonAuthConfig},
        //http 域名配置
        {provide: BASE_PATH, useValue: "http://www.chenjiaming.com"}

      ],
    };
  }
}
