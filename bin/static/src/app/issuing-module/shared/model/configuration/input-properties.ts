import { JsonMember, JsonObject } from 'typedjson-npm/src/typed-json';

import { VariableDataOption } from '../configuration/variable-data-option';

/**
* this object represents a input properties for variable data
*
* @author jtorres
*/
@JsonObject
export class InputProperties {

    @JsonMember
    label: string;
    @JsonMember
    typeVariable: string;
    @JsonMember
    multiple: boolean;
    @JsonMember({elements: VariableDataOption})
    optionList: VariableDataOption[];
}