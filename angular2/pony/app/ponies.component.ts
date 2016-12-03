import {Component} from "@angular/core";
import {Pony} from "./model/pony";

@Component({
    selector: 'ns-ponies',
    template: `<div>
    <h2>Ponies</h2>
    <!--[pony]="currentPony"-->
    <ns-pony *ngFor="let currentPony of ponies" [pony]="currentPony" (ponySelected)="betOnPony($event)"></ns-pony>
    </div>
    `
})
export class PoniesComponent {
    ponies: Array<Pony> = [{id: 1, name: 'Rainbow Dash'}, {id: 2, name: 'Pinkie Pie'}, {id: 3, name: 'Fluttershy'}];

    betOnPony(pony) {
        console.log(pony);
    }
}