/**
 * 
 */
package co.com.fsighttech.imp.issuing.shared.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.fsighttech.imp.issuing.bo.configuration.ProductCoverage;
import co.com.fsighttech.imp.issuing.bo.configuration.ProductVariableData;
import co.com.fsighttech.imp.issuing.shared.services.api.IProductConfigurationService;

/**
 * This class expose services associated to the product configuration
 * 
 * @author jtorres
 *
 */
@RestController
public class ProductConfigurationCtrl {

	@Autowired
	private IProductConfigurationService productConfigurationService;
	
	/**
	 * expose a web service to get the variable data at product level associated to the product
	 * quote.
	 * 
	 * @param idProduct  business line
	 * 
	 * @return List<VariableData>, variable data list
	 */
	@RequestMapping(value = "/product/{productId}/variable-data", method = RequestMethod.GET)
	public ProductVariableData getProductVariableData(@PathVariable String productId) {
		return this.productConfigurationService.getProductVariableData(productId);
	}
	
	/**
	 * expose a web service to get groups of the coverage structure
	 * quote.
	 * 
	 * @param idProduct  business line
	 * 
	 * @return ProductCoverage, product structure of coverages by group
	 */
	@RequestMapping(value = "/product/{productId}/coverage-policy-level", method = RequestMethod.GET)
	public ProductCoverage getCoveragePolicyLevel(@PathVariable String productId) {

		//retrieving the list of variable data
		ProductCoverage productCoverage =  productConfigurationService.getCoveragesPolicyLevel(productId);
		
		return productCoverage;
	}
	
	
	
	/**
	 * expose a web service to get groups of the coverage structure
	 * quote.
	 * 
	 * @param idProduct  business line
	 * 
	 * @return ProductCoverage, product structure of coverages by group
	 */
	@RequestMapping(value = "/product/{productId}/coverage-risk-level", method = RequestMethod.GET)
	public ProductCoverage getCoverageRiskLevel(@PathVariable String productId) {

		//retrieving the list of variable data
		ProductCoverage productCoverage =  productConfigurationService.getCoveragesRiskLevel(productId);
		
		return productCoverage;
	}
	
}
