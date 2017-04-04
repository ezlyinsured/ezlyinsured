/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo.core;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * This class represents the policy summary used for quote process
 * 
 * @author jtorres
 *
 */

@Getter
@Setter
public class PolicySummary {

	private Policy policy;
	private List<CoverageSummary> coveragesSummary;
	private Double totalPercentage;
	
	
	public Double getTotalPercentage(){
		
		this.totalPercentage = new Double(0);
		for (CoverageSummary coverageGroupSumm: this.coveragesSummary){
			this.totalPercentage =  this.totalPercentage + coverageGroupSumm.getPercentageContracted();
		}
		
		return this.totalPercentage;
	}
}
