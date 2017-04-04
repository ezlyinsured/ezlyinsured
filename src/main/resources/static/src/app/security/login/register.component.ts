import {Component,Input,Output,EventEmitter,NgModule,Inject} from '@angular/core';
import {NgForm} from '@angular/forms';
import { AngularFire, AuthProviders, FirebaseRef, FirebaseApp } from 'angularfire2';
import {User} from './User';
import * as firebase from 'firebase';
import {LoginComponent} from './login.component';



@Component({    
    selector:'register-component',
    templateUrl:'register.html',
    styleUrls:['styless.css']
})

export class RegisterComponent
{
    private message:string='Error';
    @Output() private msg= new EventEmitter();
    @Output() @Input() private email:string;
    @Output() @Input() private password:string;
    @Output() @Input() private password_vrf:string;
    @Output() @Input() private email_vrf:string;
    @Output() @Input() private user:User;
    private image:String;
    private Uid:String;
    private loginComponent:LoginComponent; 
    constructor(public af:AngularFire,@Inject(FirebaseApp) public firebaseApp: firebase.app.App){
        this.user = new User() ;
    }

CrtUser():void{
    this.af.auth.createUser({
        email:this.email,
        password:this.password
    }).then( createUSer =>{
        createUSer.auth.updateProfile({ 
            displayName: this.user.firstName+' '+this.user.lastName,
            photoURL: ""
        }).then(function(createUser){
            this.Uid=createUser.get(createUser.uid);
            createUser.photoURL=this.Uid+'/';
        })
    }).catch(
            onReject => console.log(onReject.message))
}




}
