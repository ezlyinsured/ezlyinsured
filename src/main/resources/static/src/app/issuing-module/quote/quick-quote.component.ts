import { Component, OnInit, AfterViewInit  } from '@angular/core';
import { Router, ActivatedRoute, Params }   from '@angular/router';
//import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/switchMap';

import { ProductVariableData } from '../shared/model/configuration/product-variable-data';
import { Policy } from '../shared/model/core/policy';
import { Product } from '../shared/model/core/product';
import { VariableData } from '../shared/model/core/variable-data';
import { MasterVariableData } from '../shared/model/configuration/master-variable-data';
import { Risk } from '../shared/model/core/risk';
import { ProductCoverage } from '../shared/model/configuration/product-coverage';
import { QuoteService } from './quote.service';
import { SessionService } from '../../shared/service/session.service';
import { DynaFieldComponent } from '../../shared/dyna-field/dyna-field.component';
import { ISelectable } from '../../shared/dyna-field/selectable';
import { User } from '../../shared/model/user';
import { ChatService } from '../../support/chat/chat.service';

//jquery declaration
declare var $: any

@Component({
    selector: 'quick-quote',
    moduleId: module.id,
    templateUrl: 'quick-quote.component.html'
})
/**
 * Quick quote component.
 * @author ccasallas
 *
*/
export class QuickQuoteComponent implements OnInit, AfterViewInit {
    
    /**
     * Product variable data of product to quote
     */
    productVariableData: ProductVariableData;
    
    /**
     * product policy coverage configuration
     */
    covGroupPolicyLevel:ProductCoverage;
    /**
     * product risks coverage configuration
     */
    covGroupRiskLevel: ProductCoverage;

    /**
     * Default constructor, it wires quote service,
     * active route and router 
     */
    constructor(
        private quoteService: QuoteService,
        private activeRoute: ActivatedRoute,
        private router: Router,
        private sessionService: SessionService,
        private chatService: ChatService) {
    }
    
    /**
     * Bind jquery events
     */
    ngAfterViewInit() {
        
        $(".mobile-header-nav").click(function (e:any) {
            e.stopPropagation();
          });
              
          $(".navbar-toggle").click(function (e:any) {
            $(".mobile-header-nav").slideToggle(200);
            e.stopPropagation();
          });
    }
    
    /**
     * Do required operations during component initialization
     */
    ngOnInit(): void {
        this.getProductConfig();
    }
    
    /**
     * Get variable data for product
     */
    getProductConfig(): void {
        
        this.activeRoute.params
            .map((params: Params) => params['productId'])
            .subscribe((productId: string) => {
                //get product variable data
                this.quoteService.getProductVariableData(productId).then(productVariableData => {
                    this.productVariableData = productVariableData; 
                })
                .catch((error) => {
                    console.log("Error getting variable: " + error);
                });
                
                //initializating the configuration of coverage at policy level
                this.quoteService.getCoveragePolicyLevel(productId).then(productCoverage => {
                    this.covGroupPolicyLevel = productCoverage;
                })
                .catch( error => {
                    console.log( "Error getting coverages at policy level: " + error )
                });
                
              //initializating the configuration of coverage at risk level
                this.quoteService.getCoverageRiskLevel(productId).then( productCoverage => {
                    this.covGroupRiskLevel = productCoverage;
                })
                .catch( error => {
                    console.log( "Error getting coverages at risk level: " + error )
                });
            });
    }
    
    /**
     * Check if all fields of variable data form are valid
     */
    isValid(): boolean {
        
        if(this.productVariableData) {
            var isValid: boolean = true;
            this.productVariableData.masterVariableDataList.forEach((vData: MasterVariableData ) => {
                var currentValid: boolean = false;
                if(vData.isValid()) {
                    currentValid = true;
                }
                isValid = isValid && currentValid;
            });
            return isValid;
        } else {
            return false;
        }
    }
    
    /**
     * Create a data variable list from master variable data and
     * data provides by user
     */
    populateVariableData(): VariableData[] {
        var variableDataList: VariableData[] = [];
        this.productVariableData.masterVariableDataList.forEach((masterVData: MasterVariableData ) => {
            var vData: VariableData = new VariableData();
            vData.code = masterVData.code;
            
            if(masterVData.inputProperties.typeVariable == 'OP') {
                vData.value = masterVData.getValue();
            } else if(masterVData.inputProperties.typeVariable == 'RB' ||
                    masterVData.inputProperties.typeVariable == 'SL') {
                vData.value = masterVData.getValue().code;
            }
            
            vData.masterVariableData = masterVData;
            
            variableDataList.push(vData);
        });
        return variableDataList;
    }
    
    /**
     * Define policy to quote 
     */
    quickQuote(): void {
        //define product
        let product : Product = new Product();
        product.id = this.productVariableData.product.id;
        
        //define default risk
        let risk: Risk = new Risk();
        risk.id = 1;
        risk.name = "Location 1"; //TODO risk name depends from product
        risk.riskNumber = 1;
        risk.variableDataRisk = [];
        risk.coverages = this.covGroupRiskLevel.coveragesGroupList[0].coverages;
        risk.childrenRisks = [];
        
        //if there are second level risks then define
        //a default second level risk
        if(this.covGroupRiskLevel.coveragesGroupList.length > 1) {
            let slRisk: Risk = new Risk;
            slRisk.id = 2;
            slRisk.name = "Building 1"; //TODO risk name depends from product
            slRisk.riskNumber = 2;
            slRisk.variableDataRisk = [];
            slRisk.coverages = this.covGroupRiskLevel.coveragesGroupList[1].coverages;
            risk.childrenRisks.push(slRisk);
        }
        
        //define policy
        let policy: Policy = new Policy();
        policy.policyNumber= Date.now() + '' + Math.floor((Math.random() * 100) + 1);
        //set product
        policy.product = product;
        //set variable data
        policy.variableDataList = this.populateVariableData();
        //set default risks
        policy.risks = [];
        policy.risks.push(risk);
        //set policy coverage groups
        policy.coveragesGroups = this.covGroupPolicyLevel.coveragesGroupList;
        
        //add active user to session
        if(!this.sessionService.existActiveUser()) {
            let user = new User();
            user.email = '';
            user.name = '';
            user.zipcode = policy.variableDataList[0].value;
            user.quoteId = policy.policyNumber;
            this.sessionService.createActiveUser(user).then(()=> {
                //set policy as policy to quote and navigate to quote component
                this.quoteService.setPolicyToQuote(policy);
                this.router.navigate(['quote']);
            }) ;
        } else { // update active user
            let user = this.sessionService.getActiveUser();
            user.zipcode = policy.variableDataList[0].value;
            user.quoteId = policy.policyNumber;
            this.sessionService.updateActiveUser(user).then(() => {
                //set policy as policy to quote and navigate to quote component
                this.quoteService.setPolicyToQuote(policy);
                this.router.navigate(['quote']);
            }) ;
        }
        
        
    }
    
    showChat(): void {
        this.chatService.show();
    }
}