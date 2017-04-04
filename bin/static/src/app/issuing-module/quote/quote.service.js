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
var http_1 = require('@angular/http');
require('rxjs/add/operator/toPromise');
var typedjson_npm_1 = require('typedjson-npm');
//IMP dependencies
var product_variable_data_1 = require('../shared/model/configuration/product-variable-data');
var product_coverage_1 = require('../shared/model/configuration/product-coverage');
/**
 * Quote service.
 * @author ccasallas
 *
*/
var QuoteService = (function () {
    function QuoteService(http) {
        this.http = http;
    }
    /**
     * Service used for quick quote component to define policy to
     * be quoted at initialization of quote component
     */
    QuoteService.prototype.setPolicyToQuote = function (policy) {
        this.policyToQuote = policy;
    };
    /**
     * Service used quote component to trigger quick quote on component
     * initialization
     */
    QuoteService.prototype.getPolicyToQuote = function () {
        return this.policyToQuote;
    };
    /**
     * call the quick quote process to retrieve the set of policies
     */
    QuoteService.prototype.callQuickQuote = function (policy) {
        return this.http.post('http://localhost:8080/processQuickQuoteSummary', policy).toPromise()
            .then(function (response) {
            return response.json();
        })
            .catch(this.handleError);
    };
    /**
     * Get product variable data by productId
     */
    QuoteService.prototype.getProductVariableData = function (productId) {
        return this.http.get('http://localhost:8080/product/' + productId + '/variable-data').toPromise()
            .then(function (response) {
            return typedjson_npm_1.TypedJSON.parse(response.json(), product_variable_data_1.ProductVariableData);
        })
            .catch(this.handleError);
    };
    /**
     * Get product coverage by productId
     */
    QuoteService.prototype.getCoveragePolicyLevel = function (productId) {
        return this.http.get('http://localhost:8080/product/' + productId + '/coverage-policy-level').toPromise()
            .then(function (response) {
            return typedjson_npm_1.TypedJSON.parse(response.json(), product_coverage_1.ProductCoverage);
        })
            .catch(this.handleError);
    };
    /**
     * Get product coverage by productId
     */
    QuoteService.prototype.getCoverageRiskLevel = function (productId) {
        return this.http.get('http://localhost:8080/product/' + productId + '/coverage-risk-level').toPromise()
            .then(function (response) {
            return typedjson_npm_1.TypedJSON.parse(response.json(), product_coverage_1.ProductCoverage);
        })
            .catch(this.handleError);
    };
    QuoteService.prototype.handleError = function (error) {
        return Promise.reject(error.message || error);
    };
    QuoteService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], QuoteService);
    return QuoteService;
}());
exports.QuoteService = QuoteService;
//# sourceMappingURL=quote.service.js.map