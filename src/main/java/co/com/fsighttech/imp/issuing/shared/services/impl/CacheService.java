/**
 * 
 */
package co.com.fsighttech.imp.issuing.shared.services.impl;

import java.util.HashMap;
import java.util.List;

import co.com.fsighttech.imp.issuing.bo.core.CacheQuote;
import co.com.fsighttech.imp.issuing.bo.core.Policy;

/**
 * @author jtorres
 *
 */
public class CacheService {

	
private static HashMap<CacheQuote,List<Policy>> quoteCache;

public static HashMap<CacheQuote,List<Policy>> getQuoteCache(){
		
		if (quoteCache!= null && !quoteCache.isEmpty()){
			return quoteCache;
		}else{
			quoteCache  = new HashMap<CacheQuote,List<Policy>>();
			return quoteCache;
		}
	}
	
}
