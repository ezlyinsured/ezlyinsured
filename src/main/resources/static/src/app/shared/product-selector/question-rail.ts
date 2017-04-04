import { JsonMember, JsonObject } from 'typedjson-npm/src/typed-json';
import { Question } from './question';

/**
 * Object to represent questionRail of the product selector
 * @author ccasallas
 *
*/
@JsonObject
export class QuestionRail {
    @JsonMember
    yesText: string;
    @JsonMember
    noText: string;
    @JsonMember
    idkText: string;
    @JsonMember({elements:Question})
    questions : Question[];
}