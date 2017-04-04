import { JsonMember, JsonObject } from 'typedjson-npm/src/typed-json';
/**
 * Object to represent questions of the rail question
 * @author ccasallas
 *
*/
@JsonObject
export class Question {
    @JsonMember
    id: number;
    @JsonMember
    titleText: string;
    @JsonMember    
    questionText: string;
    @JsonMember    
    onYes: number;
    @JsonMember
    onNo: number;
    @JsonMember
    onIdk: number;
}