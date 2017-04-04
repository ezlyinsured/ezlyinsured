import { JsonMember, JsonObject } from 'typedjson-npm/src/typed-json';

/**
 * Object to represent emailPage of the product selector
 * @author ccasallas
 *
*/
@JsonObject
export class EmailPage {
    @JsonMember
    titleText: string;
    @JsonMember
    offerNotifyText: string;
}