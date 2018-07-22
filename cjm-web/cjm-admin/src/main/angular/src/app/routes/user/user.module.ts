import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import { UserRoutingModule } from './user-routing.module';
import { UserUserComponent } from './user/user.component';
import { UserList2Component } from './list2/list2.component';
import { UserList3Component } from './list3/list3.component';
import { UserList4Component } from './list4/list4.component';
import {HeaderSearchComponent} from "./header.search.component";

const COMPONENTS = [
  UserUserComponent,
  UserList2Component,
  UserList3Component,
  UserList4Component,
  HeaderSearchComponent
];
const COMPONENTS_NOROUNT = [];

@NgModule({
  imports: [
    SharedModule,
    UserRoutingModule
  ],
  declarations: [
    ...COMPONENTS,
    ...COMPONENTS_NOROUNT
  ],
  entryComponents: COMPONENTS_NOROUNT
})
export class UserModule { }
