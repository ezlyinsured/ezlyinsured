/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo.configuration;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * This class represents an input properties for a variable data
 * 
 * @author jtorres
 *
 */
@Getter
@Setter
public class InputProperties {

	private String label;
	private String typeVariable;//(radio button (RB), checkbox list (CL), open (OP) and selection list (SL))
	private boolean multiple;
	private List<VariableDataOption> optionList;
}
