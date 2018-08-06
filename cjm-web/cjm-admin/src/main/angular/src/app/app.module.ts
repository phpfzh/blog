import {NgModule, LOCALE_ID, APP_INITIALIZER, Injector} from '@angular/core';
import {HttpClient, HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {DelonModule} from './delon.module';
import {CoreModule} from './core/core.module';
import {SharedModule} from './shared/shared.module';
import {AppComponent} from './app.component';
import {RoutesModule} from './routes/routes.module';
import {LayoutModule} from './layout/layout.module';
import {StartupService} from '@core/startup/startup.service';
import {DefaultInterceptor} from '@core/net/default.interceptor';
import {SimpleInterceptor} from '@delon/auth';

// angular i18n
import {registerLocaleData} from '@angular/common';
import localeZhHans from '@angular/common/locales/zh-Hans';

registerLocaleData(localeZhHans);

// @delon/form: JSON Schema form
import {JsonSchemaModule} from '@shared/json-schema/json-schema.module';
import {UeditorComponent} from "./routes/ueditor/ueditor.component";
import {UEditorModule} from "ngx-ueditor";
import { HearderComponent } from './routes/home/home-index/hearder/hearder.component';
import { FooterComponent } from './routes/home/home-index/footer/footer.component';
import { ContentComponent } from './routes/home/home-index/content/content.component';
import { HomeIndexComponent } from './routes/home/home-index/home-index.component';
import {HeaderSearchComponent} from "./routes/home/home_search.component";
import {HomeDetailComponent} from "./routes/home/home-index/home-detail/home-detail.component";
import {HomeProjectListComponent} from "./routes/home/home-index/home-project-list/home-project-list.component";


/*export function StartupServiceFactory(startupService: StartupService): Function {
  return () => startupService.load();
}*/

@NgModule({
  declarations: [
    AppComponent,
    UeditorComponent,
    HearderComponent,
    FooterComponent,
    ContentComponent,
    HomeIndexComponent,
    HeaderSearchComponent,
    HomeDetailComponent,
    HomeProjectListComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    DelonModule.forRoot(),
    CoreModule,
    SharedModule,
    LayoutModule,
    RoutesModule,
    UEditorModule.forRoot({
      js: [
        `http://admin.chenjiaming.com/admin/assets/ueditor/ueditor.all.js`,
        `http://admin.chenjiaming.com/admin/assets/ueditor/ueditor.config.js`,
      ],
      options: {
        UEDITOR_HOME_URL: 'http://admin.chenjiaming.com/admin/assets/ueditor/'
      }
    }),
    // JSON-Schema form
    JsonSchemaModule
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'zh-Hans'},
    {provide: HTTP_INTERCEPTORS, useClass: SimpleInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: DefaultInterceptor, multi: true},
    StartupService
    /*{
      provide: APP_INITIALIZER,
      useFactory: StartupServiceFactory,
      deps: [StartupService],
      multi: true
    }*/
  ],
  bootstrap: [AppComponent]
})
export class AppModule {


}
