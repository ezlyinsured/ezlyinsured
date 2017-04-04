/**
 * 
 */
package co.com.fsighttech.imp.integration.services.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @author YANKER
 *
 */
@Service
public class PolicyHeaderService implements /*IPolicyHeaderService,*/ Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2820744114507752121L;
	
	public Map<String, String> addPolicyHeader(Message<String> msg) {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("bindingkey", "QUOTE_BOP8011");
//		map.put("bindingkey", "QUOTE_BOP801Y");
//		Message<String> mes =  org.springframework.messaging.support.MessageBuilder.fromMessage(message).setHeader("deybeer", "007").setHeader("carlos", "008").build();
		// TODO Auto-generated method stub
//		System.out.println("entro con payload" + mes.toString());
		return map;
	}
}
