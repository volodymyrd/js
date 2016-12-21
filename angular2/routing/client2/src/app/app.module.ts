import { NgModule } from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {CompsModule} from './comps/comps.module';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    AppRoutingModule,
    CompsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
