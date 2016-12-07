import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {HeroService} from "./services/hero.service";
import {AppComponent} from "./app.component";
import {HeroDetailComponent} from "./heroes/hero-detail.component";
import {HeroesComponent} from "./heroes/heroes.component";


@NgModule({
  declarations: [
    AppComponent, HeroesComponent, HeroDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [HeroService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
