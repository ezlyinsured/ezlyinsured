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
var start_page_1 = require('./start-page');
var negative_end_page_1 = require('./negative-end-page');
var positive_end_page_1 = require('./positive-end-page');
var email_page_1 = require('./email-page');
var question_rail_1 = require('./question-rail');
/**
 * Object to represent product selector
 * @author ccasallas
 *
*/
var ProductSelector = (function () {
    function ProductSelector() {
        this.prueba = "prueba";
    }
    ProductSelector.prototype.test = function () {
        alert("prueba");
    };
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', start_page_1.StartPage)
    ], ProductSelector.prototype, "startPage", void 0);
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', question_rail_1.QuestionRail)
    ], ProductSelector.prototype, "questionRail", void 0);
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', positive_end_page_1.PositiveEndPage)
    ], ProductSelector.prototype, "positiveEndPage", void 0);
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', negative_end_page_1.NegativeEndPage)
    ], ProductSelector.prototype, "negativeEndPage", void 0);
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', email_page_1.EmailPage)
    ], ProductSelector.prototype, "emailPage", void 0);
    __decorate([
        typedjson_npm_1.JsonMember({ emitDefaultValue: true }), 
        __metadata('design:type', String)
    ], ProductSelector.prototype, "prueba", void 0);
    ProductSelector = __decorate([
        typedjson_npm_1.JsonObject, 
        __metadata('design:paramtypes', [])
    ], ProductSelector);
    return ProductSelector;
}());
exports.ProductSelector = ProductSelector;
//# sourceMappingURL=product-selector.js.map