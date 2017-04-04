import { JsonMember, JsonObject } from 'typedjson-npm/src/typed-json';
/**
 * Object to represent positiveEndPage of the product selector
 * @author ccasallas
 *
*/
@JsonObject
export class PositiveEndPage {
    @JsonMember
    titleText: string;
    @JsonMember
    letsGoButtonText: string;
    @JsonMember
    productLink: string;
    @JsonMember
    noThanksText: string;
}