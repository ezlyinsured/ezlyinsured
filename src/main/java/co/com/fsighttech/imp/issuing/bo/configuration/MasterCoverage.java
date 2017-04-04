/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo.configuration;

import lombok.Getter;
import lombok.Setter;

/**
 * This class represents the master of coverage in the application
 * 
 * @author jtorres
 */
@Getter
@Setter
public class MasterCoverage {

	private Long id;
	private String code;
	private String name;
	private String typeCoverage;
	private String category;
	private Boolean active;
	
	
}
