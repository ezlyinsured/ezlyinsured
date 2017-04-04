import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { Locale, LocaleService, LocalizationService } from 'angular2localization';
import { MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import { AngularFire, FirebaseObjectObservable } from 'angularfire2';

import { SessionService } from '../../shared/service/session.service';
import { User } from '../../shared/model/user';
import { Chat } from './chat';
import { ChatService } from './chat.service';
import { QuoteShared } from '../../issuing-module/shared/model/configuration/quote-shared';
import { QuoteService } from '../../issuing-module/quote/quote.service';


/**
 * Chat component.
 * @author ccasallas
 *
*/
@Component( {
    selector: 'user-chat',
    moduleId: module.id,
    templateUrl: 'user-chat.component.html'
})
export class UserChatComponent implements OnInit {
    
    visible: boolean = false;
    //control variables to manage chat option
    activeChat: boolean= false;
    //quote: QuoteWrapper;
    chat: Chat;
    user: User = new User();
    fbChat: FirebaseObjectObservable<any>;

    /**
     * PolicySummary constructor.
    */
    constructor(private af: AngularFire,
                private sessionService: SessionService,
                private chatService: ChatService,
                private quoteService: QuoteService) {
        

            /*update visibility of chat based on message of other components*/
            chatService.chatVisibility$.subscribe(

                /**
                 * Inner function that listen the messages published by other components 
                 * and show them in the UI screen.
                 * @param message (KalosMessage published by other components).
                */
                visible => {
                    this.setVisible(visible);
                });
    }

    /**
     * On init for quote process
     */
    ngOnInit(): void {
        this.chat =  new Chat();
    }
    
    startChat():void {
        
        if(this.sessionService.existActiveUser()) {
            let activeUser = this.sessionService.getActiveUser();
            activeUser.name = this.user.name;
            activeUser.email = this.user.email;
            this.sessionService.updateActiveUser(activeUser).then(() => {
                this.createChat();
            });
        } else {
            let activeUser = new User();
            activeUser.name = this.user.name;
            activeUser.email = this.user.email;
            activeUser.zipcode = '';
            activeUser.quoteId = '';
            this.sessionService.createActiveUser(activeUser).then(()=> {
                this.createChat();
            }) ;
        } 
    }
    
    public createChat(): void {
     // relative URL, uses the database url provided in bootstrap
        this.fbChat = this.af.database.object(`/chats/${this.sessionService.getActiveUserId()}`);
        this.fbChat.set(this.chat);
        this.fbChat.subscribe(chat => {
            this.chat = chat;
            if(!this.chat.messages) { //firebase not store null or empty props
                this.chat.messages = [];
            }
        });
        
        this.activeChat = true;
    }
    
    addMessage(message:string): void {
        this.chat.messages.push(message);
        this.fbChat.update({ messages: this.chat.messages });
    }
    
    setVisible(visible:boolean): void {
        this.visible = visible;
    }
    
    hide(): void {
        this.visible = false;
    }
    
    confirmRemoteAssistence() {
        this.fbChat.update({ 
            requestRemoteAssist: false,
            confirmRemoteAssist: true
        }).then(data => {
            let quote:QuoteShared = new QuoteShared();
            quote.policy = this.quoteService.getPolicyToQuote();
            
            let fbQuote = this.af.database.object(`/quotes/${this.sessionService.getActiveUserId()}`);
            fbQuote.set(quote).then(data => {
                this.chatService.confirmQuoteSharing();
            }); 
       });
    }
}