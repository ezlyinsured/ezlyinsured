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
 * Object to represent questions of the rail question
 * @author ccasallas
 *
*/
var Question = (function () {
    function Question() {
    }
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', Number)
    ], Question.prototype, "id", void 0);
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', String)
    ], Question.prototype, "titleText", void 0);
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', String)
    ], Question.prototype, "questionText", void 0);
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', Number)
    ], Question.prototype, "onYes", void 0);
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', Number)
    ], Question.prototype, "onNo", void 0);
    __decorate([
        typedjson_npm_1.JsonMember, 
        __metadata('design:type', Number)
    ], Question.prototype, "onIdk", void 0);
    Question = __decorate([
        typedjson_npm_1.JsonObject, 
        __metadata('design:paramtypes', [])
    ], Question);
    return Question;
}());
exports.Question = Question;
//# sourceMappingURL=question.js.map