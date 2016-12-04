"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var PonyComponent = (function () {
    function PonyComponent() {
        this.ponySelected = new core_1.EventEmitter();
    }
    PonyComponent.prototype.selectPony = function () {
        this.ponySelected.emit(this.pony);
    };
    __decorate([
        core_1.Input()
    ], PonyComponent.prototype, "pony", void 0);
    __decorate([
        core_1.Output()
    ], PonyComponent.prototype, "ponySelected", void 0);
    PonyComponent = __decorate([
        core_1.Component({
            selector: 'ns-pony',
            encapsulation: core_1.ViewEncapsulation.None,
            styles: [".red{color:red;}"],
            template: "<div class=\"red\" (click)=\"selectPony()\">{{pony.name}}</div>",
        })
    ], PonyComponent);
    return PonyComponent;
}());
exports.PonyComponent = PonyComponent;
