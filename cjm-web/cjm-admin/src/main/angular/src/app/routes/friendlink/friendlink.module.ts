import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import { FriendlinkRoutingModule } from './friendlink-routing.module';
import { FriendlinkListComponent } from './list/list.component';
import { FriendlinkEditComponent } from './edit/edit.component';

const COMPONENTS = [
  FriendlinkListComponent];
const COMPONENTS_NOROUNT = [
  FriendlinkEditComponent];

@NgModule({
  imports: [
    SharedModule,
    FriendlinkRoutingModule
  ],
  declarations: [
    ...COMPONENTS,
    ...COMPONENTS_NOROUNT
  ],
  entryComponents: COMPONENTS_NOROUNT
})
export class FriendlinkModule { }
