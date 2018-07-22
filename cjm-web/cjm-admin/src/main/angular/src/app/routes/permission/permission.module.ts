import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import { PermissionRoutingModule } from './permission-routing.module';
import { PermissionRoleComponent } from './role/role.component';

const COMPONENTS = [
  PermissionRoleComponent];
const COMPONENTS_NOROUNT = [];

@NgModule({
  imports: [
    SharedModule,
    PermissionRoutingModule
  ],
  declarations: [
    ...COMPONENTS,
    ...COMPONENTS_NOROUNT
  ],
  entryComponents: COMPONENTS_NOROUNT
})
export class PermissionModule { }
