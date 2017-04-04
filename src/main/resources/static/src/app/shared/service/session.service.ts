import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { AngularFire, FirebaseObjectObservable } from 'angularfire2';
import { User } from '../model/user';

/**
 * Session service.
 * @author ccasallas
 *
*/
@Injectable()
export class SessionService {
    
    private activeUserId: string = null;
    private activeUser: User;
    
    constructor( private af: AngularFire ) { }
    
   
    /**
     * Create an active user
     */
    createActiveUser(user: User ): Promise<void> {

        user.lastUpdate = new Date().getTime();
        let activeUsers = this.af.database.list( '/activeUsers' );
        
        return new Promise<void>((resolve, reject) => {
            activeUsers.push(user).then(data => {
                this.activeUserId = data.key;
                this.activeUser = user;
                resolve();
            });
          });
    }
    
    /**
     * Create an active user
     */
    updateActiveUser(user: User ): Promise<void> {

        user.lastUpdate = new Date().getTime();
        let activeUser = this.af.database.object( '/activeUsers/' + this.activeUserId);
        
        return new Promise<void>((resolve, reject) => {
            activeUser.update(user).then(data => {
                this.activeUser = user;
                resolve();
            });
          });
    }
    
    /**
     * return true or false if exist or not an active user 
     */
    existActiveUser(): boolean {
        return this.activeUserId != null;
    }
    
    /**
     * return true or false if exist or not an active user 
     */
    getActiveUser(): User {
        return this.activeUser;
    }
    
    /**
     * return id of active user
     */
    getActiveUserId(): string {
        return this.activeUserId;
    }

}