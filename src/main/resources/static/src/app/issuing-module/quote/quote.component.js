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
var material_1 = require('@angular/material');
var risk_1 = require('../shared/model/core/risk');
var quote_service_1 = require('./quote.service');
var MAX_TIME = 10;
/**
 * Quote component.
 * @author ccasallas
 *
*/
var QuoteComponent = (function (_super) {
    __extends(QuoteComponent, _super);
    /**
     * PolicySummary constructor.
    */
    function QuoteComponent(router, locale, localization, quoteService, dialog, viewContainerRef) {
        _super.call(this, locale, localization);
        this.router = router;
        this.locale = locale;
        this.localization = localization;
        this.quoteService = quoteService;
        this.dialog = dialog;
        this.viewContainerRef = viewContainerRef;
        this.policies = [];
        this.tmpPolicies = [];
        this.selectedCov = 1;
        this.selectedChildRiskCov = 1;
        this.timeLeftChanges = MAX_TIME;
        this.timerStarted = false;
        this.searchingResults = false;
        this.searchingRecommended = false;
    }
    /**
     * On init for quote process
     */
    QuoteComponent.prototype.ngOnInit = function () {
        var _this = this;
        //calling the policy with previous data processed
        this.policy = this.quoteService.getPolicyToQuote();
        //initializating the configuration of coverage at policy level
        this.quoteService.getCoveragePolicyLevel(this.policy.product.id)
            .then(function (productCoverage) {
            _this.covGroupPolicyLevel = productCoverage;
        });
        //initializating the configuration of coverage at risk level
        this.quoteService.getCoverageRiskLevel(this.policy.product.id)
            .then(function (productCoverage) {
            _this.prepareCovsRiskLevel(productCoverage);
        })
            .catch(function (error) {
            console.log("Error getting coverages at risk level: " + error);
        });
        //calling initial quick quote 
        this.callQuickQuote();
        this.currentVisible = 'policyInfo';
    };
    /**
     * Bind jquery events
     */
    QuoteComponent.prototype.ngAfterViewInit = function () {
        // comparison table aside
        $(".comparison-table-aside .expand-collapse-state").click(function () {
            if ($(this).closest("aside").hasClass('collapsed-comparison')) {
                $(this).closest("aside").removeClass('collapsed-comparison');
            }
            else {
                $(this).closest("aside").addClass('collapsed-comparison');
            }
        });
        // structure-aside
        $(".structure-level-expand .expand-collapse-state").click(function () {
            if ($(this).closest("aside").hasClass('collapsed-structure')) {
                $(this).closest("aside").removeClass('collapsed-structure');
                $(".expanded-logo").removeClass('collapsed-structure');
                $("body").removeClass('left-aside-collapsed');
                $(".steps-wizard-box").removeClass('collapsed-structure');
            }
            else {
                $(this).closest("aside").addClass('collapsed-structure');
                $(".expanded-logo").addClass('collapsed-structure');
                $("body").addClass('left-aside-collapsed');
                $(".steps-wizard-box").addClass('collapsed-structure');
            }
        });
        //Open struture aside
        $('.menu-icon').click(function (e) {
            $(".collapsed-structure").removeClass("collapsed-structure");
            $("body").removeClass('is-comparison-active');
            if ($("body").hasClass('is-nav-active')) {
                $("body").removeClass('is-nav-active');
            }
            else {
                $("body").addClass('is-nav-active');
            }
            e.stopPropagation();
        });
        // open comparison-table-aside
        $(".notify-icon").click(function (e) {
            $(".collapsed-comparison").removeClass("collapsed-comparison");
            if ($(".comparison-table-aside").hasClass('is-comparison-active')) {
                $(".comparison-table-aside").removeClass('is-comparison-active');
                $("body").removeClass("comparison-aside-extend");
            }
            else {
                $(".comparison-table-aside").addClass('is-comparison-active');
                $("body").addClass("comparison-aside-extend");
            }
            e.stopPropagation();
        });
        // mobile header flyout
        $(".mobile-header-nav").click(function (e) {
            e.stopPropagation();
        });
        $(".navbar-toggle").click(function (e) {
            $(".mobile-header-nav").slideToggle(200);
            e.stopPropagation();
        });
        // booked comparison button hover
        $(".comparison-table-list").on("mouseenter", ".comparison-box-main.result", function () {
            $(this).addClass('booked-comparison');
        });
        // booked comparison button hover
        $(".comparison-table-list").on("mouseleave", ".comparison-box-main.result", function () {
            $(this).removeClass('booked-comparison');
        });
        //Outside click
        $(document).click(function (e) {
            $('.is-nav-active').removeClass('is-nav-active');
            $(".is-comparison-active").removeClass('is-comparison-active');
            $(".mobile-header-nav").slideUp(200);
            $(".comparison-aside-extend").removeClass("comparison-aside-extend");
        });
        $('.structure-aside, .comparison-table-aside, .mobile-header-nav').click(function (e) {
            e.stopPropagation();
        });
    };
    /**
     * Function to call the quick quote
     */
    QuoteComponent.prototype.callQuickQuote = function () {
        var _this = this;
        //clear on fly interval if exists one
        if (this.searchingResults) {
            clearInterval(this.quoteTimerId);
            this.quoteTimerId = null;
        }
        //init search
        this.searchingResults = true;
        this.searchingRecommended = true;
        this.policies = [];
        this.quoteService.callQuickQuote(this.policy)
            .then(function (policies) {
            _this.tmpPolicies = policies;
            _this.quoteTimerId = setInterval(function () {
                if (_this.searchingRecommended) {
                    _this.bestPolicy = _this.tmpPolicies.shift();
                    _this.searchingRecommended = false;
                }
                if (_this.tmpPolicies.length > 0) {
                    if (!_this.searchingRecommended) {
                        _this.policies.push(_this.tmpPolicies.shift());
                    }
                }
                else {
                    clearInterval(_this.quoteTimerId);
                    _this.searchingResults = false;
                }
            }, 2000);
        })
            .catch(function (error) {
            console.log("Error quick quote summary: " + error);
        });
    };
    /**
     * Set visibility of forms groups
     */
    QuoteComponent.prototype.calculatingScoreBar = function (percentageCovs) {
        var scoreClass = "comparison-status-icon";
        //enable the policy coverage forms
        if (0 < percentageCovs && percentageCovs <= 20) {
            scoreClass = scoreClass + " checked-2";
        }
        else if (20 < percentageCovs && percentageCovs <= 40) {
            scoreClass = scoreClass + " checked-3";
        }
        else if (60 < percentageCovs && percentageCovs <= 80) {
            scoreClass = scoreClass + " checked-4";
        }
        else if (80 < percentageCovs && percentageCovs <= 100) {
            scoreClass = scoreClass + " checked-5";
        }
        else {
            scoreClass = scoreClass + " checked-1";
        }
        return scoreClass;
    };
    /**
     * Set visibility of forms groups
     */
    QuoteComponent.prototype.onEditPolicyCovs = function () {
        //enable the policy coverage forms
        this.currentVisible = "policyCov";
    };
    /**
     * Show form to edit policy information
     */
    QuoteComponent.prototype.onEditPolicyInfo = function () {
        this.currentVisible = 'policyInfo';
    };
    /**
     * Show form to edit locations
     */
    QuoteComponent.prototype.onEditFirstLevelAllRisk = function () {
        this.currentVisible = 'firstLevelAllRisk';
    };
    /**
     * Show form to edit the given first level risk
     */
    QuoteComponent.prototype.onEditFirstLevelRisk = function (risk) {
        this.currentRisk = risk;
        this.currentVisible = 'firstLevelRiskSelection';
    };
    /**
     * Show form to edit the given second level risk
     */
    QuoteComponent.prototype.onEditSecondLevelRisk = function (risk) {
        this.currentRisk = risk;
        this.currentVisible = 'secondLevelRiskSelection';
    };
    /**
     * Dialog management for first level risk
     */
    QuoteComponent.prototype.callFirstRiskLvlDialog = function (dialogMode, riskRef) {
        var _this = this;
        var config = new material_1.MdDialogConfig();
        config.viewContainerRef = this.viewContainerRef;
        this.dialogRef = this.dialog.open(FirstRiskLvlDialogComponent, config);
        //passing parameters to make the specific CRUD operation
        this.dialogRef.componentInstance.dialogMode = dialogMode;
        this.dialogRef.componentInstance.risksRef = this.policy.risks;
        this.dialogRef.componentInstance.covGroupRiskLevel = this.covGroupRiskLevel;
        this.dialogRef.componentInstance.riskRef = riskRef;
        if (dialogMode == 'edit') {
            this.dialogRef.componentInstance.riskBackUp = JSON.parse(JSON.stringify(riskRef));
        }
        this.dialogRef.afterClosed().subscribe(function (result) {
            _this.dialogRef = null;
            if (result) {
                _this.activateChangesCountDown();
            }
        });
    };
    /**
     * Dialog management for second level risk
     */
    QuoteComponent.prototype.callSecondRiskLvlDialog = function (dialogMode, parentRisk, riskRef) {
        var _this = this;
        var config = new material_1.MdDialogConfig();
        config.viewContainerRef = this.viewContainerRef;
        this.dialogRef = this.dialog.open(SecondRiskLvlDialogComponent, config);
        //passing parameters to make the specific CRUD operation
        this.dialogRef.componentInstance.dialogMode = dialogMode;
        this.dialogRef.componentInstance.risksRef = this.policy.risks;
        this.dialogRef.componentInstance.covGroupRiskLevel = this.covGroupRiskLevel;
        this.dialogRef.componentInstance.parentRisk = parentRisk;
        this.dialogRef.componentInstance.riskRef = riskRef;
        if (dialogMode == 'edit') {
            this.dialogRef.componentInstance.riskBackUp = JSON.parse(JSON.stringify(riskRef));
        }
        this.dialogRef.afterClosed().subscribe(function (result) {
            _this.dialogRef = null;
            if (result) {
                _this.activateChangesCountDown();
            }
        });
    };
    /**
     * Set coverage groups at risk level
     */
    QuoteComponent.prototype.prepareCovsRiskLevel = function (productCoverage) {
        this.covGroupRiskLevel = productCoverage;
    };
    /**
     * On change variable data handler
     */
    QuoteComponent.prototype.onChangeVariableData = function (variableData, newValue) {
        variableData.value = newValue;
        this.activateChangesCountDown();
    };
    /**
     * On change coverage handler
     */
    QuoteComponent.prototype.onChangeCoverage = function (coverage) {
        coverage.contracted = !coverage.contracted;
        this.activateChangesCountDown();
    };
    /**
     * Start count down to apply pending changes
     */
    QuoteComponent.prototype.activateChangesCountDown = function () {
        var _this = this;
        if (!this.timerStarted) {
            this.timerId = setInterval(function () {
                _this.timeLeftChanges--;
                if (_this.timeLeftChanges == 0) {
                    _this.applyChangesNow();
                }
            }, 1000);
            this.timerStarted = true;
        }
    };
    /**
     * Apply pending changes immediately
     */
    QuoteComponent.prototype.applyChangesNow = function () {
        clearInterval(this.timerId);
        this.timerId = null;
        this.timerStarted = false;
        this.timeLeftChanges = 10;
        this.callQuickQuote();
    };
    /**
     * dummy help handler
     */
    QuoteComponent.prototype.openHelp = function () {
        $('#helpModal').modal('toggle');
    };
    QuoteComponent = __decorate([
        core_1.Component({
            selector: 'quote',
            moduleId: module.id,
            templateUrl: 'quote.component.html'
        }), 
        __metadata('design:paramtypes', [router_1.Router, angular2localization_1.LocaleService, angular2localization_1.LocalizationService, quote_service_1.QuoteService, material_1.MdDialog, core_1.ViewContainerRef])
    ], QuoteComponent);
    return QuoteComponent;
}(angular2localization_1.Locale));
exports.QuoteComponent = QuoteComponent;
/*****    Dialog for CRUD operations  *****/
//First Risk Level Dialog Component
var FirstRiskLvlDialogComponent = (function () {
    function FirstRiskLvlDialogComponent(dialogRef) {
        this.dialogRef = dialogRef;
        this.risk = new risk_1.Risk();
    }
    /**
     * Create a new first level Risk
     */
    FirstRiskLvlDialogComponent.prototype.save = function () {
        // creating the new risk
        this.risk.id = this.risksRef.length + 1;
        this.risk.riskNumber = this.risksRef.length + 1;
        this.risk.childrenRisks = [];
        //associating the coverage configuration
        var clonedCoverageConf = JSON.parse(JSON.stringify(this.covGroupRiskLevel.coveragesGroupList[0].coverages));
        this.risk.coverages = clonedCoverageConf;
        //adding the new risk the list
        this.risksRef.push(this.risk);
        //cleaning the risk object
        this.risk = new risk_1.Risk();
        //finish the create operation
        this.dialogRef.close(true);
    };
    /**
     * Remove an existing first level Risk
     */
    FirstRiskLvlDialogComponent.prototype.remove = function () {
        //removing the risk of the risk list
        var index = this.risksRef.indexOf(this.riskRef);
        this.risksRef.splice(index, 1);
        //finish the remove operation
        this.dialogRef.close(true);
    };
    /**
     * Cancel an edit operation of first level Risk
    */
    FirstRiskLvlDialogComponent.prototype.cancelEdit = function () {
        //assigning the backup risk
        this.riskRef.name = this.riskBackUp.name;
        //finish the edit operation
        this.dialogRef.close();
    };
    FirstRiskLvlDialogComponent = __decorate([
        core_1.Component({
            selector: 'rskFirstLvlDialog',
            template: "\n      <div *ngIf=\"dialogMode == 'create'\">\n        <h1 md-dialog-title>New location</h1>\n        <div md-dialog-content>\n            \n            <md-input-container>\n                <input mdInput placeholder=\"Location Name\" [(ngModel)]=\"risk.name\" required/>\n            </md-input-container>\n        \n        </div>\n        <div md-dialog-actions>\n            <button md-raised-button (click)=\"save()\">Save</button>\n            <button md-raised-button (click)=\"dialogRef.close()\">Cancel</button>\n        </div>\n      </div>\n      <div *ngIf=\"dialogMode == 'edit'\">\n        <h1 md-dialog-title>Edit location</h1>\n         <div md-dialog-content>\n            <md-input-container>\n                <input mdInput placeholder=\"Location Name\" [(ngModel)]=\"riskRef.name\" required/>\n            </md-input-container>\n        </div>\n        <div md-dialog-actions>\n            <button md-raised-button (click)=\"dialogRef.close()\">Save</button>\n            <button md-raised-button (click)=\"cancelEdit()\">Cancel</button>\n        </div>\n      </div>\n      <div *ngIf=\"dialogMode == 'remove'\">\n        <h1 md-dialog-title>Remove location</h1>\n        <div md-dialog-content>    \n             <p>Are you sure to remove this location?</p>\n        </div>\n        <div md-dialog-actions>\n            <button md-raised-button (click)=\"remove()\">Yes</button>\n            <button md-raised-button (click)=\"dialogRef.close()\">No</button>\n        </div>\n      </div>\n    "
        }), 
        __metadata('design:paramtypes', [material_1.MdDialogRef])
    ], FirstRiskLvlDialogComponent);
    return FirstRiskLvlDialogComponent;
}());
exports.FirstRiskLvlDialogComponent = FirstRiskLvlDialogComponent;
//Second Risk Level Dialog Component
var SecondRiskLvlDialogComponent = (function () {
    function SecondRiskLvlDialogComponent(dialogRef) {
        this.dialogRef = dialogRef;
        this.risk = new risk_1.Risk();
    }
    /**
     * Create a new first level Risk
     */
    SecondRiskLvlDialogComponent.prototype.save = function () {
        // creating the new risk
        this.risk.id = this.parentRisk.childrenRisks.length + 1;
        this.risk.riskNumber = this.parentRisk.childrenRisks.length + 1;
        this.risk.childrenRisks = [];
        //associating the coverage configuration
        var clonedCoverageConf = JSON.parse(JSON.stringify(this.covGroupRiskLevel.coveragesGroupList[1].coverages));
        this.risk.coverages = clonedCoverageConf;
        //adding the new risk the list
        this.parentRisk.childrenRisks.push(this.risk);
        //cleaning the risk object
        this.risk = new risk_1.Risk();
        //finish the create operation
        this.dialogRef.close(true);
    };
    /**
     * Remove an existing second level Risk
     */
    SecondRiskLvlDialogComponent.prototype.remove = function () {
        //removing the risk of the risk list
        var index = this.parentRisk.childrenRisks.indexOf(this.riskRef);
        this.parentRisk.childrenRisks.splice(index, 1);
        //finish the remove operation
        this.dialogRef.close(true);
    };
    /**
     * Cancel an edit operation of second level Risk
    */
    SecondRiskLvlDialogComponent.prototype.cancelEdit = function () {
        //assigning the backup risk
        this.riskRef.name = this.riskBackUp.name;
        //finish the edit operation
        this.dialogRef.close();
    };
    SecondRiskLvlDialogComponent = __decorate([
        core_1.Component({
            selector: 'rskSecondLvlDialog',
            template: "\n      <div *ngIf=\"dialogMode == 'create'\">\n        <h1 md-dialog-title>New Building</h1>\n        <div md-dialog-content>\n            \n            <md-input-container>\n                <input mdInput placeholder=\"Building Name\" [(ngModel)]=\"risk.name\" required/>\n            </md-input-container>\n        \n        </div>\n        <div md-dialog-actions>\n            <button md-raised-button (click)=\"save()\">Save</button>\n            <button md-raised-button (click)=\"dialogRef.close()\">Cancel</button>\n        </div>\n      </div>\n      <div *ngIf=\"dialogMode == 'edit'\">\n        <h1 md-dialog-title>Edit Building</h1>\n         <div md-dialog-content>\n            <md-input-container>\n                <input mdInput placeholder=\"Building Name\" [(ngModel)]=\"riskRef.name\" required/>\n            </md-input-container>\n        </div>\n        <div md-dialog-actions>\n            <button md-raised-button (click)=\"dialogRef.close()\">Save</button>\n            <button md-raised-button (click)=\"cancelEdit()\">Cancel</button>\n        </div>\n      </div>\n      <div *ngIf=\"dialogMode == 'remove'\">\n        <h1 md-dialog-title>Remove Building</h1>\n        <div md-dialog-content>    \n             <p>Are you sure to remove this building?</p>\n        </div>\n        <div md-dialog-actions>\n            <button md-raised-button (click)=\"remove()\">Yes</button>\n            <button md-raised-button (click)=\"dialogRef.close()\">No</button>\n        </div>\n      </div>\n    "
        }), 
        __metadata('design:paramtypes', [material_1.MdDialogRef])
    ], SecondRiskLvlDialogComponent);
    return SecondRiskLvlDialogComponent;
}());
exports.SecondRiskLvlDialogComponent = SecondRiskLvlDialogComponent;
//# sourceMappingURL=quote.component.js.map