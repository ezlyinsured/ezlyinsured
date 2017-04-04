import { JsonMember, JsonObject } from 'typedjson-npm/src/typed-json';

import { ISelectable } from '../../../../shared/dyna-field/selectable';

/**
* this object represents a variable data option 
*
* @author jtorres
*/
@JsonObject
export class VariableDataOption implements ISelectable {
    @JsonMember
    id: number;
    @JsonMember
    code: string;
    @JsonMember
    description: string;
}