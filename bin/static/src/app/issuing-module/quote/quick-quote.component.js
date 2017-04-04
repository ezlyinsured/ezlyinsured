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
var router_1 = require('@angular/router');
//import {Observable} from 'rxjs/Rx';
require('rxjs/add/operator/switchMap');
var policy_1 = require('../shared/model/core/policy');
var product_1 = require('../shared/model/core/product');
var variable_data_1 = require('../shared/model/core/variable-data');
var risk_1 = require('../shared/model/core/risk');
var quote_service_1 = require('./quote.service');
var QuickQuoteComponent = (function () {
    /**
     * Default constructor, it wires quote service,
     * active route and router
     */
    function QuickQuoteComponent(quoteService, activeRoute, router) {
        this.quoteService = quoteService;
        this.activeRoute = activeRoute;
        this.router = router;
    }
    /**
     * Bind jquery events
     */
    QuickQuoteComponent.prototype.ngAfterViewInit = function () {
        $(".mobile-header-nav").click(function (e) {
            e.stopPropagation();
        });
        $(".navbar-toggle").click(function (e) {
            $(".mobile-header-nav").slideToggle(200);
            e.stopPropagation();
        });
    };
    /**
     * Do required operations during component initialization
     */
    QuickQuoteComponent.prototype.ngOnInit = function () {
        this.getProductConfig();
    };
    /**
     * Get variable data for product
     */
    QuickQuoteComponent.prototype.getProductConfig = function () {
        var _this = this;
        this.activeRoute.params
            .map(function (params) { return params['productId']; })
            .subscribe(function (productId) {
            //get product variable data
            _this.quoteService.getProductVariableData(productId).then(function (productVariableData) {
                _this.productVariableData = productVariableData;
            })
                .catch(function (error) {
                console.log("Error getting variable: " + error);
            });
            //initializating the configuration of coverage at policy level
            _this.quoteService.getCoveragePolicyLevel(productId).then(function (productCoverage) {
                _this.covGroupPolicyLevel = productCoverage;
            })
                .catch(function (error) {
                console.log("Error getting coverages at policy level: " + error);
            });
            //initializating the configuration of coverage at risk level
            _this.quoteService.getCoverageRiskLevel(productId).then(function (productCoverage) {
                _this.covGroupRiskLevel = productCoverage;
            })
                .catch(function (error) {
                console.log("Error getting coverages at risk level: " + error);
            });
        });
    };
    /**
     * Check if all fields of variable data form are valid
     */
    QuickQuoteComponent.prototype.isValid = function () {
        if (this.productVariableData) {
            var isValid = true;
            this.productVariableData.masterVariableDataList.forEach(function (vData) {
                var currentValid = false;
                if (vData.isValid()) {
                    currentValid = true;
                }
                isValid = isValid && currentValid;
            });
            return isValid;
        }
        else {
            return false;
        }
    };
    /**
     * Create a data variable list from master variable data and
     * data provides by user
     */
    QuickQuoteComponent.prototype.populateVariableData = function () {
        var variableDataList = [];
        this.productVariableData.masterVariableDataList.forEach(function (masterVData) {
            var vData = new variable_data_1.VariableData();
            vData.code = masterVData.code;
            if (masterVData.inputProperties.typeVariable == 'OP') {
                vData.value = masterVData.getValue();
            }
            else if (masterVData.inputProperties.typeVariable == 'RB' ||
                masterVData.inputProperties.typeVariable == 'SL') {
                vData.value = masterVData.getValue().code;
            }
            vData.masterVariableData = masterVData;
            variableDataList.push(vData);
        });
        return variableDataList;
    };
    /**
     * Define policy to quote
     */
    QuickQuoteComponent.prototype.quickQuote = function () {
        //define product
        var product = new product_1.Product();
        product.id = this.productVariableData.product.id;
        //define default risk
        var risk = new risk_1.Risk();
        risk.id = 1;
        risk.name = "Location 1"; //TODO risk name depends from product
        risk.riskNumber = 1;
        risk.variableDataRisk = [];
        risk.coverages = this.covGroupRiskLevel.coveragesGroupList[0].coverages;
        risk.childrenRisks = [];
        //if there are second level risks then define
        //a default second level risk
        if (this.covGroupRiskLevel.coveragesGroupList.length > 1) {
            var slRisk = new risk_1.Risk;
            slRisk.id = 2;
            slRisk.name = "Building 1"; //TODO risk name depends from product
            slRisk.riskNumber = 2;
            slRisk.variableDataRisk = [];
            slRisk.coverages = this.covGroupRiskLevel.coveragesGroupList[1].coverages;
            risk.childrenRisks.push(slRisk);
        }
        //define policy
        var policy = new policy_1.Policy();
        //set product
        policy.product = product;
        //set variable data
        policy.variableDataList = this.populateVariableData();
        //set default risks
        policy.risks = [];
        policy.risks.push(risk);
        //set policy coverage groups
        policy.coveragesGroups = this.covGroupPolicyLevel.coveragesGroupList;
        //set policy as policy to quote and navigate to quote component
        this.quoteService.setPolicyToQuote(policy);
        this.router.navigate(['quote']);
    };
    QuickQuoteComponent = __decorate([
        core_1.Component({
            selector: 'quick-quote',
            moduleId: module.id,
            templateUrl: 'quick-quote.component.html'
        }), 
        __metadata('design:paramtypes', [quote_service_1.QuoteService, router_1.ActivatedRoute, router_1.Router])
    ], QuickQuoteComponent);
    return QuickQuoteComponent;
}());
exports.QuickQuoteComponent = QuickQuoteComponent;
//# sourceMappingURL=quick-quote.component.js.map