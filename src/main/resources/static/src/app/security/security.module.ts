import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {MaterialModule} from '@angular/material';
import { SharedModule }     from '../shared/shared.module';
import { LocaleModule, LocalizationModule } from 'angular2localization';
import {LoginComponent} from './login/login.component';
import {AuthGuard} from './login/login.service';

@NgModule({
  
    imports: [ CommonModule, SharedModule, RouterModule, LocaleModule.forRoot(), 
               LocalizationModule.forRoot(), FormsModule, MaterialModule.forRoot(),
               ],
               declarations: [ LoginComponent],
    entryComponents: [LoginComponent],
    exports: [ LoginComponent ],
    providers: [ AuthGuard ]
})

export class SecurityModule{

    
    
}