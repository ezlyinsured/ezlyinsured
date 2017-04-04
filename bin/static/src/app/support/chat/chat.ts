/**
* this object represents  
*
* @author ccasallas
*/

export class Chat {
    messages: string[];
    status: string;
    requestRemoteAssist:boolean;
    confirmRemoteAssist:boolean;
    
    public constructor() {
        this.messages = [];
        this.requestRemoteAssist = false;
        this.confirmRemoteAssist = false;
        
    }
}