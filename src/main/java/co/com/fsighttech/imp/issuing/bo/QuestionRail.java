/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a group of questions that will be shown to the user
 * 
 * @author jtorres
 *
 */
@Getter
@Setter
public class QuestionRail {

	private String yesText;
	private String noText;
	private String idkText;
	private List<QuestionElm> questions;

//	public QuestionRail(String yesText, String noText, String idkText) {
//		
//		this.yesText = yesText;
//		this.noText	 = noText;
//		this.idkText = idkText;
//	}
}
