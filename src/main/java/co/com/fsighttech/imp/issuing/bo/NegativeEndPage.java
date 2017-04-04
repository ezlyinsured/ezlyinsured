/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents the Page when user has identified that product is not the correct
 * one.
 * 
 * @author jtorres
 *
 */
@Getter
@Setter
public class NegativeEndPage {

	private String titleText;
	private String goAnywayText;
	private String whyNotButtonText;
	private String productLink;
	private String noThanksText;

//	public NegativeEndPage(String titleText, String goAnywayText, String whyNotButtonText, String productLink,
//			String noThanksText) {
//
//		this.titleText 			=  titleText;
//		this.goAnywayText		=  goAnywayText;
//		this.whyNotButtonText	=  whyNotButtonText;
//		this.productLink		=  productLink;
//		this.noThanksText		=  noThanksText;
//	}
}
