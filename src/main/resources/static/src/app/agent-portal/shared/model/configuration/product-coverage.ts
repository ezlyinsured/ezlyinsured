import { Company } from '../core/company';
import { Product } from '../core/product';
import { CoverageGroup } from '../core/coverage-group';

/**
* this object represents the structure of coverage for a specific product
*
* @author jtorres
*/
export class ProductCoverage {
    product: Product;
    coveragesGroupList:CoverageGroup[];
}