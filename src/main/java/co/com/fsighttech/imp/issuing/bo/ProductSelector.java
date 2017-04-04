/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents the structure that will compose the product selector wizard for
 * user
 * 
 * @author jtorres
 *
 */
@Getter
@Setter
public class ProductSelector {

	private StartPage 		startPage;
	private QuestionRail 	questionRail;
	private NegativeEndPage negativeEndPage;
	private PositiveEndPage	positiveEndPage;
	private EmailPage		emailPage;
	
}
