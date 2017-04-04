import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {ButtonModule} from 'primeng/primeng';

import { ProductSelector } from './product-selector';
import { Question } from './question';
import { ProductSelectorService } from './product-selector.service';

//flags to validate if current question advance to 
// a positive or negative confirmation
const POSITIVE_END: number = -1;
const NEGATIVE_END: number = -2;

//constant to identify the main section of the component
const START_SECTION: number = 0;
const RAIL_SECTION: number = 1;
const POSITIVE_END_SECTION: number = 2;
const NEGATIVE_END_SECTION: number = 3;
const EMAIL_NOTIFY_SECTION: number = 4;

@Component({
    selector : 'product-selector',
    moduleId: module.id,
    templateUrl: 'product-selector.component.html'
})
/**
 * Product selector component to identify if the given product
 * is the right product for the user
 * @author ccasallas
 *
*/
export class ProductSelectorComponent implements OnInit{
  
    //attributes to controls sections visibility
    startVisible: boolean = true;
    railVisible: boolean = false;
    positiveEndVisible: boolean = false;
    negativeEndVisible: boolean = false;
    emailNotifyVisible: boolean = false;
    //attributes which store showed data each section
    productSelector: ProductSelector;
    questions: Question[];
    //attributes to controls navigations between sections
    currentQuestion: Question;
    currentSection: number = START_SECTION;
    rightProduct: boolean = false;
    backStack: Question[] = [];
    forwardStack: Question[] = [];
    forwardStackSections: number[] = [];
    
    /**
     * Default constructor, it wires product selector service
     * and router 
     */
    constructor(
        private productSelectorService: ProductSelectorService,
        private router: Router) {
    }

    /**
     * Do required operations during component initialization
     */
    ngOnInit(): void {
        this.getProductSelector();        
    }

    /**
     * Get product selector data
     */
    getProductSelector(): void {
        this.productSelectorService.getProductSelector(0)
        .then(productSelector => {
            this.productSelector = productSelector;
            this.currentQuestion = this.productSelector.questionRail.questions[0];
            this.questions = this.productSelector.questionRail.questions;
        })
        .catch(error => {
            //TODO enhanced error handling
            console.log("Error: " + error)
        });
    }
    
    /**
     * Navigate to product quote
     */
    goToQuote(): void {
        this.router.navigate(['/quick-quote', 1]);
    }
    
    /**
     * Navigate to rail section
     */
    goToRail(): void{
        this.showSectionAndClearForwardStack(RAIL_SECTION);
    }
    
    /**
     * Navigate to the right section after user
     * answer yes to a question.
     */
    answerYesToQuestion(): void {
        if(this.currentQuestion.onYes == POSITIVE_END) {
            this.showSectionAndClearForwardStack(POSITIVE_END_SECTION);
            this.rightProduct = true;
        } else if (this.currentQuestion.onYes == NEGATIVE_END){
            this.showSectionAndClearForwardStack(NEGATIVE_END_SECTION);
            this.rightProduct = false;
        } else {
            this.goToQuestion(this.currentQuestion.onYes);
        }
            
    }
    
    /**
     * Navigate to the right section after user
     * answer no to a question.
     */
    answerNoToQuestion(): void{
        if(this.currentQuestion.onNo == POSITIVE_END) {
            this.showSectionAndClearForwardStack(POSITIVE_END_SECTION);
            this.rightProduct = true;
        } else if (this.currentQuestion.onNo == NEGATIVE_END){
            this.showSectionAndClearForwardStack(NEGATIVE_END_SECTION);
            this.rightProduct = false;
        } else {
            this.goToQuestion(this.currentQuestion.onNo);
        }
    }
    
    /**
     * Navigate to the right section after user
     * answer "I don't know" to a question.
     */
    answerIdkToQuestion(): void{
        if(this.currentQuestion.onIdk == POSITIVE_END) {
            this.showSectionAndClearForwardStack(POSITIVE_END_SECTION);
            this.rightProduct = true;
        } else if (this.currentQuestion.onIdk == NEGATIVE_END){
            this.showSectionAndClearForwardStack(NEGATIVE_END_SECTION);
            this.rightProduct = false;
        } else {
            this.goToQuestion(this.currentQuestion.onIdk);
        }
    }
    
    /**
     * Get the question for the given questionId and set it
     * as current question.  
     */
    goToQuestion(questionId: number): void{
        for(var i = 0; i < this.questions.length; i++) {
            if(this.questions[i].id == questionId){
                this.backStack.push(this.currentQuestion);      //for go back and forward functionality 
                this.currentQuestion = this.questions[i];
                this.clearForwardStacks();                      //for go back and forward functionality
            }
        }
    }
    
    /**
     * Navigate to emailNotify section
     */
    goToEmailNotify(): void {  
        this.showSectionAndClearForwardStack(EMAIL_NOTIFY_SECTION);
    }
    
    /**
     * Reset product selector
     */
    resetProductSelector(): void {
        this.showSectionAndClearForwardStack(START_SECTION);
        this.currentQuestion = this.questions[0];
        this.backStack = [];
    }
    
    /**
     * Show the given section and hide the other sections
     */
    showSection(section:number): void {
        this.currentSection = section;
        this.startVisible = START_SECTION == section;
        this.railVisible = RAIL_SECTION == section;
        this.positiveEndVisible = POSITIVE_END_SECTION == section;
        this.negativeEndVisible = NEGATIVE_END_SECTION == section;
        this.emailNotifyVisible = EMAIL_NOTIFY_SECTION == section;
    }
    
    /**
     * Show the given section and hide the other sections. Also
     * clear forward stacks
     */
    showSectionAndClearForwardStack(section:number): void {
        this.showSection(section);
        this.clearForwardStacks();
    }
    
    /**
     * Go back command 
     */
    goBack(): void {
        if(this.currentSection == RAIL_SECTION) {
            if(this.backStack.length > 0){
                this.forwardStack.push(this.currentQuestion);
                this.currentQuestion = this.backStack.pop();
            } else {
                this.showSection(START_SECTION);
                this.forwardStackSections.push(RAIL_SECTION);
            }
        } else if(this.currentSection == POSITIVE_END_SECTION) {
            this.showSection(RAIL_SECTION);
            this.forwardStackSections.push(POSITIVE_END_SECTION);
        } else if(this.currentSection == NEGATIVE_END_SECTION) {
            this.showSection(RAIL_SECTION);
            this.forwardStackSections.push(NEGATIVE_END_SECTION);
        } else if(this.currentSection == EMAIL_NOTIFY_SECTION) {
            if(this.rightProduct) {
                this.showSection(POSITIVE_END_SECTION);
            } else {
                this.showSection(NEGATIVE_END_SECTION);
            }
            this.forwardStackSections.push(EMAIL_NOTIFY_SECTION);
        }
    }
    
    /**
     * Go forward command
     */
    goForward(): void {
        if(this.currentSection == RAIL_SECTION) {
            if(this.forwardStack.length > 0){
                this.backStack.push(this.currentQuestion);
                this.currentQuestion = this.forwardStack.pop();
                
            } else if(this.forwardStackSections.length > 0) {
                this.showSection(this.forwardStackSections.pop());
            }
        } else if(this.forwardStackSections.length > 0 != null) {
            this.showSection(this.forwardStackSections.pop());
        }
    }
    
    /**
     * Clear forward stacks
     */
    clearForwardStacks(): void {
        this.forwardStack = [];
        this.forwardStackSections = [];
    }
    
    /**
     * Emulate user subscription to news
     */
    subscribeUserToNews(): void {
        alert("subscribed!");
    }
}