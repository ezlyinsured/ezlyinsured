import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { Locale, LocaleService, LocalizationService } from 'angular2localization';
import { MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import { AngularFire, FirebaseObjectObservable, FirebaseListObservable } from 'angularfire2';

import { SessionService } from '../../shared/service/session.service';
import { User } from '../../shared/model/user';
import { Chat } from './chat';
import { ChatService } from './chat.service';
import { QuoteShared } from '../../issuing-module/shared/model/configuration/quote-shared';
import { QuoteService } from '../../issuing-module/quote/quote.service';

//import { User} from '../../../shared/model/user';

/**
 * Chat component.
 * @author ccasallas
 *
*/
@Component( {
    selector: 'agent-chat',
    moduleId: module.id,
    templateUrl: 'agent-chat.component.html'
})
export class AgentChatComponent implements OnInit {
    
    selectedUser: boolean = false;
    visible: boolean = true;
    chat: Chat;
    user: User = new User();
    fbChat: FirebaseObjectObservable<any>;
    

    activeUsers: User[] = [];
    fbActiveUsers: FirebaseListObservable<any[]>;

    /**
     * PolicySummary constructor.
    */
    constructor(private af: AngularFire,
                private sessionService: SessionService,
                private chatService: ChatService,
                private quoteService: QuoteService,
                private router: Router) {
    }  
    
    ngOnInit(): void {
        this.chat =  new Chat();
        this.fbActiveUsers = this.af.database.list('/activeUsers');
        this.fbActiveUsers.subscribe(activeUsers => {
            this.activeUsers = activeUsers;
        });
    }
    
    /**
     * Navigate to product quote
     */
    goToSupport(user:any): void {
        this.fbChat.update({ 
            requestRemoteAssist: true,
        }).then(data => {
            this.router.navigate(['/agent-portal/agent-support', user.$key]); 
        });
    }
    
    startChat(user): void {
        this.selectedUser = true;
        this.fbChat = this.af.database.object(`/chats/${user.$key}`);
        this.fbChat.subscribe(chat => {
            this.chat = chat;
            if(!this.chat.messages) { //firebase not store null or empty props
                this.chat.messages = [];
            }
        });
    }
    
    public createChat(): void {
     // relative URL, uses the database url provided in bootstrap
        
    }
    
    addMessage(message:string): void {
        this.chat.messages.push(message);
        this.fbChat.update({ messages: this.chat.messages });
    }
    
    expand(): void {
        this.visible = true;
    }
    
    colapse(): void {
        this.visible = false;
    }
}