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
var core_1 = require('@angular/core');
var common_1 = require('@angular/common');
var forms_1 = require('@angular/forms');
var router_1 = require('@angular/router');
var material_1 = require('@angular/material');
//Angular 2 Localization.
var angular2localization_1 = require('angular2localization');
//IMP dependencies
var start_component_1 = require('./quote/start.component');
var quote_component_1 = require('./quote/quote.component');
var quick_quote_component_1 = require('./quote/quick-quote.component');
var quote_service_1 = require('./quote/quote.service');
var shared_module_1 = require('../shared/shared.module');
//import { IssuiongRoutingModule }     from './issuing-routing.module';
var IssuingModule = (function () {
    function IssuingModule() {
    }
    IssuingModule = __decorate([
        core_1.NgModule({
            imports: [common_1.CommonModule, shared_module_1.SharedModule, router_1.RouterModule, angular2localization_1.LocaleModule.forRoot(),
                angular2localization_1.LocalizationModule.forRoot(), forms_1.FormsModule, material_1.MaterialModule.forRoot(),
            ],
            declarations: [start_component_1.StartComponent, quote_component_1.QuoteComponent, quick_quote_component_1.QuickQuoteComponent, quote_component_1.FirstRiskLvlDialogComponent, quote_component_1.SecondRiskLvlDialogComponent],
            entryComponents: [quote_component_1.FirstRiskLvlDialogComponent, quote_component_1.SecondRiskLvlDialogComponent],
            exports: [start_component_1.StartComponent, quote_component_1.QuoteComponent, quick_quote_component_1.QuickQuoteComponent],
            providers: [quote_service_1.QuoteService]
        }), 
        __metadata('design:paramtypes', [])
    ], IssuingModule);
    return IssuingModule;
}());
exports.IssuingModule = IssuingModule;
//# sourceMappingURL=issuing.module.js.map