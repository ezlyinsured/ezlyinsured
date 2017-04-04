package co.com.fsighttech.imp.issuing.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a Question that belongs to the rail process.
 * 
 * @author jtorres
 *
 */
@Getter
@Setter
public class QuestionElm {
	
	private Long id;
	private String titleText;
	private String questionText;
	private Long onYes;
	private Long onNo;
	private Long onIdk;

//	public Question (String titleText, String questionText, Integer onYes, Integer onNo, Integer onIdk){
//		
//		this.titleText 		= titleText;
//		this.questionText	= questionText;
//		this.onYes			= onYes;
//		this.onNo			= onNo;
//		this.onIdk			= onIdk;
//	}
}
