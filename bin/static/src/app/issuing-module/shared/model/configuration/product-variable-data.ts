import { JsonMember, JsonObject } from 'typedjson-npm/src/typed-json';

import { MasterVariableData } from '../configuration/master-variable-data';
import { InputProperties } from '../configuration/input-properties';
import { Product } from '../core/product';

/**
* this object represents a product variable data
*
* @author ccasallas
*/
@JsonObject
export class ProductVariableData {
    @JsonMember
    id: number;
    @JsonMember
    product: Product;
    @JsonMember({elements: MasterVariableData})
    masterVariableDataList: MasterVariableData[];
}