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
var router_1 = require('@angular/router');
var material_1 = require('@angular/material');
var forms_1 = require('@angular/forms');
var primeng_1 = require('primeng/primeng');
var primeng_2 = require('primeng/primeng');
var product_selector_component_1 = require('./product-selector/product-selector.component');
var product_selector_service_1 = require('./product-selector/product-selector.service');
var dyna_field_component_1 = require('./dyna-field/dyna-field.component');
var SharedModule = (function () {
    function SharedModule() {
    }
    SharedModule = __decorate([
        core_1.NgModule({
            imports: [common_1.CommonModule, router_1.RouterModule, primeng_1.InputTextModule, primeng_2.DropdownModule, forms_1.FormsModule, material_1.MaterialModule.forRoot()],
            declarations: [product_selector_component_1.ProductSelectorComponent, dyna_field_component_1.DynaFieldComponent],
            exports: [product_selector_component_1.ProductSelectorComponent, dyna_field_component_1.DynaFieldComponent],
            providers: [product_selector_service_1.ProductSelectorService]
        }), 
        __metadata('design:paramtypes', [])
    ], SharedModule);
    return SharedModule;
}());
exports.SharedModule = SharedModule;
//# sourceMappingURL=shared.module.js.map