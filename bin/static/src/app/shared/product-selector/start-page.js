"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var typedjson_npm_1 = require('typedjson-npm');
/**
 * Object to represent startPage of the product selector
 * @author ccasallas
 *
*/
var StartPage = (function () {
    function StartPage() {
    }
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', String)
    ], StartPage.prototype, "titleText", void 0);
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', String)
    ], StartPage.prototype, "startButtonText", void 0);
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', String)
    ], StartPage.prototype, "productLink", void 0);
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', String)
    ], StartPage.prototype, "notShureText", void 0);
    StartPage = __decorate([
        typedjson_npm_1.JsonObject, 
        __metadata('design:paramtypes', [])
    ], StartPage);
    return StartPage;
}());
exports.StartPage = StartPage;
//# sourceMappingURL=start-page.js.map