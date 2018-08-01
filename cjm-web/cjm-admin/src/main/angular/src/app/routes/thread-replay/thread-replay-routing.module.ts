import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ThreadReplayListComponent } from './list/list.component';
import { ThreadReplayViewListComponent } from './view-list/view-list.component';
import { ThreadReplayDelListComponent } from './del-list/del-list.component';

const routes: Routes = [

  { path: 'list', component: ThreadReplayListComponent },
  { path: 'viewList', component: ThreadReplayViewListComponent },
  { path: 'delList', component: ThreadReplayDelListComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ThreadReplayRoutingModule { }
