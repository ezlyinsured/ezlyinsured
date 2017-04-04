/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents the initial page to start the product selector.
 * 
 * @author jtorres
 *
 */
@Getter
@Setter
public class StartPage {

	private String titleText;
	private String startButtonText;
	private String productLink;
	private String notShureText;

//	public StartPage(String titleText, String startButtonText, String productLink, String notShureText) {
//
//		this.titleText 	     = titleText;
//		this.startButtonText = startButtonText;
//		this.productLink     = productLink;
//		this.notShureText	 = notShureText;
//	}

}
