import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {environment} from '@env/environment';
// layout
import {LayoutDefaultComponent} from '../layout/default/default.component';
import {LayoutFullScreenComponent} from '../layout/fullscreen/fullscreen.component';
import {LayoutPassportComponent} from '../layout/passport/passport.component';
// dashboard pages
import {DashboardComponent} from './dashboard/dashboard.component';
// passport pages
import {UserLoginComponent} from './passport/login/login.component';
import {UserRegisterComponent} from './passport/register/register.component';
import {UserRegisterResultComponent} from './passport/register-result/register-result.component';
// single pages
import {CallbackComponent} from './callback/callback.component';
import {UserLockComponent} from './passport/lock/lock.component';
import {Exception403Component} from './exception/403.component';
import {Exception404Component} from './exception/404.component';
import {Exception500Component} from './exception/500.component';
import {ForumForumModule} from "./forum-forum/forum-forum.module";
import {ForumThreadModule} from "./forum-thread/forum-thread.module";
import {UeditorComponent} from "./ueditor/ueditor.component";

const routes: Routes = [
  {
    path: '',
    component: LayoutDefaultComponent,
    children: [
      {path: '', redirectTo: 'dashboard', pathMatch: 'full', data: {title: '用户管理'}},
      {path: 'dashboard', component: DashboardComponent, data: {title: '仪表盘', titleI18n: 'dashboard'}},
      //版块
      { path: 'forumForum', loadChildren: './forum-forum/forum-forum.module#ForumForumModule' },
      //主题
      { path: 'forumThread', loadChildren: './forum-thread/forum-thread.module#ForumThreadModule' },
      //评论
      { path: 'threadReplay', loadChildren: './thread-replay/thread-replay.module#ThreadReplayModule' },


      // 业务子模块
      // { path: 'widgets', loadChildren: './widgets/widgets.module#WidgetsModule' }
    ]
  },
  // 全屏布局
  // {
  //     path: 'fullscreen',
  //     component: LayoutFullScreenComponent,
  //     children: [
  //     ]
  // },
  // passport
  {
    path: 'passport',
    component: LayoutPassportComponent,
    children: [
      {path: 'login', component: UserLoginComponent, data: {title: '登录', titleI18n: 'pro-login'}},
      {path: 'register', component: UserRegisterComponent, data: {title: '注册', titleI18n: 'pro-register'}},
      {
        path: 'register-result',
        component: UserRegisterResultComponent,
        data: {title: '注册结果', titleI18n: 'pro-register-result'}
      }
    ]
  },
  // 单页不包裹Layout
  {path: 'callback/:type', component: CallbackComponent},
  {path: 'editor', component: UeditorComponent, data: {title: '编辑页', titleI18n: 'editor'}},
  {path: 'lock', component: UserLockComponent, data: {title: '锁屏', titleI18n: 'lock'}},
  {path: '403', component: Exception403Component},
  {path: '404', component: Exception404Component},
  {path: '500', component: Exception500Component},
  {path: '**', redirectTo: 'dashboard'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: environment.useHash})],
  exports: [RouterModule]
})
export class RouteRoutingModule {
}
