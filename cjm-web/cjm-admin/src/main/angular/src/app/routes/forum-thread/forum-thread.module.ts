import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import { ForumThreadRoutingModule } from './forum-thread-routing.module';
import { ForumThreadListComponent } from './list/list.component';
import { ForumThreadViewListComponent } from './view-list/view-list.component';
import { ForumThreadDelListComponent } from './del-list/del-list.component';
import { ForumThreadRestoreListComponent } from './restore-list/restore-list.component';
import { ForumThreadStaticListComponent } from './static-list/static-list.component';

const COMPONENTS = [
  ForumThreadListComponent,
  ForumThreadViewListComponent,
  ForumThreadDelListComponent,
  ForumThreadRestoreListComponent,
  ForumThreadStaticListComponent];
const COMPONENTS_NOROUNT = [
  ];

@NgModule({
  imports: [
    SharedModule,
    ForumThreadRoutingModule
  ],
  declarations: [
    ...COMPONENTS,
    ...COMPONENTS_NOROUNT
  ],
  entryComponents: COMPONENTS_NOROUNT
})
export class ForumThreadModule { }
