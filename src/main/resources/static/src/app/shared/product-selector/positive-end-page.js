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
 * Object to represent positiveEndPage of the product selector
 * @author ccasallas
 *
*/
var PositiveEndPage = (function () {
    function PositiveEndPage() {
    }
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', String)
    ], PositiveEndPage.prototype, "titleText", void 0);
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', String)
    ], PositiveEndPage.prototype, "letsGoButtonText", void 0);
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', String)
    ], PositiveEndPage.prototype, "productLink", void 0);
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', String)
    ], PositiveEndPage.prototype, "noThanksText", void 0);
    PositiveEndPage = __decorate([
        typedjson_npm_1.JsonObject, 
        __metadata('design:paramtypes', [])
    ], PositiveEndPage);
    return PositiveEndPage;
}());
exports.PositiveEndPage = PositiveEndPage;
//# sourceMappingURL=positive-end-page.js.map