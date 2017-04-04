import { Company } from './company';
import { Product } from './product';
import { Premium } from './premium';
import { Insured } from './insured';
import { Agent } from './agent';
import { Commission } from './commission';
import { Office } from './office';
import { AdditionalInterest } from './additional-Interest';
import { Risk } from './risk';
import { VariableData } from './variable-data';
import { CoverageGroup } from './coverage-group';

/**
* this object represents a policy
*
* @author jtorres
*/
export class Policy {

    company: Company;
    product: Product;
    policyNumber: string;
    issueDate: Date;
    effectiveDate: Date;
    expiredDate: Date;
    processDate: Date;
    currencyCode: number;
    premium: Premium;
    insured: Insured;
    agent: Agent;
    commision: Commission;
    office: Office;
    collectorCode: number;
    collectorType: string;
    additionalInterest: AdditionalInterest;
    coveragesGroups: CoverageGroup[];
    risks: Risk[];
    variableDataList: VariableData[];
    fixedDataList: VariableData[];

}