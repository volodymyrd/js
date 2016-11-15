import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {PonyRacerAppComponent} from "./app.component";
import {RacesComponent} from "./races.component";

@NgModule({
    imports: [BrowserModule],
    declarations: [PonyRacerAppComponent, RacesComponent],
    bootstrap: [PonyRacerAppComponent]
})
export class AppModule {
}