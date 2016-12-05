import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {RegisterFormComponent} from "./components/user/register-form.component";
import {PoniesComponent} from "./components/ponies.component";
import {PonyComponent} from "./components/pony.component";
import {PonyRacerAppComponent} from "./components/pony.racer.component";
import {RacesComponent} from "./components/races.component";

@NgModule({
  declarations: [
    AppComponent, PoniesComponent, PonyComponent, PonyRacerAppComponent, RacesComponent, RegisterFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
