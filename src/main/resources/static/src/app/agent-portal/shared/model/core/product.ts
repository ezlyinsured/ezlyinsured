import { JsonMember, JsonObject } from 'typedjson-npm/src/typed-json';

/**
* this object represents a business line
*
* @author jtorres
*/
@JsonObject
export class Product {
    
    @JsonMember
    id: string;
}