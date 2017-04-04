import {SelectItem} from 'primeng/primeng';
import { JsonMember, JsonObject } from 'typedjson-npm/src/typed-json';

import { ISelectable } from './selectable';

const TPL_OP: string = "OP";
const TPL_RB: string = "RB";
const TPL_CL: string = "CL";
const TPL_SL: string = "SL";

/**
* this object represents an abstract field
*
* @author ccasallas
*/
export abstract class Field {

    //attributes for template visibility
    @JsonMember({emitDefaultValue: true})
    visibleOP: boolean = false;
    @JsonMember({emitDefaultValue: true})
    visibleRB: boolean = false;
    @JsonMember({emitDefaultValue: true})
    visibleCL: boolean = false;
    @JsonMember({emitDefaultValue: true})
    visibleSL: boolean = false;
    @JsonMember({emitDefaultValue: true})
    placeholder: string = "";
    
    selectItems: SelectItem[] = [];
    selectedItems: ISelectable[] = [];
    selectedItem: ISelectable = null;
    textValue: string = null;
    
    /**
     * Abstract method implemented for the concrete
     * class to get field type
     */
    abstract getFieldType(): string;
    
    /**
     * Abstract method implemented for the concrete
     * class to get placeholder field
     */
    abstract initPlaceholder(): void;
    
    /**
     * Abstract method implemented for the concrete
     * class to get selectItems
     */
    abstract initSelectItems(): void;
    
    /**
     * Prepare the right template according to
     * the field type
     */
    prepareTemplate(): void {
        //define placeholder and type of field
        var fieldtype : string = this.getFieldType();
        this.initPlaceholder();
        
        //define visibility of the right template
        this.visibleOP = TPL_OP == fieldtype;
        this.visibleRB = TPL_RB == fieldtype;
        this.visibleCL = TPL_CL == fieldtype;
        
        if(this.visibleSL = TPL_SL == fieldtype) {
           this.prepareSLTemplate();
        }
    }
    
    /**
     * Init selection list template
     */
    prepareSLTemplate(): void {
        this.initSelectItems();
    }
    
    /**
     * Check if field complies all validations
     */
    isValid(): boolean {
        if(this.visibleOP) {
            if(this.textValue) {
              return this.textValue.length > 0;  
            } else {
                return false;
            }
        } else if(this.visibleSL) {
            return this.selectedItem != null;
        } 
    }
    
    /**
     * Update field value according field type
     */
    updateValue(newValue: any):void {
        if(this.visibleOP) {
            this.textValue = newValue;
        } else if(this.visibleSL) {
            this.selectedItem = newValue;
        } else if(this.visibleRB) {
            this.selectedItem = newValue;
        } else if(this.visibleCL) {
            this.selectedItems = newValue;
        }
    }
    
    /**
     * Get field value according field type
     */
    getValue(): any {
        if(this.visibleOP) {
            return this.textValue;
        } else if(this.visibleSL) {
            return this.selectedItem;
        } else if(this.visibleRB) {
            return this.selectedItem;
        } else if(this.visibleCL) {
            return this.selectedItems;
        }
        
    }
}