/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents an answer option for a question.
 * 
 * @author jtorres
 *
 */

@Getter
@Setter
public class AnswerOption {

	private Long 	id;
	private String  content;
	private Boolean help;			
	private String  contentHelp;
}
