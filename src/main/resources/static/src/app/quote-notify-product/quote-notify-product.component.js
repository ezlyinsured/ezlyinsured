"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
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
var router_1 = require('@angular/router');
var angular2localization_1 = require('angular2localization');
var QuoteNotifyProduct = (function (_super) {
    __extends(QuoteNotifyProduct, _super);
    /**
     * DashComponent constructor.
    */
    function QuoteNotifyProduct(router, locale, localization) {
        _super.call(this, locale, localization);
        this.router = router;
        this.locale = locale;
        this.localization = localization;
    }
    /**
      * TEMPORARY!!! function to call the module that is lazy loaded.
    */
    QuoteNotifyProduct.prototype.gotoDetail = function () {
        this.router.navigate(['/conf']);
    };
    // Sets a new locale & currency.
    QuoteNotifyProduct.prototype.selectLocale = function (language, country, currency) {
        this.locale.setCurrentLocale(language, country);
        this.locale.setCurrentCurrency(currency);
    };
    QuoteNotifyProduct = __decorate([
        core_1.Component({
            selector: 'imp',
            templateUrl: 'app/quote-notify-product/quote-notify-product-tmpl.html' }), 
        __metadata('design:paramtypes', [router_1.Router, angular2localization_1.LocaleService, angular2localization_1.LocalizationService])
    ], QuoteNotifyProduct);
    return QuoteNotifyProduct;
}(angular2localization_1.Locale));
exports.QuoteNotifyProduct = QuoteNotifyProduct;
//# sourceMappingURL=quote-notify-product.component.js.map