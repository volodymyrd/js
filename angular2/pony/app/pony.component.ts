import {Component, Input, Output, EventEmitter, ViewEncapsulation} from "@angular/core";
import {Pony} from "./model/pony";

@Component({
    selector: 'ns-pony',
    encapsulation: ViewEncapsulation.None,
    styles: [`.red{color:red;}`],
    template: `<div class="red" (click)="selectPony()">{{pony.name}}</div>`,
})
export class PonyComponent {
    @Input() pony: Pony;
    @Output() ponySelected: EventEmitter<Pony> = new EventEmitter<Pony>();

    selectPony() {
        this.ponySelected.emit(this.pony);
    }
}