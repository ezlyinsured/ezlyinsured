import { Component} from '@angular/core';
import { Router } from '@angular/router';

import { ChatService } from '../../support/chat/chat.service';

/**
 * Start quote component.
 * @author ccasallas
 *
*/
@Component( {
    moduleId: module.id,
    templateUrl: 'start.component.html'
})
export class StartComponent {
    
    constructor(private chatService: ChatService) {}
    
    showChat(): void {
        this.chatService.show();
    }
    
}