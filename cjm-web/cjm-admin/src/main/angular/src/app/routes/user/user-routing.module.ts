import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserUserComponent } from './user/user.component';

const routes: Routes = [

  { path: 'list', component: UserUserComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
