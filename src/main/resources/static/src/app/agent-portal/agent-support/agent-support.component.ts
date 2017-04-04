import {Component,  OnInit} from '@angular/core';
import { Router, ActivatedRoute, Params }   from '@angular/router';
import { AngularFire, FirebaseObjectObservable } from 'angularfire2';
import { SessionService } from '../../shared/service/session.service';
import { ChatService } from '../../support/chat/chat.service';
import { Policy } from '../shared/model/core/policy';
import { QuoteAssistanceService } from './quote-assistance/quote-assistance.service';

//EZLY dependencies
import {Chat} from '../../support/chat/chat';
import {QuoteShared} from '../shared/model/configuration/quote-shared';

@Component({
    moduleId: module.id,
    selector: 'agent-support',
    templateUrl: './agent-support.html'
    

})

export class AgentSupportComponent implements OnInit{  
    
   chat :Chat;
   policy :Policy;
   fbQuoteShared: FirebaseObjectObservable<any>;
   fbChat: FirebaseObjectObservable<any>;
   quoteShared:QuoteShared;
   activeUserId: string;

   constructor( private af: AngularFire,
                private sessionService: SessionService,
                private chatService: ChatService,
                private quoteAssistanceService: QuoteAssistanceService,
                private activeRoute: ActivatedRoute) {
   }

   /**
    * Do required operations during component initialization
   */
   ngOnInit(): void {
       this.chat =  new Chat();
       
       //creating the subscription to the new client
       this.quoteShared  = new QuoteShared()
       
       //listening the confiration to remote assistance
       this.getUserActiveConfig();
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
               this.fbChat = this.af.database.object('/chats/'+this.activeUserId);

               this.fbChat.subscribe(chat => {
                 this.chat =  chat;
                 if (this.chat.confirmRemoteAssist){
                     this.fbQuoteShared = this.af.database.object('/quotes/'+this.activeUserId);
                     this.fbQuoteShared.subscribe(quoteShared=>{
                         this.policy = quoteShared.policy;
                         this.quoteAssistanceService.setPolicyToQuote(this.policy);
                     });
                 }else{
                     this.policy =null;
                 }
             });
           });
   }

   
//   sendRemoteAssistance ():void{
//       this.chat.requestRemoteAssist = true;
//       this.chatService.sendRemoteAssistance();
//   }
   
   
}
