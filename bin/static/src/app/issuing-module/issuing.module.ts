import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule}    from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { MaterialModule } from '@angular/material';
//Angular 2 Localization.
import { LocaleModule, LocalizationModule } from 'angular2localization';
//IMP dependencies
import { StartComponent } from './quote/start.component';
import { QuoteComponent,FirstRiskLvlDialogComponent,SecondRiskLvlDialogComponent } from './quote/quote.component';
import { QuickQuoteComponent } from './quote/quick-quote.component';
import { QuoteService } from './quote/quote.service';

import { SharedModule }     from '../shared/shared.module';
//import { IssuiongRoutingModule }     from './issuing-routing.module';

@NgModule( {
    imports: [ CommonModule, SharedModule, RouterModule, LocaleModule.forRoot(), 
               LocalizationModule.forRoot(), FormsModule, MaterialModule.forRoot(),
               /*, IssuiongRoutingModule*/ ],
    declarations: [ StartComponent, QuoteComponent, QuickQuoteComponent,FirstRiskLvlDialogComponent,SecondRiskLvlDialogComponent],
    entryComponents: [FirstRiskLvlDialogComponent,SecondRiskLvlDialogComponent],
    exports: [ StartComponent, QuoteComponent, QuickQuoteComponent ],
    providers: [ QuoteService ]
})
/**
 * Module to group common components of policy issuing process
 * @author ccasallas
 *
*/
export class IssuingModule { }
