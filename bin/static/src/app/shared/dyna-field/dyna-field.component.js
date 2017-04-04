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
//IMP imports
var field_1 = require('./field');
var DynaFieldComponent = (function () {
    function DynaFieldComponent() {
        this.fieldChange = new core_1.EventEmitter();
    }
    /**
     * Do required operations during component initialization
     */
    DynaFieldComponent.prototype.ngOnInit = function () {
        this.field.prepareTemplate();
    };
    /**
     * Emit field change for text fields
     */
    DynaFieldComponent.prototype.changeText = function (newValue) {
        this.field.textValue = newValue;
        this.fieldChange.emit(newValue);
    };
    /**
     * Emit field change for single selection fields
     */
    DynaFieldComponent.prototype.changeSingle = function (newValue) {
        this.field.selectedItem = newValue;
        this.fieldChange.emit(newValue);
    };
    /**
     * Emit field change for multiple selection fields
     */
    DynaFieldComponent.prototype.changeMultiple = function (newValue) {
        this.field.selectedItems = newValue;
        this.fieldChange.emit(newValue);
    };
    __decorate([
        core_1.Input(), 
        __metadata('design:type', field_1.Field)
    ], DynaFieldComponent.prototype, "field", void 0);
    __decorate([
        core_1.Output(), 
        __metadata('design:type', core_1.EventEmitter)
    ], DynaFieldComponent.prototype, "fieldChange", void 0);
    DynaFieldComponent = __decorate([
        core_1.Component({
            selector: 'dyna-field',
            moduleId: module.id,
            templateUrl: 'dyna-field.component.html'
        }), 
        __metadata('design:paramtypes', [])
    ], DynaFieldComponent);
    return DynaFieldComponent;
}());
exports.DynaFieldComponent = DynaFieldComponent;
//# sourceMappingURL=dyna-field.component.js.map