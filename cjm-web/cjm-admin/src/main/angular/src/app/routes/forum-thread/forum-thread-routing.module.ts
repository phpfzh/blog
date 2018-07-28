import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ForumThreadListComponent } from './list/list.component';
import { ForumThreadViewListComponent } from './view-list/view-list.component';
import { ForumThreadDelListComponent } from './del-list/del-list.component';
import { ForumThreadRestoreListComponent } from './restore-list/restore-list.component';

const routes: Routes = [

  { path: 'list', component: ForumThreadListComponent },
  { path: 'viewList', component: ForumThreadViewListComponent },
  { path: 'delList', component: ForumThreadDelListComponent },
  { path: 'restoreList', component: ForumThreadRestoreListComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ForumThreadRoutingModule { }
