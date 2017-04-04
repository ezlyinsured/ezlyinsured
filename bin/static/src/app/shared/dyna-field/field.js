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
var TPL_OP = "OP";
var TPL_RB = "RB";
var TPL_CL = "CL";
var TPL_SL = "SL";
/**
* this object represents an abstract field
*
* @author ccasallas
*/
var Field = (function () {
    function Field() {
        //attributes for template visibility
        this.visibleOP = false;
        this.visibleRB = false;
        this.visibleCL = false;
        this.visibleSL = false;
        this.placeholder = "";
        this.selectItems = [];
        this.selectedItems = [];
        this.selectedItem = null;
        this.textValue = null;
    }
    /**
     * Prepare the right template according to
     * the field type
     */
    Field.prototype.prepareTemplate = function () {
        //define placeholder and type of field
        var fieldtype = this.getFieldType();
        this.initPlaceholder();
        //define visibility of the right template
        this.visibleOP = TPL_OP == fieldtype;
        this.visibleRB = TPL_RB == fieldtype;
        this.visibleCL = TPL_CL == fieldtype;
        if (this.visibleSL = TPL_SL == fieldtype) {
            this.prepareSLTemplate();
        }
    };
    /**
     * Init selection list template
     */
    Field.prototype.prepareSLTemplate = function () {
        this.initSelectItems();
    };
    /**
     * Check if field complies all validations
     */
    Field.prototype.isValid = function () {
        if (this.visibleOP) {
            if (this.textValue) {
                return this.textValue.length > 0;
            }
            else {
                return false;
            }
        }
        else if (this.visibleSL) {
            return this.selectedItem != null;
        }
    };
    /**
     * Update field value according field type
     */
    Field.prototype.updateValue = function (newValue) {
        if (this.visibleOP) {
            this.textValue = newValue;
        }
        else if (this.visibleSL) {
            this.selectedItem = newValue;
        }
        else if (this.visibleRB) {
            this.selectedItem = newValue;
        }
        else if (this.visibleCL) {
            this.selectedItems = newValue;
        }
    };
    /**
     * Get field value according field type
     */
    Field.prototype.getValue = function () {
        if (this.visibleOP) {
            return this.textValue;
        }
        else if (this.visibleSL) {
            return this.selectedItem;
        }
        else if (this.visibleRB) {
            return this.selectedItem;
        }
        else if (this.visibleCL) {
            return this.selectedItems;
        }
    };
    __decorate([
        typedjson_npm_1.JsonMember({ emitDefaultValue: true }), 
        __metadata('design:type', Boolean)
    ], Field.prototype, "visibleOP", void 0);
    __decorate([
        typedjson_npm_1.JsonMember({ emitDefaultValue: true }), 
        __metadata('design:type', Boolean)
    ], Field.prototype, "visibleRB", void 0);
    __decorate([
        typedjson_npm_1.JsonMember({ emitDefaultValue: true }), 
        __metadata('design:type', Boolean)
    ], Field.prototype, "visibleCL", void 0);
    __decorate([
        typedjson_npm_1.JsonMember({ emitDefaultValue: true }), 
        __metadata('design:type', Boolean)
    ], Field.prototype, "visibleSL", void 0);
    __decorate([
        typedjson_npm_1.JsonMember({ emitDefaultValue: true }), 
        __metadata('design:type', String)
    ], Field.prototype, "placeholder", void 0);
    return Field;
}());
exports.Field = Field;
//# sourceMappingURL=field.js.map