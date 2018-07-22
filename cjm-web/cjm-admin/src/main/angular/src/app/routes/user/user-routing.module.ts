import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {UserUserComponent} from './user/user.component';
import {UserList2Component} from './list2/list2.component';
import {UserList3Component} from './list3/list3.component';
import {UserList4Component} from './list4/list4.component';

const routes: Routes = [

  {path: 'list', component: UserUserComponent},
  {path: 'list2', component: UserList2Component},
  {path: 'list3', component: UserList3Component},
  {path: 'list4', component: UserList4Component}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule {
}
