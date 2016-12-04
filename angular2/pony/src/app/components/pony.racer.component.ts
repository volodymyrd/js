import {Component} from "@angular/core";
import {Title} from "@angular/platform-browser";
import {RaceService} from "../services/race.service";

@Component({
    selector: 'ponyracer-app',
    viewProviders: [Title],
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

    constructor(title: Title, private raceService: RaceService) {
        console.log('raceService:' + raceService);

        title.setTitle('PonyRacer - Bet on ponies');
    }

    list() {
        return this.raceService.list();
    }
}
