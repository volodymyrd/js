import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';

import {HomeComponent} from './home.component';
import {LoginComponent} from './login.component';
import {ProfileComponent} from './profile.component';

import {AuthService} from './auth.service';
import {HttpModule} from '@angular/http';



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
  providers: [AuthService]
})
export class CompsModule {

}
