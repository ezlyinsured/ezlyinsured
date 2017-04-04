import { NgModule }                from '@angular/core';
import { RouterModule, Routes  }   from '@angular/router';
import { AgentHomeComponent} from './components/home/agent-home.component';
import { LoginComponent } from './../security/login/login.component';
import {AgentPortalMainComponent} from './components/main/agent-portal-main.component';
import { RegisterComponent } from './../security/login/register.component';
import { AgentSupportComponent } from './agent-support/agent-support.component';

const routes: Routes = [
                        { path: '', component: AgentHomeComponent,
                            children:[
                            { path: 'home', component: AgentPortalMainComponent },
                            { path: 'login/:portal', component: LoginComponent },
                            { path: 'register', component: RegisterComponent },
                            { path: 'agent-support/:activeUserId', component: AgentSupportComponent }
                            ]}
                        

];

@NgModule({
    imports: [ RouterModule.forChild(routes) ],
    exports: [ RouterModule ]
})
/**
 * Agent Router module
 * @author Deybeer Gonzalez
 *
*/
export class AgentPortalRoutingModule {}