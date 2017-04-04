import { Component, AfterViewInit, ElementRef } from '@angular/core';
import { Router } from '@angular/router';
import { Message, OverlayPanel} from 'primeng/primeng';
import { Locale, LocaleService, LocalizationService } from 'angular2localization';

//IMP dependencies


declare var Ultima: any;

@Component({
    selector: 'imp',
    templateUrl: 'app/application.html'
})

/**
 * Root component.
 * @author jtorres
 *
*/
export class AppComponent extends Locale implements AfterViewInit {

    //Ultima them attributes
    layoutCompact: boolean = true;
    layoutMode: string = 'static';
    darkMenu: boolean = false;
    profileMode: string = 'inline';

    /**
     * AppComponent constructor.
    */
    constructor(private el: ElementRef,
                private router: Router,
                public locale: LocaleService, 
                public localization: LocalizationService){
        super(locale, localization);     
        
        // Adds the languages (ISO 639 two-letter or three-letter code).
        this.locale.addLanguages(['en', 'it']);

        // Required: default language, country (ISO 3166 two-letter, uppercase code) and expiry (No days). If the expiry is omitted, the cookie becomes a session cookie.
        // Selects the default language and country, regardless of the browser language, to avoid inconsistencies between the language and country.
        this.locale.definePreferredLocale('en', 'US', 30);

        // Optional: default currency (ISO 4217 three-letter code).
        this.locale.definePreferredCurrency('USD');

        // Initializes LocalizationService: asynchronous loading.
        this.localization.translationProvider('./resources/locale-'); // Required: initializes the translation provider with the given path prefix.
        this.localization.updateTranslation(); // Need to update the translation.

    }
    
    // Sets a new locale & currency.
    selectLocale(language: string, country: string, currency: string): void {

        this.locale.setCurrentLocale(language, country);
        this.locale.setCurrentCurrency(currency);

    }

    /**
     * AfterViewInit used by Ultima theme.
    */
    ngAfterViewInit() {
        Ultima.init(this.el.nativeElement);
    }

    /**
      * Function provied by Ultima theme to change the theme on Kalos. 
      * @param event Browser event.
      * @param theme Theme name to be retrieved from css files. 
    */
    changeTheme(event: any, theme: any) {
        let themeLink: HTMLLinkElement = <HTMLLinkElement>document.getElementById('theme-css');
        let layoutLink: HTMLLinkElement = <HTMLLinkElement>document.getElementById('layout-css');

        themeLink.href = '../resources/theme/theme-' + theme + '.css';
        layoutLink.href = '../resources/layout/css/layout-' + theme + '.css';
        event.preventDefault();
    }


}