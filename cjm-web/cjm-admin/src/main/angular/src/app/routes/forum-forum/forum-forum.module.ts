import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import { ForumForumRoutingModule } from './forum-forum-routing.module';
import { ForumForumListComponent } from './list/list.component';

const COMPONENTS = [
  ForumForumListComponent];
const COMPONENTS_NOROUNT = [];

@NgModule({
  imports: [
    SharedModule,
    ForumForumRoutingModule
  ],
  declarations: [
    ...COMPONENTS,
    ...COMPONENTS_NOROUNT
  ],
  entryComponents: COMPONENTS_NOROUNT
})
export class ForumForumModule { }
