import { MasterVariableData,  } from '../configuration/master-variable-data';
import { VariableDataOption } from '../configuration/variable-data-option';

const TPL_OP: string = "OP";
const TPL_RB: string = "RB";
const TPL_CL: string = "CL";
const TPL_SL: string = "SL";

/**
* this object represents a master variable data
*
* @author jtorres
*/
export class VariableData {
    id: number;
    value: string;
    code: string;
    masterVariableData: MasterVariableData;
    
    get visibleOP(): boolean {
        return this.masterVariableData.inputProperties.typeVariable == TPL_OP;
    }
    
    get visibleRB(): boolean {
        return this.masterVariableData.inputProperties.typeVariable == TPL_RB;
    }
    
    get visibleCL(): boolean {
        return this.masterVariableData.inputProperties.typeVariable == TPL_CL;
    }
    
    get visibleSL(): boolean {
        return this.masterVariableData.inputProperties.typeVariable == TPL_SL;
    }
    
    get label(): string {
        return this.masterVariableData.inputProperties.label;
    }
    
    get optionList(): VariableDataOption[] {
        return this.masterVariableData.inputProperties.optionList;
    }

    /**
     * Get variable data text description according to master
     * variable data type (OP, SL)
     */
    getText(): string {
        var vdText: string = null;
        
        if(this.masterVariableData.inputProperties.typeVariable == "OP") {
            vdText = this.value;
        } else {
            var optionList: VariableDataOption[] =this.masterVariableData.inputProperties.optionList;
        
            for(var i =0; i < optionList.length; i++) {
                if(optionList[i].code == this.value) {
                    return optionList[i].description;
                }
            }
        }
        return vdText;
    }
}