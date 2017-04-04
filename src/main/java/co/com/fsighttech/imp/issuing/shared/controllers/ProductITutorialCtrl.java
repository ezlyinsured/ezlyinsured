package co.com.fsighttech.imp.issuing.shared.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.fsighttech.imp.issuing.bo.ProductSelector;
import co.com.fsighttech.imp.issuing.shared.services.api.IProductSelectorService;

/**
 * Controller to provide the configuration structure to offer a tutorial process
 * to the user in order to identify the right product to quote.
 * 
 * @author jtorres
 *
 */
@RestController
public class ProductITutorialCtrl {

	@Autowired
	private IProductSelectorService productSelectorService;

	/**
	 * expose a ws to get the configuration structure to identify the product to
	 * quote.
	 * 
	 * @return List<User>, user list
	 */
	@RequestMapping(value = "/product-selector/{productId}", method = RequestMethod.GET)
	public ProductSelector getProductSelector(@PathVariable String productId) {

		//retrieving the product selector given the id product
		ProductSelector productSelector =  productSelectorService.getProductSelector(productId);
		
		return productSelector;
	}

	
}
