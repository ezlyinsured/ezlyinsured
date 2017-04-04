import { Component, OnInit } from '@angular/core';
import { AngularFire, FirebaseListObservable, AuthProviders, AuthMethods } from 'angularfire2';

@Component({
    selector: 'ezly',
    templateUrl: './app.component.html'
})

/**
 * Root component.
 * @author ccasallas
 *
*/
export class AppComponent implements OnInit {
    
    constructor(public af: AngularFire) {

    }

   ngOnInit(): void {
      // Email and password
      /*this.af.auth.login({
        email: 'ccasallas@4sighttech.com',
        password: 'test12',
      },
      {
        provider: AuthProviders.Password,
        method: AuthMethods.Password,
      }).then(() =>
        console.log("success login")
      ).catch(error => console.log(error));*/
    }
}