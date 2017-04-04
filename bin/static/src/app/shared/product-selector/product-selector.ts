import { JsonMember, JsonObject } from 'typedjson-npm/src/typed-json';

import { StartPage } from './start-page';
import { NegativeEndPage } from './negative-end-page';
import { PositiveEndPage } from './positive-end-page';
import { EmailPage } from './email-page';
import { QuestionRail } from './question-rail';

/**
 * Object to represent product selector
 * @author ccasallas
 *
*/
@JsonObject
export class ProductSelector {
    
    @JsonMember
    startPage: StartPage;
    @JsonMember
    questionRail: QuestionRail;
    @JsonMember
    positiveEndPage: PositiveEndPage;
    @JsonMember
    negativeEndPage: NegativeEndPage;
    @JsonMember
    emailPage: EmailPage;
    @JsonMember({emitDefaultValue: true})
    prueba:string = "prueba";

    test(){
        alert("prueba");
    }
}