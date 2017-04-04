/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents the page to confirm that product is the correct one for user.
 * 
 * @author jtorres
 *
 */
@Getter
@Setter
public class PositiveEndPage {

	private String titleText;
	private String letsGoButtonText;
	private String productLink;
	private String noThanksText;

//	public PositiveEndPage(String titleText, String letsGoButtonText, String productLink, String noThanksText) {
//
//		this.titleText 			= titleText;
//		this.letsGoButtonText 	= letsGoButtonText;
//		this.productLink		= productLink;
//		this.noThanksText		= noThanksText;
//	}
}
