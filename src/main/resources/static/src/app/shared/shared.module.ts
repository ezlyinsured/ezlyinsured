import { NgModule }            from '@angular/core';
import { CommonModule }        from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { MaterialModule } from '@angular/material';
import {FormsModule}    from '@angular/forms';
import {InputTextModule} from 'primeng/primeng';
import {DropdownModule} from 'primeng/primeng';

import { ProductSelectorComponent }     from './product-selector/product-selector.component';
import { ProductSelectorService }   from     './product-selector/product-selector.service';
import { SessionService }   from     './service/session.service';
import { DynaFieldComponent }     from './dyna-field/dyna-field.component';

@NgModule({
  imports:      [ CommonModule, RouterModule, InputTextModule, DropdownModule, FormsModule, MaterialModule.forRoot() ],
  declarations: [ ProductSelectorComponent, DynaFieldComponent  ],
  exports:      [ ProductSelectorComponent, DynaFieldComponent ],
  providers: [ ProductSelectorService, SessionService ]
})
/**
 * Module to group common components of IMP front-end
 * @author ccasallas
 *
*/
export class SharedModule { }
