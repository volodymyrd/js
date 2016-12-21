import {NgModule}             from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthGuard} from './auth-guard.service';

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: '/heroes',
    pathMatch: 'full'
  },
  {
    path: 'admin',
    redirectTo: 'admin',
    canLoad: [AuthGuard]
  },
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
