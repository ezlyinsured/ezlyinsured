/**
 * 
 */
package co.com.fsighttech.imp.issuing.shared.services.api;

import co.com.fsighttech.imp.issuing.bo.ProductSelector;

/**
 * Service Interface that will provide services to the selector product wizard
 * 
 * @author jtorres
 *
 */
public interface IProductSelectorService {

	public ProductSelector getProductSelector(String idProduct);
}
