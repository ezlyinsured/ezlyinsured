import { Component, ElementRef, ViewContainerRef, OnInit} from '@angular/core';
import { Router, ActivatedRoute, Params }   from '@angular/router';
import { Locale, LocaleService, LocalizationService } from 'angular2localization';
import { MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import { AngularFire, FirebaseObjectObservable } from 'angularfire2';

//IMP dependencies
import { Policy } from '../../shared/model/core/policy';
import { Risk } from '../../shared/model/core/risk';
import { Coverage } from '../../shared/model/core/coverage';
import { VariableData } from '../../shared/model/core/variable-data';
import { PolicySummary } from '../../shared/model/core/policy-summary';
import { CoverageGroup } from '../../shared/model/core/coverage-group';
import { ProductCoverage } from '../../shared/model/configuration/product-coverage';
import { QuoteAssistanceService } from './quote-assistance.service';

//jquery declaration
declare var $: any
const MAX_TIME: number = 10;
/**
 * Quote component.
 * @author ccasallas
 *
*/
@Component( {
    selector: 'quote-assistance',
    moduleId: module.id,
    templateUrl: 'quote-assistance.component.html'
})
export class QuoteAssistanceComponent extends Locale implements OnInit{
    
    AGENT_SUBJECT :string = "agent"; 
    CLIENT_SUBJECT :string = "client"; 

    policies: PolicySummary[] = [];
    tmpPolicies: PolicySummary[] = [];
    bestPolicy: PolicySummary;
    covGroupRiskLevel: ProductCoverage;
    covGroupPolicyLevel: ProductCoverage;
    activeUserId: string;


    //dialog reference
    dialogRef: MdDialogRef<any>;

    policy: Policy;

    currentVisible: string;

    selectedCov: number= 1;
    selectedChildRiskCov: number= 1;

    currentRisk: Risk;
    
    //control variables for pending changes
    timerId: any;
    timeLeftChanges = MAX_TIME;
    timerStarted: boolean = false;
    subject:string;
    
    //control variables to emulate async quote
    quoteTimerId: any;
    searchingResults: boolean = false;
    searchingRecommended: boolean =false;

    //firebase to share the policy structure
    fbQuoteShared: FirebaseObjectObservable<any>;
    
    /**
     * On init for quote process
     */
    ngOnInit(): void {
        
        //calling the policy with previous data processed
        this.policy = this.quoteService.getPolicyToQuote();
        //initializating the configuration of coverage at policy level
        this.quoteService.getCoveragePolicyLevel(this.policy.product.id)
        .then( productCoverage => {
            this.covGroupPolicyLevel = productCoverage;
        })
        //initializating the configuration of coverage at risk level
        this.quoteService.getCoverageRiskLevel(this.policy.product.id)
        .then( productCoverage => {
            this.prepareCovsRiskLevel(productCoverage);
        })
        .catch( error => {
            console.log( "Error getting coverages at risk level: " + error )
        });
        
        //retrieving user id
        this.getUserActiveConfig();
        
        this.currentVisible = 'policyInfo';
    }
    

    /**
     * PolicySummary constructor.
    */
    constructor(
        private router: Router,
        public locale: LocaleService,
        public localization: LocalizationService,
        private activeRoute: ActivatedRoute,
        private quoteService: QuoteAssistanceService, 
        public dialog: MdDialog,
        public viewContainerRef: ViewContainerRef,
        private af: AngularFire) {
        super( locale, localization );
    }
    
    /**
     * Get active user to chat and to haver assistance
     */
    getUserActiveConfig(): void {
        
        this.activeRoute.params
            .map((params: Params) => params['activeUserId'])
            .subscribe((activeUserId: string) => {
                //get product variable data
                this.activeUserId = activeUserId;
                //suscribing to watch the policy object
                this.fbQuoteShared = this.af.database.object('/quotes/'+this.activeUserId);
                this.fbQuoteShared.subscribe(quoteShared=>{
                    this.policy = quoteShared.policy;
                    this.subject = this.CLIENT_SUBJECT;
                    this.activateChangesCountDown(this.CLIENT_SUBJECT);
                });
            });
    }


    /**
     * Function to call the quick quote 
     */
    callQuickQuote(): void {
        
        //clear on fly interval if exists one
        if(this.searchingResults) {
            clearInterval(this.quoteTimerId);
            this.quoteTimerId = null;
        }
        
        //init search
        this.searchingResults = true;
        this.searchingRecommended = true;
        this.policies = [];
        
        this.quoteService.callQuickQuote( this.policy )
            .then( policies => {
                this.tmpPolicies = policies;
                
                this.quoteTimerId = setInterval(() => {  
                    
                    if(this.searchingRecommended) {
                        this.bestPolicy = this.tmpPolicies.shift();
                        this.searchingRecommended = false;
                    }
                    
                    if(this.tmpPolicies.length > 0) {
                        if(!this.searchingRecommended) {
                            this.policies.push(this.tmpPolicies.shift());
                        }
                        
                    } else {
                        clearInterval(this.quoteTimerId);
                        this.searchingResults = false;
                    }
                    
                }, 2000); 
            })
            .catch( error => {
                console.log( "Error quick quote summary: " + error )
            });
    }
    
    
    /**
     * Set visibility of forms groups
     */
    calculatingScoreBar (percentageCovs:number ): string{
        
        let scoreClass:string =  "comparison-status-icon";
        
        //enable the policy coverage forms
        if (0<percentageCovs && percentageCovs<=20){
            scoreClass = scoreClass + " checked-2";
        }else if (20<percentageCovs && percentageCovs<=40){
                scoreClass = scoreClass + " checked-3";
        }else if (60<percentageCovs && percentageCovs<=80){
                scoreClass = scoreClass + " checked-4";
        }else if (80<percentageCovs && percentageCovs<=100){
                scoreClass = scoreClass + " checked-5";
        }else{
           scoreClass = scoreClass + " checked-1";   
        }
        
        return scoreClass;
    }
    
    /**
     * Set visibility of forms groups
     */
    onEditPolicyCovs (): void{
        //enable the policy coverage forms
        this.currentVisible = "policyCov";
    }
    
    /**
     * Show form to edit policy information
     */
    onEditPolicyInfo(): void {
        this.currentVisible = 'policyInfo';
    }
    
    /**
     * Show form to edit locations
     */
    onEditFirstLevelAllRisk(): void {
        this.currentVisible = 'firstLevelAllRisk';
    }
    
    /**
     * Show form to edit the given first level risk
     */
    onEditFirstLevelRisk(risk: Risk): void {
        this.currentRisk = risk;
        this.currentVisible = 'firstLevelRiskSelection';
    }
    
    /**
     * Show form to edit the given second level risk
     */
    onEditSecondLevelRisk(risk: Risk): void {
        this.currentRisk = risk;
        this.currentVisible = 'secondLevelRiskSelection';
    }
    
    /**
     * Dialog management for first level risk
     */
    callFirstRiskLvlDialog(dialogMode: String,riskRef:Risk): void {
        let config = new MdDialogConfig();
        config.viewContainerRef = this.viewContainerRef;
        this.dialogRef = this.dialog.open(FirstRiskLvlDialogComponent,config);
        //passing parameters to make the specific CRUD operation
        this.dialogRef.componentInstance.dialogMode = dialogMode;
        this.dialogRef.componentInstance.risksRef = this.policy.risks;
        this.dialogRef.componentInstance.covGroupRiskLevel = this.covGroupRiskLevel;
        this.dialogRef.componentInstance.riskRef = riskRef;
        if (dialogMode=='edit'){
            this.dialogRef.componentInstance.riskBackUp = JSON.parse(JSON.stringify(riskRef));
        }
        this.dialogRef.afterClosed().subscribe(result => {
          this.dialogRef = null;
          if(result) {
              this.activateChangesCountDown(this.AGENT_SUBJECT);
          }
        });
    }
    
    
    /**
     * Dialog management for second level risk
     */
    callSecondRiskLvlDialog(dialogMode: String,parentRisk:Risk,riskRef:Risk): void {
        let config = new MdDialogConfig();
        config.viewContainerRef = this.viewContainerRef;
        this.dialogRef = this.dialog.open(SecondRiskLvlDialogComponent,config);
        //passing parameters to make the specific CRUD operation
        this.dialogRef.componentInstance.dialogMode = dialogMode;
        this.dialogRef.componentInstance.risksRef = this.policy.risks;
        this.dialogRef.componentInstance.covGroupRiskLevel = this.covGroupRiskLevel;
        this.dialogRef.componentInstance.parentRisk = parentRisk;
        this.dialogRef.componentInstance.riskRef = riskRef;
        if (dialogMode=='edit'){
            this.dialogRef.componentInstance.riskBackUp = JSON.parse(JSON.stringify(riskRef));
        }
        this.dialogRef.afterClosed().subscribe(result => {
          this.dialogRef = null;
          if(result) {
              this.activateChangesCountDown(this.AGENT_SUBJECT);
          }
        });
    }
    
    /**
     * Set coverage groups at risk level
     */
    prepareCovsRiskLevel(productCoverage: ProductCoverage): void {
        this.covGroupRiskLevel = productCoverage;
    }
    
    /**
     * On change variable data handler
     */
    onChangeVariableData(variableData: VariableData, newValue:string): void {
        variableData.value = newValue;
        this.activateChangesCountDown(this.AGENT_SUBJECT);
    }
    
    /**
     * On change coverage handler
     */
    onChangeCoverage(coverage: Coverage): void {
        coverage.contracted = !coverage.contracted;
        this.activateChangesCountDown(this.AGENT_SUBJECT);
    }
    
    /**
     * Start count down to apply pending changes 
     */
    activateChangesCountDown(subject :string): void {
         
        this.subject = subject;
        
        if(!this.timerStarted) {
            this.timerId = setInterval(() => {  
                this.timeLeftChanges--;
                
                if(this.timeLeftChanges == 0) {
                    this.applyChangesNow(subject);
                }
                
            }, 1000); 
            this.timerStarted = true;
        }
    }
    
    /**
     * Apply pending changes immediately
     */
    applyChangesNow(subject:string): void {
        
        if (subject==this.AGENT_SUBJECT){
            this.fbQuoteShared.update( {policy:this.policy} );
        }
        
        clearInterval(this.timerId);
        this.timerId = null;
        this.timerStarted = false;
        this.timeLeftChanges = 10;
        this.callQuickQuote();
    }
    
    /**
     * dummy help handler
     */
    openHelp(): void {
        $('#helpModal').modal('toggle');
    }
}

/*****    Dialog for CRUD operations  *****/

//First Risk Level Dialog Component
@Component({
    selector: 'rskFirstLvlDialog',
    template: `
      <div *ngIf="dialogMode == 'create'">
        <h1 md-dialog-title>New location</h1>
        <div md-dialog-content>
            
            <md-input-container>
                <input mdInput placeholder="Location Name" [(ngModel)]="risk.name" required/>
            </md-input-container>
        
        </div>
        <div md-dialog-actions>
            <button md-raised-button (click)="save()">Save</button>
            <button md-raised-button (click)="dialogRef.close()">Cancel</button>
        </div>
      </div>
      <div *ngIf="dialogMode == 'edit'">
        <h1 md-dialog-title>Edit location</h1>
         <div md-dialog-content>
            <md-input-container>
                <input mdInput placeholder="Location Name" [(ngModel)]="riskRef.name" required/>
            </md-input-container>
        </div>
        <div md-dialog-actions>
            <button md-raised-button (click)="dialogRef.close()">Save</button>
            <button md-raised-button (click)="cancelEdit()">Cancel</button>
        </div>
      </div>
      <div *ngIf="dialogMode == 'remove'">
        <h1 md-dialog-title>Remove location</h1>
        <div md-dialog-content>    
             <p>Are you sure to remove this location?</p>
        </div>
        <div md-dialog-actions>
            <button md-raised-button (click)="remove()">Yes</button>
            <button md-raised-button (click)="dialogRef.close()">No</button>
        </div>
      </div>
    `
  })

export class FirstRiskLvlDialogComponent {
  dialogMode: string;
  risksRef: Risk[];
  riskRef:Risk;
  riskBackUp: Risk;
  risk:Risk = new Risk();
  covGroupRiskLevel: ProductCoverage;

  constructor(public dialogRef: MdDialogRef<FirstRiskLvlDialogComponent>) { }
  
  /**
   * Create a new first level Risk 
   */
  save():void  {    
      // creating the new risk
      this.risk.id = this.risksRef.length + 1;
      this.risk.riskNumber = this.risksRef.length + 1;
      this.risk.childrenRisks= [];   
      //associating the coverage configuration
      let clonedCoverageConf:Coverage[] = JSON.parse(JSON.stringify(this.covGroupRiskLevel.coveragesGroupList[0].coverages));
      this.risk.coverages = clonedCoverageConf;
      //adding the new risk the list
      this.risksRef.push(this.risk);
      //cleaning the risk object
      this.risk= new Risk();      
      //finish the create operation
      this.dialogRef.close(true);
  }
 
  /**
   * Remove an existing first level Risk 
   */
  remove():void  {    
      //removing the risk of the risk list
      let index: number = this.risksRef.indexOf(this.riskRef);
      this.risksRef.splice(index,1);
  
      //finish the remove operation
      this.dialogRef.close(true);
  }
    
  /**
   * Cancel an edit operation of first level Risk 
  */
  cancelEdit():void {
      //assigning the backup risk
      this.riskRef.name = this.riskBackUp.name;
      
      //finish the edit operation
      this.dialogRef.close();
  }
  
  
}

//Second Risk Level Dialog Component
@Component({
    selector: 'rskSecondLvlDialog',
    template: `
      <div *ngIf="dialogMode == 'create'">
        <h1 md-dialog-title>New Building</h1>
        <div md-dialog-content>
            
            <md-input-container>
                <input mdInput placeholder="Building Name" [(ngModel)]="risk.name" required/>
            </md-input-container>
        
        </div>
        <div md-dialog-actions>
            <button md-raised-button (click)="save()">Save</button>
            <button md-raised-button (click)="dialogRef.close()">Cancel</button>
        </div>
      </div>
      <div *ngIf="dialogMode == 'edit'">
        <h1 md-dialog-title>Edit Building</h1>
         <div md-dialog-content>
            <md-input-container>
                <input mdInput placeholder="Building Name" [(ngModel)]="riskRef.name" required/>
            </md-input-container>
        </div>
        <div md-dialog-actions>
            <button md-raised-button (click)="dialogRef.close()">Save</button>
            <button md-raised-button (click)="cancelEdit()">Cancel</button>
        </div>
      </div>
      <div *ngIf="dialogMode == 'remove'">
        <h1 md-dialog-title>Remove Building</h1>
        <div md-dialog-content>    
             <p>Are you sure to remove this building?</p>
        </div>
        <div md-dialog-actions>
            <button md-raised-button (click)="remove()">Yes</button>
            <button md-raised-button (click)="dialogRef.close()">No</button>
        </div>
      </div>
    `
  })

export class SecondRiskLvlDialogComponent {
  dialogMode: string;
  risksRef: Risk[];
  parentRisk:Risk
  riskRef:Risk;
  riskBackUp: Risk;
  risk:Risk = new Risk();
  
  covGroupRiskLevel: ProductCoverage;

  constructor(public dialogRef: MdDialogRef<SecondRiskLvlDialogComponent>) { }
  
  /**
   * Create a new first level Risk 
   */
  save():void  {    
      // creating the new risk
      this.risk.id = this.parentRisk.childrenRisks.length + 1;
      this.risk.riskNumber = this.parentRisk.childrenRisks.length + 1;
      this.risk.childrenRisks= [];   
      //associating the coverage configuration
      let clonedCoverageConf:Coverage[] = JSON.parse(JSON.stringify(this.covGroupRiskLevel.coveragesGroupList[1].coverages));
      this.risk.coverages = clonedCoverageConf;
      //adding the new risk the list
      this.parentRisk.childrenRisks.push(this.risk);
      //cleaning the risk object
      this.risk= new Risk();      
      //finish the create operation
      this.dialogRef.close(true);
  }
 
  /**
   * Remove an existing second level Risk 
   */
  remove():void  {    
      //removing the risk of the risk list
      let index: number = this.parentRisk.childrenRisks.indexOf(this.riskRef);
      this.parentRisk.childrenRisks.splice(index,1);
  
      //finish the remove operation
      this.dialogRef.close(true);
  }
    
  /**
   * Cancel an edit operation of second level Risk 
  */
  cancelEdit():void {
      //assigning the backup risk
      this.riskRef.name = this.riskBackUp.name;
      
      //finish the edit operation
      this.dialogRef.close();
  }
  
}