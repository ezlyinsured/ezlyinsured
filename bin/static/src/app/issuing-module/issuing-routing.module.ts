import { NgModule }                from '@angular/core';
import { RouterModule, Routes  }   from '@angular/router';
import { QuoteComponent  }   from './quote/quote.component';


//routes
const issuingRoutes: Routes = [
                        { path: 'quote', component: QuoteComponent }
];

@NgModule({
    imports: [ RouterModule.forChild(issuingRoutes) ],
    exports: [ RouterModule ]
})
/**
 * Routing module for Issuing module
 * @author ccasallas
 *
*/
export class IssuingRoutingModule {}