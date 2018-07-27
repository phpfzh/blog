
import { NgModule, LOCALE_ID, APP_INITIALIZER, Injector } from '@angular/core';
import { HttpClient, HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DelonModule } from './delon.module';
import { CoreModule } from './core/core.module';
import { SharedModule } from './shared/shared.module';
import { AppComponent } from './app.component';
import { RoutesModule } from './routes/routes.module';
import { LayoutModule } from './layout/layout.module';
import { StartupService } from '@core/startup/startup.service';
import { DefaultInterceptor } from '@core/net/default.interceptor';
import { SimpleInterceptor } from '@delon/auth';

// angular i18n
import { registerLocaleData } from '@angular/common';
import localeZhHans from '@angular/common/locales/zh-Hans';
registerLocaleData(localeZhHans);

// @delon/form: JSON Schema form
import { JsonSchemaModule } from '@shared/json-schema/json-schema.module';
import {UeditorComponent} from "./routes/ueditor/ueditor.component";
import {UEditorConfig, UEditorModule} from "ngx-ueditor";

export function StartupServiceFactory(startupService: StartupService): Function {
  return () => startupService.load();
}

export function ueditorConfig(): UEditorConfig {
  return Object.assign(new UEditorConfig(),{
    js:[
      `http://localhost:4200/assets/ueditor/ueditor.all.js`,
      `http://localhost:4200/assets/ueditor/ueditor.config.js`,
     ],
    options: {
      UEDITOR_HOME_URL:  'http://localhost:4200/assets/ueditor/'
     },
    hook:(UE:any):void => {
      UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
      UE.Editor.prototype.getActionUrl = function (action) {
        if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadimage') {
          return 'http://localhost:8080/uploadimage';
        } else if (action == 'uploadvideo') {
          return 'http://localhost:8080/uploadvideo';
        } else {
          return this._bkGetActionUrl.call(this, action);
        }
      }

    }
  });
}

@NgModule({
  declarations: [
    AppComponent,
    UeditorComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    DelonModule.forRoot(),
    UEditorModule.forRoot(ueditorConfig()),
    CoreModule,
    SharedModule,
    LayoutModule,
    RoutesModule,
    // JSON-Schema form
    JsonSchemaModule
   ],
  providers: [
     { provide: LOCALE_ID, useValue: 'zh-Hans' },
    { provide: HTTP_INTERCEPTORS, useClass: SimpleInterceptor, multi: true},
    { provide: HTTP_INTERCEPTORS, useClass: DefaultInterceptor, multi: true},
     StartupService,
    {
      provide: APP_INITIALIZER,
      useFactory: StartupServiceFactory,
      deps: [StartupService],
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
