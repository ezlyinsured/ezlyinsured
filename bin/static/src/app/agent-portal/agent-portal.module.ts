import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {MaterialModule} from '@angular/material';
import {AgentHomeComponent} from './components/home/agent-home.component';
import {AgentPortalRoutingModule} from './agent-portal-router.module';
import { LoginComponent } from './../security/login/login.component';
import {AgentPortalMainComponent} from './components/main/agent-portal-main.component';
import { RegisterComponent } from './../security/login/register.component';
import {HomeMapService} from './services/home-map.service';
import { AgmCoreModule } from 'angular2-google-maps/core';
import { AgentSupportModule } from './agent-support/agent-support.module';
import { AgentSupportComponent } from './agent-support/agent-support.component';
import { SupportModule } from '../support/support.module';

//Angular 2 Localization.
import { LocaleModule, LocalizationModule } from 'angular2localization';

@NgModule({
    imports:[CommonModule, AgentPortalRoutingModule, FormsModule,AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBEvulGn4g4dxUeOVW8HCHUMQdfND3GLRA'
    })
    ,LocaleModule.forRoot(), 
             LocalizationModule.forRoot(), MaterialModule.forRoot(),AgentSupportModule, SupportModule],
    declarations:[
                    AgentHomeComponent,
                    LoginComponent,
                    AgentPortalMainComponent,
                    RegisterComponent,
                    AgentSupportComponent],
                    providers:[HomeMapService]
})

export class AgentPortalModule{
    
    
}