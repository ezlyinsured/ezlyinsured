import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule}    from '@angular/forms';
import {MaterialModule} from '@angular/material';

//IMP dependencies
import { UserChatComponent } from './chat/user-chat.component';
import { AgentChatComponent } from './chat/agent-chat.component';
import { SessionService } from '../shared/service/session.service';

@NgModule( {
    imports: [ 
       CommonModule, 
       FormsModule,
       MaterialModule.forRoot()
    ],
    declarations: [ UserChatComponent, AgentChatComponent],
    exports: [ UserChatComponent, AgentChatComponent ],
    providers: [ ]
})
/**
 * Module to group common components of policy issuing process
 * @author ccasallas
 *
*/
export class SupportModule { }
