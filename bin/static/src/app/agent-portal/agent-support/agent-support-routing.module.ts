import { NgModule }                from '@angular/core';
import { RouterModule, Routes  }   from '@angular/router';
import { AgentSupportComponent } from './agent-support.component';

const routes: Routes = [
                        { path: '', component: AgentSupportComponent}
];

@NgModule({
    imports: [ RouterModule.forChild(routes) ],
    exports: [ RouterModule ]
})
/**
 * Agent Assistance module
 * @author Juan Torres
 *
*/
export class AgentSupportRoutingModule {}