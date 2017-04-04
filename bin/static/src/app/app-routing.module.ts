import { NgModule }                from '@angular/core';
import { RouterModule, Routes  }   from '@angular/router';
import { ProductSelectorComponent  }   from './shared/product-selector/product-selector.component';

import { StartComponent  }   from './issuing-module/quote/start.component';
import { QuoteComponent  }   from './issuing-module/quote/quote.component';
import { QuickQuoteComponent  }   from './issuing-module/quote/quick-quote.component';
import { QuoteNotifyProduct  }   from './quote-notify-product/quote-notify-product.component';
//import { LoginComponent} from './security/login/login.component';
import { AuthGuard} from './security/login/login.service';


const routes: Routes = [
                        { path: '', component: StartComponent },
                        { path: 'quick-quote/:productId', component: QuickQuoteComponent },
                        { path: 'quote', component: QuoteComponent },
                        { path: 'notify', component: QuoteNotifyProduct },
                        { path: 'agent-portal', loadChildren: 'app/agent-portal/agent-portal.module#AgentPortalModule'}
];

@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})
/**
 * Main routing module
 * @author ccasallas
 *
*/
export class AppRoutingModule {}