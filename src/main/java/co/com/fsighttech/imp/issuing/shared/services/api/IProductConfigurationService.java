package co.com.fsighttech.imp.issuing.shared.services.api;

import java.util.List;

import co.com.fsighttech.imp.issuing.bo.configuration.MasterCoverage;
import co.com.fsighttech.imp.issuing.bo.configuration.ProductCoverage;
import co.com.fsighttech.imp.issuing.bo.configuration.ProductVariableData;

/**
 * Service Interface that will provide configuration services for a product
 * 
 * @author jtorres
 *
 */
public interface IProductConfigurationService {

	/**
	 * Return the set of variable data at product level
	 * @param productId  business lines
	 * @return List <VariableData>
	 */
	public ProductVariableData getProductVariableData(String productId);
	
	/**
	 * Return the set of variable data at risk level
	 * 
	 * @param idProduct business lines
	 * @param riskNumber risk number of the policy
	 * 
	 * @return List <VariableData>, set of variable data at risk level for a product
	*/
	public List<MasterCoverage> getRiskVariableData (String idProduct, Long riskNumber);
	
	
	/**
	 * Return the set of variable data at coverage level
	 * 
	 * @param idProduct business lines
	 * @param riskNumber risk number of the policy
	 * @param codeCoverage coverage code of the risk 
	 * 
	 * @return List <VariableData>, set of variable data at coverage level for a product
	*/
	public List<MasterCoverage> getCoverageVariableData (String idProduct, Long riskNumber, Long codeCoverage);
	
//	/**
//	 * Return the group of master coverage for a product 
//	 * 
//	 * @param idProduct business lines
//	 * 
//	 * @return ProductCoverage, set of master coverage by group
//	*/
//	public ProductCoverage getCoveragesStructure (String idProduct);
	
	/**
	 * Return the group of master coverage for a product at policy level
	 * 
	 * @param idProduct
	 *            business lines
	 * 
	 * @return ProductCoverage, set of master coverage by group
	 */
	public ProductCoverage getCoveragesPolicyLevel(String idProduct);
	
	
	/**
	 * Return the group of master coverage for a product at risk level
	 * 
	 * @param idProduct
	 *            business lines
	 * 
	 * @return ProductCoverage, set of master coverage by group at risk level
	 */
	public ProductCoverage getCoveragesRiskLevel(String idProduct);
	
	
	/**
	 * Return the group of master coverage for a product at policy level by insurance company
	 * 
	 * @param idProduct
	 *            business lines
	 * 
	 * @return ProductCoverage, set of master coverage by group
	 */
	public ProductCoverage getCoveragesPolicyLevelByInsComp(Long idInsuranceComp);
	
	
	/**
	 * Return the group of master coverage for a product at risk level by
	 * company
	 * 
	 * @param idProduct
	 *            business lines
	 * 
	 * @return ProductCoverage, set of master coverage by group at risk level
	 */
	public ProductCoverage getCoveragesRiskLevelByInsComp(Long idInsuranceComp);
	
	
}
