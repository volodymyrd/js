import {NgModule}             from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProfileComponent} from './comps/profile.component';
import {LoginComponent} from './comps/login.component';
import {HomeComponent} from './comps/home.component';
import {AuthGuard} from './comps/auth-guard.service';

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'profile', component: ProfileComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
