/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo.core;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * this object represents a policy
 * 
 * @author jtorres
 *
 */
@Getter
@Setter
public class Policy {

	private Company company;
	private Product product;
	private String policyNumber;
	private LocalDate issueDate;
	private LocalDate effectiveDate;
	private LocalDate expiredDate;
	private LocalDate processDate;
	private Long currencyCode;
	private Premium	premium;
	private Insured	insured;
	private Agent	agent;
	private Commision commision;
	private Office	office;
	private Long collectorCode;
	private String collectorType;
	private AdditionaInterest additionalInterest;
	private List<Risk> risks;
	private List<CoverageGroup> coveragesGroups;
	private List<VariableData> variableDataList;
	private List<VariableData> fixedDataList;
	
}
