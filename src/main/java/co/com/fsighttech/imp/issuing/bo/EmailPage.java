/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents the information required to send information about some product to
 * the user
 * 
 * @author jtorres
 *
 */
@Getter
@Setter
public class EmailPage {

	private String titleText;
	private String offerNotifyText;

//	public EmailPage (String titleText, String offerNotifyText){
//		
//		this.titleText		= 	titleText;
//		this.offerNotifyText=	offerNotifyText;
//		
//	}
}
