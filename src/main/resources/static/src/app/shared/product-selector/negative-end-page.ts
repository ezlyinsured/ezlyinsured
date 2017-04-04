import { JsonMember, JsonObject } from 'typedjson-npm/src/typed-json';
/**
 * Object to represent negativeEndPage of the product selector
 * @author ccasallas
 *
*/
@JsonObject
export class NegativeEndPage {
    @JsonMember
    titleText: string;
    @JsonMember
    goAnywayText: string;
    @JsonMember
    whyNotButtonText: string;
    @JsonMember
    productLink: string;
    @JsonMember
    noThanksText: string;
}