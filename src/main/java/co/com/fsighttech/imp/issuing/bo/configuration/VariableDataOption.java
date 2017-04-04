/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo.configuration;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents an  option for a variable data.
 * 
 * @author jtorres
 *
 */

@Getter
@Setter
public class VariableDataOption {
	
	private Long 	id;
	private String 	code;
	private String  description;
}