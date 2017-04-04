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
var AppComponent = (function (_super) {
    __extends(AppComponent, _super);
    /**
     * AppComponent constructor.
    */
    function AppComponent(el, router, locale, localization) {
        _super.call(this, locale, localization);
        this.el = el;
        this.router = router;
        this.locale = locale;
        this.localization = localization;
        //Ultima them attributes
        this.layoutCompact = true;
        this.layoutMode = 'static';
        this.darkMenu = false;
        this.profileMode = 'inline';
        // Adds the languages (ISO 639 two-letter or three-letter code).
        this.locale.addLanguages(['en', 'it']);
        // Required: default language, country (ISO 3166 two-letter, uppercase code) and expiry (No days). If the expiry is omitted, the cookie becomes a session cookie.
        // Selects the default language and country, regardless of the browser language, to avoid inconsistencies between the language and country.
        this.locale.definePreferredLocale('en', 'US', 30);
        // Optional: default currency (ISO 4217 three-letter code).
        this.locale.definePreferredCurrency('USD');
        // Initializes LocalizationService: asynchronous loading.
        this.localization.translationProvider('./resources/locale-'); // Required: initializes the translation provider with the given path prefix.
        this.localization.updateTranslation(); // Need to update the translation.
    }
    // Sets a new locale & currency.
    AppComponent.prototype.selectLocale = function (language, country, currency) {
        this.locale.setCurrentLocale(language, country);
        this.locale.setCurrentCurrency(currency);
    };
    /**
     * AfterViewInit used by Ultima theme.
    */
    AppComponent.prototype.ngAfterViewInit = function () {
        Ultima.init(this.el.nativeElement);
    };
    /**
      * Function provied by Ultima theme to change the theme on Kalos.
      * @param event Browser event.
      * @param theme Theme name to be retrieved from css files.
    */
    AppComponent.prototype.changeTheme = function (event, theme) {
        var themeLink = document.getElementById('theme-css');
        var layoutLink = document.getElementById('layout-css');
        themeLink.href = '../resources/theme/theme-' + theme + '.css';
        layoutLink.href = '../resources/layout/css/layout-' + theme + '.css';
        event.preventDefault();
    };
    AppComponent = __decorate([
        core_1.Component({
            selector: 'imp',
            templateUrl: 'app/application.html'
        }), 
        __metadata('design:paramtypes', [core_1.ElementRef, router_1.Router, angular2localization_1.LocaleService, angular2localization_1.LocalizationService])
    ], AppComponent);
    return AppComponent;
}(angular2localization_1.Locale));
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component-old.js.map