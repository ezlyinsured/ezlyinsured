import { JsonMember, JsonObject } from 'typedjson-npm/src/typed-json';
/**
 * Object to represent startPage of the product selector
 * @author ccasallas
 *
*/
@JsonObject
export class StartPage {
    @JsonMember
    titleText: string;
    @JsonMember
    startButtonText: string;
    @JsonMember
    productLink: string;
    @JsonMember
    notShureText: string;
}