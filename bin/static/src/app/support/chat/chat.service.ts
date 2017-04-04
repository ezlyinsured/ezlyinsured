import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { AngularFire, FirebaseObjectObservable } from 'angularfire2';
import { Chat } from './chat';
import { User } from '../../shared/model/user';
import { SessionService } from '../../shared/service/session.service';

import {Observable} from "rxjs/Observable";
import {Subject} from "rxjs/Subject";

/**
 * Chat service.
 * @author jtorres
 *
*/
@Injectable()
export class ChatService {

    //control variables to manage chat option
    activeChat: boolean = false;
    //quote: QuoteWrapper;
    chat: Chat;
    user: User = new User();
    fbChat: FirebaseObjectObservable<any>;

    //chat visibility stream
    private _chatVisibility = new Subject<boolean>();
    
    //chat visibility stream
    private _quoteSharing = new Subject<boolean>();
    
    //resource used to subscribe to chat visibility management.
    chatVisibility$ = this._chatVisibility.asObservable();
    
    //resource used to subscribe to quote sharing management.
    quoteSharing$ = this._quoteSharing.asObservable();

    constructor( private af: AngularFire,
        private sessionService: SessionService ) {
    }

    public getUserActiveChat ():string{
        
        return this.sessionService.getActiveUserId();
        
    }


    public createChat(): void {
        // relative URL, uses the database url provided in bootstrap
        this.fbChat = this.af.database.object( `/chats/${this.sessionService.getActiveUserId()}` );
        this.fbChat.set( this.chat );
        this.fbChat.subscribe( chat => {
            this.chat = chat;
            if ( !this.chat.messages ) { //firebase not store null or empty props
                this.chat.messages = [];
            }
        });

        this.activeChat = true;
    }


    /**
     * send request to remote assistance 
     */
//    sendRemoteAssistance(): void {
//
//        //retrieving the active user that currently requires assistance
//        /*****TEMPORAL UNCOMMENT THE COMMENT LINE AND REMOVE THE HARDCODED ONE****/
////        let idActiveUser: string = this.sessionService.getActiveUserId()
//         let idActiveUser: string = "-KeFSC-f3ZduarqrtYdm";
//        /**************************************************************************/
//        
//        
//        let currentChatActiveUser = this.af.database.object( '/chats/' + idActiveUser );
//        currentChatActiveUser.update( {confirmRemoteAssist:true} );
//    }

    show() {
        this._chatVisibility.next(true);
    }
    
    hide() {
        this._chatVisibility.next(false);
    }
    
    confirmQuoteSharing() {
        this._quoteSharing.next(true);
    }

}