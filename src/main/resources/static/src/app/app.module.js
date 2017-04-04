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
var platform_browser_1 = require('@angular/platform-browser');
var http_1 = require('@angular/http');
var forms_1 = require('@angular/forms');
//Angular 2 Localization.
var angular2localization_1 = require('angular2localization');
//IMP dependencies
var app_component_1 = require('./app.component');
var app_routing_module_1 = require('./app-routing.module');
var shared_module_1 = require('./shared/shared.module');
var issuing_module_1 = require('./issuing-module/issuing.module');
var quote_notify_product_component_1 = require('./quote-notify-product/quote-notify-product.component');
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            imports: [platform_browser_1.BrowserModule, issuing_module_1.IssuingModule, app_routing_module_1.AppRoutingModule, http_1.HttpModule, forms_1.FormsModule, shared_module_1.SharedModule,
                angular2localization_1.LocaleModule.forRoot(), angular2localization_1.LocalizationModule.forRoot()],
            declarations: [app_component_1.AppComponent, quote_notify_product_component_1.QuoteNotifyProduct],
            bootstrap: [app_component_1.AppComponent]
        }), 
        __metadata('design:paramtypes', [])
    ], AppModule);
    return AppModule;
}());
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map