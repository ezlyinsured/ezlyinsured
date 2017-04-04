/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo.core;

import java.util.List;

import co.com.fsighttech.imp.issuing.bo.configuration.MasterCoverage;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jtorres
 *
 */
@Getter
@Setter
public class Coverage {


	private Long id; 
	private MasterCoverage masterCoverage;
	private String concept; // A code that represents the coverage concept
	private String limit; // Coverage's Limit
	private Deductible deductible; // Coverage's Deductible
	private Double totalPremium; // Coverage's total premium
	private List<VariableData> additionalFields;
	private String state;
	private Boolean contracted =false;
	private Boolean required = false;
}
