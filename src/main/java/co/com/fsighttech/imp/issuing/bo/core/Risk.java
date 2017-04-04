/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * this object represents a risk
 * 
 * @author jtorres
 *
 */

@Getter
@Setter
public class Risk {

	private Long id;
	private Long riskNumber;
	private String name;
	private LocalDate effectiveDate;
	private LocalDate expirationDate;
	private Long group; // group a risk inside a risk category if needed.
	private List<VariableData> variableDataRisk;
	private List<Coverage> coverages = new ArrayList<>();
	private List<Risk> childrenRisks;

}
