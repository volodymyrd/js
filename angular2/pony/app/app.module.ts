import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {PonyRacerAppComponent} from "./app.component";
import {RacesComponent} from "./races.component";
import {PoniesComponent} from "./ponies.component";

@NgModule({
    imports: [BrowserModule],
    declarations: [PonyRacerAppComponent, RacesComponent, PoniesComponent],
    bootstrap: [PonyRacerAppComponent]
})
export class AppModule {
}