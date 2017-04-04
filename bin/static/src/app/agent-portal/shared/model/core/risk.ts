import { VariableData } from './variable-data';
import { Coverage } from './coverage';
/**
* this object represents a risk of policy
*
* @author jtorres
*/
export class Risk {

    id: number;
    riskNumber: number;
    name: string;
    effectiveDate: Date;
    expirationDate: Date;
    group: number;
    variableDataRisk: VariableData[];
    coverages: Coverage[];
    childrenRisks: Risk[];
}