"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var platform_browser_1 = require("@angular/platform-browser");
var PonyRacerAppComponent = (function () {
    function PonyRacerAppComponent(title, raceService) {
        this.raceService = raceService;
        console.log('raceService:' + raceService);
        title.setTitle('PonyRacer - Bet on ponies');
    }
    PonyRacerAppComponent.prototype.list = function () {
        return this.raceService.list();
    };
    PonyRacerAppComponent = __decorate([
        core_1.Component({
            selector: 'ponyracer-app',
            viewProviders: [platform_browser_1.Title],
            template: "\n      <h1>PonyRacer</h1>\n      <ns-races></ns-races>\n      <ns-ponies></ns-ponies>\n      <ul>\n        <li *ngFor=\"let e of list();\">{{e.name}}</li>\n      </ul>\n    "
        })
    ], PonyRacerAppComponent);
    return PonyRacerAppComponent;
}());
exports.PonyRacerAppComponent = PonyRacerAppComponent;
