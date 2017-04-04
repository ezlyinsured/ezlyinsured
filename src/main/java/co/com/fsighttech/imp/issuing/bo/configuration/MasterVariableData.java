/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo.configuration;

import lombok.Getter;
import lombok.Setter;

/**
 * this class represents a master variable data 
 * 
 * @author jtorres
 *
 */
@Getter
@Setter
public class MasterVariableData {
	private Long   id;
	private Integer sequence;
	private String code;
	private String description;
	private String abbreviation;
	private Long parentCode;
	private InputProperties inputProperties;
	
}
