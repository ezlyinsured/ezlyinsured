import { InputProperties } from '../configuration/input-properties';

/**
* this object represents a master coverage data for a specific product
*
* @author jtorres
*/
export class MasterCoverage {
    id: number;
    code: string;
    name: string;
    typeCoverage: string;
    category: string;
    active : boolean;
}