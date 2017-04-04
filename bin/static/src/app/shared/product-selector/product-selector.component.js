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
var product_selector_service_1 = require('./product-selector.service');
//flags to validate if current question advance to 
// a positive or negative confirmation
var POSITIVE_END = -1;
var NEGATIVE_END = -2;
//constant to identify the main section of the component
var START_SECTION = 0;
var RAIL_SECTION = 1;
var POSITIVE_END_SECTION = 2;
var NEGATIVE_END_SECTION = 3;
var EMAIL_NOTIFY_SECTION = 4;
var ProductSelectorComponent = (function () {
    /**
     * Default constructor, it wires product selector service
     * and router
     */
    function ProductSelectorComponent(productSelectorService, router) {
        this.productSelectorService = productSelectorService;
        this.router = router;
        //attributes to controls sections visibility
        this.startVisible = true;
        this.railVisible = false;
        this.positiveEndVisible = false;
        this.negativeEndVisible = false;
        this.emailNotifyVisible = false;
        this.currentSection = START_SECTION;
        this.rightProduct = false;
        this.backStack = [];
        this.forwardStack = [];
        this.forwardStackSections = [];
    }
    /**
     * Do required operations during component initialization
     */
    ProductSelectorComponent.prototype.ngOnInit = function () {
        this.getProductSelector();
    };
    /**
     * Get product selector data
     */
    ProductSelectorComponent.prototype.getProductSelector = function () {
        var _this = this;
        this.productSelectorService.getProductSelector(0)
            .then(function (productSelector) {
            _this.productSelector = productSelector;
            _this.currentQuestion = _this.productSelector.questionRail.questions[0];
            _this.questions = _this.productSelector.questionRail.questions;
        })
            .catch(function (error) {
            //TODO enhanced error handling
            console.log("Error: " + error);
        });
    };
    /**
     * Navigate to product quote
     */
    ProductSelectorComponent.prototype.goToQuote = function () {
        this.router.navigate(['/quick-quote', 1]);
    };
    /**
     * Navigate to rail section
     */
    ProductSelectorComponent.prototype.goToRail = function () {
        this.showSectionAndClearForwardStack(RAIL_SECTION);
    };
    /**
     * Navigate to the right section after user
     * answer yes to a question.
     */
    ProductSelectorComponent.prototype.answerYesToQuestion = function () {
        if (this.currentQuestion.onYes == POSITIVE_END) {
            this.showSectionAndClearForwardStack(POSITIVE_END_SECTION);
            this.rightProduct = true;
        }
        else if (this.currentQuestion.onYes == NEGATIVE_END) {
            this.showSectionAndClearForwardStack(NEGATIVE_END_SECTION);
            this.rightProduct = false;
        }
        else {
            this.goToQuestion(this.currentQuestion.onYes);
        }
    };
    /**
     * Navigate to the right section after user
     * answer no to a question.
     */
    ProductSelectorComponent.prototype.answerNoToQuestion = function () {
        if (this.currentQuestion.onNo == POSITIVE_END) {
            this.showSectionAndClearForwardStack(POSITIVE_END_SECTION);
            this.rightProduct = true;
        }
        else if (this.currentQuestion.onNo == NEGATIVE_END) {
            this.showSectionAndClearForwardStack(NEGATIVE_END_SECTION);
            this.rightProduct = false;
        }
        else {
            this.goToQuestion(this.currentQuestion.onNo);
        }
    };
    /**
     * Navigate to the right section after user
     * answer "I don't know" to a question.
     */
    ProductSelectorComponent.prototype.answerIdkToQuestion = function () {
        if (this.currentQuestion.onIdk == POSITIVE_END) {
            this.showSectionAndClearForwardStack(POSITIVE_END_SECTION);
            this.rightProduct = true;
        }
        else if (this.currentQuestion.onIdk == NEGATIVE_END) {
            this.showSectionAndClearForwardStack(NEGATIVE_END_SECTION);
            this.rightProduct = false;
        }
        else {
            this.goToQuestion(this.currentQuestion.onIdk);
        }
    };
    /**
     * Get the question for the given questionId and set it
     * as current question.
     */
    ProductSelectorComponent.prototype.goToQuestion = function (questionId) {
        for (var i = 0; i < this.questions.length; i++) {
            if (this.questions[i].id == questionId) {
                this.backStack.push(this.currentQuestion); //for go back and forward functionality 
                this.currentQuestion = this.questions[i];
                this.clearForwardStacks(); //for go back and forward functionality
            }
        }
    };
    /**
     * Navigate to emailNotify section
     */
    ProductSelectorComponent.prototype.goToEmailNotify = function () {
        this.showSectionAndClearForwardStack(EMAIL_NOTIFY_SECTION);
    };
    /**
     * Reset product selector
     */
    ProductSelectorComponent.prototype.resetProductSelector = function () {
        this.showSectionAndClearForwardStack(START_SECTION);
        this.currentQuestion = this.questions[0];
        this.backStack = [];
    };
    /**
     * Show the given section and hide the other sections
     */
    ProductSelectorComponent.prototype.showSection = function (section) {
        this.currentSection = section;
        this.startVisible = START_SECTION == section;
        this.railVisible = RAIL_SECTION == section;
        this.positiveEndVisible = POSITIVE_END_SECTION == section;
        this.negativeEndVisible = NEGATIVE_END_SECTION == section;
        this.emailNotifyVisible = EMAIL_NOTIFY_SECTION == section;
    };
    /**
     * Show the given section and hide the other sections. Also
     * clear forward stacks
     */
    ProductSelectorComponent.prototype.showSectionAndClearForwardStack = function (section) {
        this.showSection(section);
        this.clearForwardStacks();
    };
    /**
     * Go back command
     */
    ProductSelectorComponent.prototype.goBack = function () {
        if (this.currentSection == RAIL_SECTION) {
            if (this.backStack.length > 0) {
                this.forwardStack.push(this.currentQuestion);
                this.currentQuestion = this.backStack.pop();
            }
            else {
                this.showSection(START_SECTION);
                this.forwardStackSections.push(RAIL_SECTION);
            }
        }
        else if (this.currentSection == POSITIVE_END_SECTION) {
            this.showSection(RAIL_SECTION);
            this.forwardStackSections.push(POSITIVE_END_SECTION);
        }
        else if (this.currentSection == NEGATIVE_END_SECTION) {
            this.showSection(RAIL_SECTION);
            this.forwardStackSections.push(NEGATIVE_END_SECTION);
        }
        else if (this.currentSection == EMAIL_NOTIFY_SECTION) {
            if (this.rightProduct) {
                this.showSection(POSITIVE_END_SECTION);
            }
            else {
                this.showSection(NEGATIVE_END_SECTION);
            }
            this.forwardStackSections.push(EMAIL_NOTIFY_SECTION);
        }
    };
    /**
     * Go forward command
     */
    ProductSelectorComponent.prototype.goForward = function () {
        if (this.currentSection == RAIL_SECTION) {
            if (this.forwardStack.length > 0) {
                this.backStack.push(this.currentQuestion);
                this.currentQuestion = this.forwardStack.pop();
            }
            else if (this.forwardStackSections.length > 0) {
                this.showSection(this.forwardStackSections.pop());
            }
        }
        else if (this.forwardStackSections.length > 0 != null) {
            this.showSection(this.forwardStackSections.pop());
        }
    };
    /**
     * Clear forward stacks
     */
    ProductSelectorComponent.prototype.clearForwardStacks = function () {
        this.forwardStack = [];
        this.forwardStackSections = [];
    };
    /**
     * Emulate user subscription to news
     */
    ProductSelectorComponent.prototype.subscribeUserToNews = function () {
        alert("subscribed!");
    };
    ProductSelectorComponent = __decorate([
        core_1.Component({
            selector: 'product-selector',
            moduleId: module.id,
            templateUrl: 'product-selector.component.html'
        }), 
        __metadata('design:paramtypes', [product_selector_service_1.ProductSelectorService, router_1.Router])
    ], ProductSelectorComponent);
    return ProductSelectorComponent;
}());
exports.ProductSelectorComponent = ProductSelectorComponent;
//# sourceMappingURL=product-selector.component.js.map