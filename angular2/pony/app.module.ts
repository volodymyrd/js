import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {PonyRacerAppComponent} from "./app.component";

@NgModule({
    imports: [BrowserModule],
    declarations: [PonyRacerAppComponent],
    bootstrap: [PonyRacerAppComponent]
})
export class AppModule {
}