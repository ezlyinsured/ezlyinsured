import { JsonMember, JsonObject } from 'typedjson-npm/src/typed-json';
import {SelectItem} from 'primeng/primeng';

import { InputProperties } from './input-properties';
import { VariableDataOption } from './variable-data-option';
import { Field } from '../../../../shared/dyna-field/field';



/**
* this object represents a master variable data for policy
*
* @author ccasallas
*/
@JsonObject
export class MasterVariableData extends Field {
    @JsonMember
    id: number;
    @JsonMember
    sequence: number;
    @JsonMember
    code: string;
    @JsonMember
    description: string;
    @JsonMember
    abbreviation: string;
    @JsonMember
    parentCode: number;
    @JsonMember
    inputProperties : InputProperties;

    getFieldType(): string {
        return this.inputProperties.typeVariable;
    }
    
    initPlaceholder(): void {
        this.placeholder = this.inputProperties.label;
    }
    
    initSelectItems(): void {
        this.selectItems = [];
        //additional options
        this.inputProperties.optionList.forEach((option: VariableDataOption ) => {
           this.selectItems.push({label:  option.description, value : option});
        });
        
    }
}