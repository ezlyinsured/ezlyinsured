import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {MaterialModule} from '@angular/material';
//import { AgentSupportRoutingModule } from './agent-support-routing.module';
import { QuoteAssistanceComponent } from './quote-assistance/quote-assistance.component';
import { QuoteAssistanceService } from './quote-assistance/quote-assistance.service';
@NgModule({
    imports:[CommonModule, /*AgentSupportRoutingModule,*/ FormsModule, MaterialModule.forRoot()],
    declarations:[ QuoteAssistanceComponent],
    providers: [ QuoteAssistanceService ],
    exports: [ QuoteAssistanceComponent]
})

export class AgentSupportModule{
    
    
}