import {Component} from "@angular/core";

@Component({
    selector: 'ponyracer-app',
    template: `
      <h1>PonyRacer</h1>
      <ns-races></ns-races>
      <ns-ponies></ns-ponies>
    `
})
export class PonyRacerAppComponent {
}