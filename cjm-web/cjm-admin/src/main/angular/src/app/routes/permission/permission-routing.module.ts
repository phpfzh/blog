import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PermissionRoleComponent } from './role/role.component';

const routes: Routes = [

  { path: 'role', component: PermissionRoleComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PermissionRoutingModule { }
