/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo.configuration;

import java.util.List;

import co.com.fsighttech.imp.issuing.bo.core.Product;
import lombok.Getter;
import lombok.Setter;

/**
 * this class represents the variables data for the product 
 * 
 * @author jtorres
 *
 */
@Getter
@Setter
public class ProductVariableData {
	
	private Long id;
	private Product product;
	private List<MasterVariableData> masterVariableDataList;
	

}
