"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var PoniesComponent = (function () {
    function PoniesComponent() {
        this.ponies = [{ id: 1, name: 'Rainbow Dash' }, { id: 2, name: 'Pinkie Pie' }, { id: 3, name: 'Fluttershy' }];
    }
    PoniesComponent.prototype.betOnPony = function (pony) {
        console.log(pony);
    };
    PoniesComponent = __decorate([
        core_1.Component({
            selector: 'ns-ponies',
            template: "<div>\n    <h2>Ponies</h2>\n    <!--[pony]=\"currentPony\"-->\n    <ns-pony *ngFor=\"let currentPony of ponies\" [pony]=\"currentPony\" (ponySelected)=\"betOnPony($event)\"></ns-pony>\n    </div>\n    "
        })
    ], PoniesComponent);
    return PoniesComponent;
}());
exports.PoniesComponent = PoniesComponent;
