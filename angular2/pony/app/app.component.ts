import {Component} from "@angular/core";
import {RaceService} from "./services/race.service";

@Component({
    selector: 'ponyracer-app',
    template: `
      <h1>PonyRacer</h1>
      <ns-races></ns-races>
      <ns-ponies></ns-ponies>
      <ul>
        <li *ngFor="let e of list();">{{e.name}}</li>
      </ul>
    `
})
export class PonyRacerAppComponent {

    constructor(private raceService: RaceService) {
        console.log('raceService:' + raceService);
    }

    list() {
        return this.raceService.list();
    }
}