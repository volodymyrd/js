import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {PonyRacerAppComponent} from "./app.component";
import {RacesComponent} from "./races.component";
import {PoniesComponent} from "./ponies.component";
import {ApiService} from "./services/api.service";
import {RaceService} from "./services/race.service";
import {MockRaceService} from "./services/mock/mock.race.service";

@NgModule({
    imports: [BrowserModule],
    declarations: [PonyRacerAppComponent, RacesComponent, PoniesComponent],
    providers: [ApiService,

        {provide: RaceService, useClass: MockRaceService}
    ],
    bootstrap: [PonyRacerAppComponent]
})
export class AppModule {
}