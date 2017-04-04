import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { AngularFireModule,AuthProviders,AuthMethods } from 'angularfire2';

//Angular 2 Localization.
import { LocaleModule, LocalizationModule } from 'angular2localization';

//IMP dependencies
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { SharedModule } from './shared/shared.module';
import { IssuingModule } from './issuing-module/issuing.module';
import { SupportModule } from './support/support.module';
import { ChatService } from './support/chat/chat.service';
import { QuoteNotifyProduct } from './quote-notify-product/quote-notify-product.component';
//import { LoginComponent} from './security/login/login.component';
import { AuthGuard} from './security/login/login.service';


//Firebase config
export const firebaseConfig = {
    apiKey: "AIzaSyAKAzxGs51Rnp1cATXv-qoGycuAeax34cg",
    authDomain: "ezly-43dd0.firebaseapp.com",
    databaseURL: "https://ezly-43dd0.firebaseio.com",
    storageBucket: "ezly-43dd0.appspot.com",
    messagingSenderId: "989149329956"
};
export const AuthConfiguration ={
    method: AuthMethods.Popup
}
  
    
  
@NgModule( {
    imports: [BrowserModule, IssuingModule, AppRoutingModule, HttpModule, FormsModule, SharedModule, SupportModule,
              LocaleModule.forRoot(), LocalizationModule.forRoot(), AngularFireModule.initializeApp(firebaseConfig) ],
    declarations: [AppComponent, QuoteNotifyProduct/*, LoginComponent*/],
    bootstrap: [AppComponent],
     providers: [AuthGuard, ChatService]
})
export class AppModule { }