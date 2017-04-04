import { Component} from '@angular/core';
import { Router } from '@angular/router';
import { Locale, LocaleService, LocalizationService } from 'angular2localization';

@Component({
    selector: 'imp',
    templateUrl: './quote-notify-product-tmpl.html'})
    
/**
 * Component dashboard responsable to show in UI the most importan functinalies in Kalos App.
 * @author jtorres
 *
*/   
export class QuoteNotifyProduct extends Locale{
    
    /**
     * DashComponent constructor.
    */
    constructor(
        private router: Router,
        public locale: LocaleService, 
        public localization: LocalizationService) {
        super(locale, localization);  
    }
        
    /**
      * TEMPORARY!!! function to call the module that is lazy loaded. 
    */
    gotoDetail() {
        this.router.navigate(['/conf']);
    }
    
    // Sets a new locale & currency.
    selectLocale(language: string, country: string, currency: string): void {

        this.locale.setCurrentLocale(language, country);
        this.locale.setCurrentCurrency(currency);

    }
    
}