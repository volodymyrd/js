"use strict";
var MockRaceService = (function () {
    function MockRaceService() {
    }
    MockRaceService.prototype.list = function () {
        return [{ name: 'London' }, { name: 'Kyiv' }];
    };
    return MockRaceService;
}());
exports.MockRaceService = MockRaceService;
