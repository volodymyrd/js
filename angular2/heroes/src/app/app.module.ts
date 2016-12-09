import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {HeroService} from "./services/hero.service";
import {AppComponent} from "./app.component";
import {HeroDetailComponent} from "./heroes/hero-detail.component";
import {HeroesComponent} from "./heroes/heroes.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {AppRoutingModule} from "./app-routing.module";

// Imports for loading & configuring the in-memory web api
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import {InMemoryDataService} from "./services/in-memory-data.service";

@NgModule({
  declarations: [
    AppComponent, HeroesComponent, HeroDetailComponent, DashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    InMemoryWebApiModule.forRoot(InMemoryDataService),
  ],
  providers: [HeroService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
