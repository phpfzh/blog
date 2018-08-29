import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FriendlinkListComponent } from './list/list.component';

const routes: Routes = [

  { path: 'list', component: FriendlinkListComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FriendlinkRoutingModule { }
