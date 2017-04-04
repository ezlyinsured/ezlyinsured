/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo.configuration;

import java.util.List;

import co.com.fsighttech.imp.issuing.bo.core.CoverageGroup;
import co.com.fsighttech.imp.issuing.bo.core.Product;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents the coverages associate to the product 
 * 
 * @author jtorres
 */
@Getter
@Setter
public class ProductCoverage {

	private Product product;
	private List<CoverageGroup> coveragesGroupList;
	
	
	
}
