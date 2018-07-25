import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ForumForumListComponent } from './list/list.component';

const routes: Routes = [

  { path: 'list', component: ForumForumListComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ForumForumRoutingModule { }
