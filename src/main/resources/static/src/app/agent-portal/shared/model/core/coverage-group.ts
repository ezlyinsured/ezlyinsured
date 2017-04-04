import { Coverage } from './coverage';

/**
* this object represents a coverage group for a set of coverage
*
* @author jtorres
*/
export class CoverageGroup {
    id: number;
    code: number;
    name: string;
    parentCode : number;
    coveragesContracted : number;
    level: string;
    sequence: number;
    coverages: Coverage[];
    real: boolean;
}