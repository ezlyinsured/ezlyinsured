import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

//IMP imports
import { Field } from './field';


@Component({
    selector : 'dyna-field',
    moduleId: module.id,
    templateUrl: 'dyna-field.component.html'
})
/**
 * Field component with different templates according to a field type  
 * @author ccasallas
 *
*/
export class DynaFieldComponent implements OnInit{
  
    @Input() field: Field;
    @Output() fieldChange: EventEmitter<any> = new EventEmitter();

    /**
     * Do required operations during component initialization
     */
    ngOnInit(): void {
        this.field.prepareTemplate();       
    }
    
    /**
     * Emit field change for text fields
     */
    changeText(newValue: string): void {
        this.field.textValue = newValue;
        this.fieldChange.emit(newValue);
    }
    
    /**
     * Emit field change for single selection fields 
     */
    changeSingle(newValue: any): void {
        this.field.selectedItem = newValue;
        this.fieldChange.emit(newValue);
    }
    /**
     * Emit field change for multiple selection fields
     */
    changeMultiple(newValue: any): void {
        this.field.selectedItems = newValue;
        this.fieldChange.emit(newValue);
    }
}
