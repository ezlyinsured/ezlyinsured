import {Component,Input,Output,NgModule} from '@angular/core';
import { Router, ActivatedRoute}   from '@angular/router';
import { AngularFire, AuthProviders,AuthMethods } from 'angularfire2';
//import { LoginService} from './login.service';


@Component({
    selector: 'login',
    styleUrls:['styless.css'],
    templateUrl: 'login.html'
    

})

export class LoginComponent{
    portal: Number;
    isAuth = false;
    authColor = 'warn';
    user = {};
    error: any;
    state: string = '';
  constructor(
    public af: AngularFire,
    private router: Router,
    private route: ActivatedRoute
  )  {
    this.portal = route.snapshot.params['portal'];
    this.af.auth.subscribe(
      user => this._changeState(user),
      error => console.trace(error)
    )
    this.agentportalrouter();
  }
  
  signInWithFacebook() {
    return this.af.auth.login({
      provider: AuthProviders.Facebook,
      method: AuthMethods.Popup
    }).then(
        (success) => {
       this.agentportalrouter();
      }).catch(
        (err) => {
        this.error = err;
      })
    
  }

   signInWithGoogle() {
    return this.af.auth.login({
      provider: AuthProviders.Google,
      method: AuthMethods.Popup
      
    }).then(
        (success) => {
      this.agentportalrouter();
      }).catch(
        (err) => {
        this.error = err;
      })
  }
@Input() @Output()private email:string;
@Input() @Output()private password:string;


  signInWithEmailAndaPassword(email, password){
    {
      // Email and password
      this.af.auth.login({
        email:this.email,
        password:this.password,
      },
      {
        provider: AuthProviders.Password,
        method: AuthMethods.Password,
          }).then(
        (success) => {
      this.agentportalrouter();
      }).catch(
        (error) => {
        this.error = error;
      })
    }
  }
   signInWithTwitter() {
    return this.af.auth.login({
      provider: AuthProviders.Twitter,
      method: AuthMethods.Popup
      
    }).then(
        (success) => {
       this.agentportalrouter();
      }).catch(
        (err) => {
        this.error = err;
      })
       
    
    
  }



  logout() {
    this.af.auth.logout();
     console.log('logged out');
     this.router.navigateByUrl('login');
  }



    private _getUserInfo(user: any): any {
    if(!user) {
      return {};
    }
    let data = user.auth.providerData[0];
    return {
      name: data.displayName,
      avatar: data.photoURL,
      email: data.email,
      provider: data.providerId
    };
  }
 private _changeState(user: any = null) {
    if(user) {
      this.isAuth = true;
      this.authColor = 'primary';
      this.user = this._getUserInfo(user)
    }
    else {
      this.isAuth = false;
      this.authColor = 'warn';
      this.user = {};
    }
  }

  agentportalrouter(){
    this.af.auth.subscribe(auth => { 
      if(auth) {
        if(this.portal == 1){
          this.router.navigateByUrl('agent-portal/home');
        }else{
          this.router.navigateByUrl('quick-quote/:productId');
        }
      }
    });
  }
}
  


