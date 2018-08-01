import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import { ThreadReplayRoutingModule } from './thread-replay-routing.module';
import { ThreadReplayListComponent } from './list/list.component';
import { ThreadReplayViewListComponent } from './view-list/view-list.component';
import { ThreadReplayDelListComponent } from './del-list/del-list.component';

const COMPONENTS = [
  ThreadReplayListComponent,
  ThreadReplayViewListComponent,
  ThreadReplayDelListComponent];
const COMPONENTS_NOROUNT = [];

@NgModule({
  imports: [
    SharedModule,
    ThreadReplayRoutingModule
  ],
  declarations: [
    ...COMPONENTS,
    ...COMPONENTS_NOROUNT
  ],
  entryComponents: COMPONENTS_NOROUNT
})
export class ThreadReplayModule { }
