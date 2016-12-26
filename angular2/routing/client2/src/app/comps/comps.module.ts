import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';

import {HomeComponent} from './home.component';
import {LoginComponent} from './login.component';
import {ProfileComponent} from './profile.component';

import {AuthService} from './auth.service';
import {HttpModule} from '@angular/http';
import {AuthGuard} from './auth-guard.service';
import {HttpClient} from './http-client';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
  ],
  declarations: [
    HomeComponent,
    LoginComponent,
    ProfileComponent,
  ],
  providers: [AuthGuard, AuthService, HttpClient,]
})
export class CompsModule {

}
