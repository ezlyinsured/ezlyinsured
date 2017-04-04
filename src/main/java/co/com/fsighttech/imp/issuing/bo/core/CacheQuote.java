/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * this class represent a cache to quote a policy
 * @author jtorres
 *
 */

@Getter
@Setter
@EqualsAndHashCode(of={"zipCode","numberEmployeeId","industryId"/*,"coveragesSelected"*/})
public class CacheQuote {

	private String zipCode;
	private String numberEmployeeId;
	private String industryId;
//	private String coveragesSelected;
	
	
}
