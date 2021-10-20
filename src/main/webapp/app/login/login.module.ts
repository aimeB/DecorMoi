import { NgModule } from '@angular/core';

import { SharedModule } from 'app/shared/shared.module';

import { LoginComponent } from './login.component';
import { LOGIN_ROUTE } from './login.route';
import { RouterModule } from '@angular/router';
@NgModule({
  imports: [SharedModule, RouterModule.forChild([LOGIN_ROUTE])],
  declarations: [LoginComponent],
})
export class LoginModule {}
