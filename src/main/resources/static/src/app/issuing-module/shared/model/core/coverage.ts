import { VariableData } from './variable-data';
import { MasterCoverage } from '../configuration/master-coverage';
/**
* this object represents a policy coverage
*
* @author jtorres
*/
export class Coverage {

    id: number;
    masterCoverage: MasterCoverage;
    concept: string; // A code that represents the coverage concept
    limit: string; // Coverage's Limit
    totalPremium: number; // Coverage's total premium
    additionalFields: VariableData[];
    auditFlag: string;
    state: string;
    contracted: boolean;
    required:boolean;
}