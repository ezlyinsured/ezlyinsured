/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a Question that belongs to the questionary.
 * 
 * @author jtorres
 *
 */

@Getter
@Setter
public class Question {
	
	private Long   				id;
	private String  			titleText;
	private String				questionText;
	private String  			template;
	private String  			questionType;
	private String  			target;
	private Boolean 			help;			
	private String  			contentHelp;
	private List<AnswerOption>  answerOptions;
	
}
