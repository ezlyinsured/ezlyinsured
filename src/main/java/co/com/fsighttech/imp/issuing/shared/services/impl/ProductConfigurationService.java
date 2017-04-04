package co.com.fsighttech.imp.issuing.shared.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.com.fsighttech.imp.issuing.bo.configuration.InputProperties;
import co.com.fsighttech.imp.issuing.bo.configuration.MasterCoverage;
import co.com.fsighttech.imp.issuing.bo.configuration.MasterVariableData;
import co.com.fsighttech.imp.issuing.bo.configuration.ProductCoverage;
import co.com.fsighttech.imp.issuing.bo.configuration.ProductVariableData;
import co.com.fsighttech.imp.issuing.bo.configuration.VariableDataOption;
import co.com.fsighttech.imp.issuing.bo.core.Coverage;
import co.com.fsighttech.imp.issuing.bo.core.CoverageGroup;
import co.com.fsighttech.imp.issuing.bo.core.Product;
import co.com.fsighttech.imp.issuing.shared.services.api.IProductConfigurationService;

/**
 * Service implementation that will provide services for product configuration
 * 
 * @author jtorres
 *
 */

@Service
public class ProductConfigurationService implements IProductConfigurationService {

	public ProductVariableData getProductVariableData(String productId) {

		Product product = new Product();
		product.setId("1");
		product.setCode(1L);
		product.setName("BOP");

		List<MasterVariableData> masterVariableDataList = new ArrayList<>();

		MasterVariableData masterVariableData = new MasterVariableData();
		masterVariableData.setId(1L);
		masterVariableData.setCode("ZIP_CODE");
		masterVariableData.setDescription("Zip Code");
		masterVariableData.setInputProperties(new InputProperties());
		masterVariableData.getInputProperties().setLabel("Your business ZIP CODE");
		masterVariableData.getInputProperties().setMultiple(false);
		masterVariableData.getInputProperties().setTypeVariable("OP");
		masterVariableData.getInputProperties().setOptionList(null);
		masterVariableDataList.add(masterVariableData);

		masterVariableData = new MasterVariableData();
		masterVariableData.setId(2L);
		masterVariableData.setCode("INDUSTRY_ID");
		masterVariableData.setDescription("Industry");
		masterVariableData.setInputProperties(new InputProperties());
		masterVariableData.getInputProperties().setLabel("What is your industry?");
		masterVariableData.getInputProperties().setMultiple(false);
		masterVariableData.getInputProperties().setTypeVariable("SL");
		masterVariableData.getInputProperties().setOptionList(generateDummyIndustries());
		masterVariableDataList.add(masterVariableData);

		masterVariableData = new MasterVariableData();
		masterVariableData.setId(2L);
		masterVariableData.setCode("NUM_EMMPLOYEES");
		masterVariableData.setDescription("Number of Employees");
		masterVariableData.setInputProperties(new InputProperties());
		masterVariableData.getInputProperties().setLabel("How many employees do you have?");
		masterVariableData.getInputProperties().setMultiple(false);
		masterVariableData.getInputProperties().setTypeVariable("SL");
		masterVariableData.getInputProperties().setOptionList(generateDummyNumEmployees());
		masterVariableDataList.add(masterVariableData);

		ProductVariableData productVariableData = new ProductVariableData();
		productVariableData.setId(1L);
		productVariableData.setProduct(product);
		productVariableData.setMasterVariableDataList(masterVariableDataList);

		return productVariableData;
	}

	private List<VariableDataOption> generateDummyIndustries() {
		List<VariableDataOption> variableDataOptions = new ArrayList<>();

		VariableDataOption variableDataOption = new VariableDataOption();
		variableDataOption.setId(1L);
		variableDataOption.setCode("IND_001");
		variableDataOption.setDescription("Air Transport");
		variableDataOptions.add(variableDataOption);

		variableDataOption = new VariableDataOption();
		variableDataOption.setId(2L);
		variableDataOption.setCode("IND_002");
		variableDataOption.setDescription("Banks, Savings & Loans");
		variableDataOptions.add(variableDataOption);

		variableDataOption = new VariableDataOption();
		variableDataOption.setId(3L);
		variableDataOption.setCode("IND_003");
		variableDataOption.setDescription("Health");
		variableDataOptions.add(variableDataOption);
		
		variableDataOption = new VariableDataOption();
		variableDataOption.setId(4L);
		variableDataOption.setCode("IND_004");
		variableDataOption.setDescription("Telecommunications");
		variableDataOptions.add(variableDataOption);

		return variableDataOptions;
	}

	private List<VariableDataOption> generateDummyNumEmployees() {
		List<VariableDataOption> variableDataOptions = new ArrayList<>();

		VariableDataOption variableDataOption = new VariableDataOption();
		variableDataOption.setId(4L);
		variableDataOption.setCode("1_4");
		variableDataOption.setDescription("1 - 4");
		variableDataOptions.add(variableDataOption);

		variableDataOption = new VariableDataOption();
		variableDataOption.setId(5L);
		variableDataOption.setCode("5_10");
		variableDataOption.setDescription("5 - 10");
		variableDataOptions.add(variableDataOption);

		variableDataOption = new VariableDataOption();
		variableDataOption.setId(6L);
		variableDataOption.setCode("11_50");
		variableDataOption.setDescription("1 - 50");
		variableDataOptions.add(variableDataOption);

		return variableDataOptions;
	}

	/**
	 * Return the set of variable data at risk level
	 * 
	 * @param productId
	 *            business lines
	 * @param riskNumber
	 *            risk number of the policy
	 * 
	 * @return List <VariableData>, set of variable data at risk level for a
	 *         product
	 */
	@Override
	public List<MasterCoverage> getRiskVariableData(String productId, Long riskNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Return the set of variable data at coverage level
	 * 
	 * @param productId
	 *            business lines
	 * @param riskNumber
	 *            risk number of the policy
	 * @param codeCoverage
	 *            coverage code of the risk
	 * 
	 * @return List <VariableData>, set of variable data at coverage level for a
	 *         product
	 */
	@Override
	public List<MasterCoverage> getCoverageVariableData(String productId, Long riskNumber, Long codeCoverage) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Return the group of master coverage for a product at policy level
	 * 
	 * @param idProduct
	 *            business lines
	 * 
	 * @return ProductCoverage, set of master coverage by group
	 */
	public ProductCoverage getCoveragesPolicyLevel(String idProduct) {

		// TODO , simulating the creation of groups according to the product
		// TODO all this needs to have a backend functionality to be persisted
		// and configured in db

		// configuration product
		Product product = new Product();
		product.setName("BOP");
		product.setCode(801L);

		ProductCoverage productCoverage = new ProductCoverage();
		productCoverage.setProduct(product);
		productCoverage.setCoveragesGroupList(new ArrayList<CoverageGroup>());

		// 1. Group1 Policy coverage
		CoverageGroup group1 = new CoverageGroup();
		group1.setCode(1L);
		group1.setSequence(1);
		group1.setLevel("P");
		group1.setName("Policy Coverage");
		group1.setCoverages(new ArrayList<Coverage>());
		group1.setReal(true);

		// creating master coverages
		Coverage coverage = new Coverage();
		MasterCoverage masterCoverage = new MasterCoverage();
		masterCoverage.setCode("1001");
		masterCoverage.setName("Enhancer Endorsement");
		masterCoverage.setTypeCoverage("P");
		masterCoverage.setCategory("PolicyCov");
		coverage.setMasterCoverage(masterCoverage);

		Coverage coverage1 = new Coverage();
		MasterCoverage masterCoverage1 = new MasterCoverage();
		masterCoverage1.setCode("1002");
		masterCoverage1.setName("Liability");
		masterCoverage1.setTypeCoverage("P");
		masterCoverage1.setCategory("PolicyCov");
		coverage1.setMasterCoverage(masterCoverage1);
		coverage1.setContracted(true);
		coverage1.setRequired(true);

		Coverage coverage2 = new Coverage();
		MasterCoverage masterCoverage2 = new MasterCoverage();
		masterCoverage2.setCode("1003");
		masterCoverage2.setName("Terrorism Building");
		masterCoverage2.setTypeCoverage("P");
		masterCoverage2.setCategory("PolicyCov");
		coverage2.setMasterCoverage(masterCoverage2);

		Coverage coverage3 = new Coverage();
		MasterCoverage masterCoverage3 = new MasterCoverage();
		masterCoverage3.setCode("1004");
		masterCoverage3.setName("Terrorism Business Personal Building");
		masterCoverage3.setTypeCoverage("P");
		masterCoverage3.setCategory("PolicyCov");
		coverage3.setMasterCoverage(masterCoverage3);

		Coverage coverage4 = new Coverage();
		MasterCoverage masterCoverage4 = new MasterCoverage();
		masterCoverage4.setCode("1005");
		masterCoverage4.setName("Terrorism Liability");
		masterCoverage4.setTypeCoverage("P");
		masterCoverage4.setCategory("PolicyCov");
		coverage4.setMasterCoverage(masterCoverage4);
		coverage4.setContracted(true);
		coverage4.setRequired(true);

		group1.getCoverages().add(coverage);
		group1.getCoverages().add(coverage1);
		group1.getCoverages().add(coverage2);
		group1.getCoverages().add(coverage3);
		group1.getCoverages().add(coverage4);

		// 2. group 2 additional coverage
		CoverageGroup group2 = new CoverageGroup();
		group2.setCode(2L);
		group2.setSequence(3);
		group2.setName("Additional Coverages");
		group2.setLevel("P");
		group2.setCoverages(new ArrayList<Coverage>());
		group2.setReal(true);

		coverage = new Coverage();
		masterCoverage = new MasterCoverage();
		masterCoverage.setCode("2001");
		masterCoverage.setName("Equipment Breakdown");
		masterCoverage.setTypeCoverage("P");
		masterCoverage.setCategory("Additional");
		coverage.setMasterCoverage(masterCoverage);

		coverage1 = new Coverage();
		masterCoverage1 = new MasterCoverage();
		masterCoverage1.setCode("2002");
		masterCoverage1.setName("Data Compromise");
		masterCoverage1.setTypeCoverage("P");
		masterCoverage1.setCategory("Additional");
		coverage1.setMasterCoverage(masterCoverage1);

		coverage2 = new Coverage();
		masterCoverage2 = new MasterCoverage();
		masterCoverage2.setCode("2003");
		masterCoverage2.setName("Cyberone Liability");
		masterCoverage2.setTypeCoverage("P");
		masterCoverage2.setCategory("Additional");
		coverage2.setMasterCoverage(masterCoverage2);
		coverage2.setContracted(true);
		coverage2.setRequired(true);

		group2.getCoverages().add(coverage);
		group2.getCoverages().add(coverage1);
		group2.getCoverages().add(coverage2);

		// 1. Fictitious Group to refer risks coverage
		CoverageGroup group3 = new CoverageGroup();
		group3.setCode(3L);
		group3.setSequence(3);
		group3.setLevel("R");
		group3.setName("Loc / Build Coverages");
		group3.setCoverages(new ArrayList<Coverage>());
		group3.setReal(false);

		productCoverage.getCoveragesGroupList().add(group1);
		productCoverage.getCoveragesGroupList().add(group2);
		productCoverage.getCoveragesGroupList().add(group3);

		return productCoverage;
	}

	/**
	 * Return the group of master coverage for a product at risk level
	 * 
	 * @param idProduct
	 *            business lines
	 * 
	 * @return ProductCoverage, set of master coverage by group at risk level
	 */
	public ProductCoverage getCoveragesRiskLevel(String idProduct) {

		// TODO , simulating the creation of groups according to the product
		// TODO all this needs to have a backend functionality to be persisted
		// and configured in db

		// configuration product
		Product product = new Product();
		product.setName("BOP");
		product.setCode(801L);

		ProductCoverage productCoverage = new ProductCoverage();
		productCoverage.setProduct(product);
		productCoverage.setCoveragesGroupList(new ArrayList<CoverageGroup>());

		// group location coverage
		CoverageGroup locationGroup = new CoverageGroup();
		locationGroup.setSequence(1);
		locationGroup.setCode(1L);
		locationGroup.setName("Location");
		locationGroup.setLevel("R");
		locationGroup.setCoverages(new ArrayList<Coverage>());

		Coverage coverage = new Coverage();
		MasterCoverage masterCoverage = new MasterCoverage();
		masterCoverage.setId(1L);
		masterCoverage.setCode("L001");
		masterCoverage.setName("Liability Equipment Breakdown");
		masterCoverage.setTypeCoverage("R");
		masterCoverage.setCategory("Location");
		coverage.setId(1L);
		coverage.setMasterCoverage(masterCoverage);
		coverage.setContracted(true);
		coverage.setRequired(true);

		Coverage coverage1 = new Coverage();
		MasterCoverage masterCoverage1 = new MasterCoverage();
		masterCoverage1.setId(2L);
		masterCoverage1.setCode("L002");
		masterCoverage1.setName("Terrorism Coverage");
		masterCoverage1.setTypeCoverage("R");
		masterCoverage1.setCategory("Location");
		coverage1.setId(2L);
		coverage1.setMasterCoverage(masterCoverage1);

		locationGroup.getCoverages().add(coverage);
		locationGroup.getCoverages().add(coverage1);

		// creating group for building coverages
		CoverageGroup buildingGroup = new CoverageGroup();
		buildingGroup.setSequence(2);
		buildingGroup.setCode(2L);
		buildingGroup.setName("Building");
		buildingGroup.setLevel("R");
		buildingGroup.setCoverages(new ArrayList<Coverage>());

		Coverage coverageB1 = new Coverage();
		MasterCoverage masterCoverageB1 = new MasterCoverage();
		masterCoverageB1.setId(1L);
		masterCoverageB1.setCode("B001");
		masterCoverageB1.setName("Liability Structure Coverage");
		masterCoverageB1.setTypeCoverage("R");
		masterCoverageB1.setCategory("Building");
		coverageB1.setId(1L);
		coverageB1.setMasterCoverage(masterCoverageB1);
		coverageB1.setContracted(true);
		coverageB1.setRequired(true);

		Coverage coverageB2 = new Coverage();
		MasterCoverage masterCoverageB2 = new MasterCoverage();
		masterCoverageB2.setId(2L);
		masterCoverageB2.setCode("B002");
		masterCoverageB2.setName("Employees Coverage");
		masterCoverageB2.setTypeCoverage("R");
		masterCoverageB2.setCategory("Building");
		coverageB2.setId(2L);
		coverageB2.setMasterCoverage(masterCoverageB2);

		buildingGroup.getCoverages().add(coverageB1);
		buildingGroup.getCoverages().add(coverageB2);

		// associating the set of risk coverages at risk level to the product
		productCoverage.getCoveragesGroupList().add(locationGroup);
		productCoverage.getCoveragesGroupList().add(buildingGroup);

		return productCoverage;
	}

	/**
	 * Return the group of master coverage for a product at risk level by
	 * company
	 * 
	 * @param idProduct
	 *            business lines
	 * 
	 * @return ProductCoverage, set of master coverage by group at risk level
	 */
	public ProductCoverage getCoveragesRiskLevelByInsComp(Long idInsuranceComp) {

		// TODO , simulating the creation of groups according to the product
		// TODO all this needs to have a backend functionality to be persisted
		// and configured in db

		// configuration product
		Product product = new Product();
		product.setName("BOP");
		product.setCode(801L);

		ProductCoverage productCoverage = new ProductCoverage();
		productCoverage.setProduct(product);
		productCoverage.setCoveragesGroupList(new ArrayList<CoverageGroup>());

		if (idInsuranceComp == 1) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(55));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(80));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(true);
			coverageB1.setTotalPremium(new Double(100));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB1.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(true);
			coverageB2.setTotalPremium(new Double(88));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 2) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(77));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(62));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(true);
			coverageB1.setTotalPremium(new Double(92));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(true);
			coverageB2.setTotalPremium(new Double(88));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 3) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(107));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(102));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(true);
			coverageB1.setTotalPremium(new Double(32));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(true);
			coverageB2.setTotalPremium(new Double(98));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 4) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(127));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(122));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(true);
			coverageB1.setTotalPremium(new Double(92));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(true);
			coverageB2.setTotalPremium(new Double(48));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 5) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(99));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(false);
			coverage1.setTotalPremium(new Double(6000));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(false);
			coverageB1.setTotalPremium(new Double(6000));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(false);
			coverageB2.setTotalPremium(new Double(6000));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 6) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(57));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(162));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(true);
			coverageB1.setTotalPremium(new Double(142));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(true);
			coverageB2.setTotalPremium(new Double(68));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 7) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(97));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(109));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(true);
			coverageB1.setTotalPremium(new Double(32));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(false);
			coverageB2.setTotalPremium(new Double(6000));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 8) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(87));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(false);
			coverage1.setTotalPremium(new Double(6000));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(true);
			coverageB1.setTotalPremium(new Double(95));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(true);
			coverageB2.setTotalPremium(new Double(78));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 9) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(97));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(false);
			coverage1.setTotalPremium(new Double(6000));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(false);
			coverageB1.setTotalPremium(new Double(6000));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(false);
			coverageB2.setTotalPremium(new Double(6000));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 10) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(66));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(52));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(true);
			coverageB1.setTotalPremium(new Double(192));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(true);
			coverageB2.setTotalPremium(new Double(138));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 11) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(92));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(42));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(false);
			coverageB1.setTotalPremium(new Double(6000));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(true);
			coverageB2.setTotalPremium(new Double(98));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 12) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(false);
			coverage.setTotalPremium(new Double(6000));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(false);
			coverage1.setTotalPremium(new Double(6000));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(true);
			coverageB1.setTotalPremium(new Double(45));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(true);
			coverageB2.setTotalPremium(new Double(48));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 13) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(71));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(69));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(true);
			coverageB1.setTotalPremium(new Double(102));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(true);
			coverageB2.setTotalPremium(new Double(188));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 14) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(27));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(192));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(true);
			coverageB1.setTotalPremium(new Double(142));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(true);
			coverageB2.setTotalPremium(new Double(88));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 15) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(47));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(false);
			coverage1.setTotalPremium(new Double(6000));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(true);
			coverageB1.setTotalPremium(new Double(90));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(true);
			coverageB2.setTotalPremium(new Double(58));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 16) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(57));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(69));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(true);
			coverageB1.setTotalPremium(new Double(102));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(true);
			coverageB2.setTotalPremium(new Double(108));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 17) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(27));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(162));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(true);
			coverageB1.setTotalPremium(new Double(122));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(false);
			coverageB2.setTotalPremium(new Double(6000));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else if (idInsuranceComp == 18) {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(117));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(false);
			coverage1.setTotalPremium(new Double(6000));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(true);
			coverageB1.setTotalPremium(new Double(122));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(true);
			coverageB2.setTotalPremium(new Double(98));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		} else {
			// group location coverage
			CoverageGroup locationGroup = new CoverageGroup();
			locationGroup.setSequence(1);
			locationGroup.setCode(1L);
			locationGroup.setName("Location");
			locationGroup.setLevel("R");
			locationGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setId(1L);
			masterCoverage.setCode("L001");
			masterCoverage.setName("Liability Equipment Breakdown");
			masterCoverage.setTypeCoverage("R");
			masterCoverage.setCategory("Location");
			coverage.setId(1L);
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(67));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setId(2L);
			masterCoverage1.setCode("L002");
			masterCoverage1.setName("Terrorism Coverage");
			masterCoverage1.setTypeCoverage("R");
			masterCoverage1.setCategory("Location");
			coverage1.setId(2L);
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(92));

			locationGroup.getCoverages().add(coverage);
			locationGroup.getCoverages().add(coverage1);

			// creating group for building coverages
			CoverageGroup buildingGroup = new CoverageGroup();
			buildingGroup.setSequence(2);
			buildingGroup.setCode(2L);
			buildingGroup.setName("Building");
			buildingGroup.setLevel("R");
			buildingGroup.setCoverages(new ArrayList<Coverage>());

			Coverage coverageB1 = new Coverage();
			MasterCoverage masterCoverageB1 = new MasterCoverage();
			masterCoverageB1.setId(1L);
			masterCoverageB1.setCode("B001");
			masterCoverageB1.setName("Liability Structure Coverage");
			masterCoverageB1.setTypeCoverage("R");
			masterCoverageB1.setCategory("Building");
			coverageB1.setId(1L);
			coverageB1.setMasterCoverage(masterCoverageB1);
			coverageB1.setContracted(true);
			coverageB1.setTotalPremium(new Double(112));

			Coverage coverageB2 = new Coverage();
			MasterCoverage masterCoverageB2 = new MasterCoverage();
			masterCoverageB2.setId(2L);
			masterCoverageB2.setCode("B002");
			masterCoverageB2.setName("Employees Coverage");
			masterCoverageB2.setTypeCoverage("R");
			masterCoverageB2.setCategory("Building");
			coverageB2.setId(2L);
			coverageB2.setMasterCoverage(masterCoverageB2);
			coverageB2.setContracted(true);
			coverageB2.setTotalPremium(new Double(38));

			buildingGroup.getCoverages().add(coverageB1);
			buildingGroup.getCoverages().add(coverageB2);

			// associating the set of risk coverages at risk level to the
			// product
			productCoverage.getCoveragesGroupList().add(locationGroup);
			productCoverage.getCoveragesGroupList().add(buildingGroup);
		}

		return productCoverage;
	}

	/**
	 * Return the group of master coverage for a product at policy level by
	 * insurance company
	 * 
	 * @param idProduct
	 *            business lines
	 * 
	 * @return ProductCoverage, set of master coverage by group
	 */
	public ProductCoverage getCoveragesPolicyLevelByInsComp(Long idInsuranceComp) {

		// TODO , simulating the creation of groups according to the product
		// TODO all this needs to have a backend functionality to be persisted
		// and configured in db

		// configuration product
		Product product = new Product();
		product.setName("BOP");
		product.setCode(801L);

		ProductCoverage productCoverage = new ProductCoverage();
		productCoverage.setProduct(product);
		productCoverage.setCoveragesGroupList(new ArrayList<CoverageGroup>());

		if (idInsuranceComp == 1) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(30));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(20));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setTotalPremium(new Double(60));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(true);
			coverage3.setTotalPremium(new Double(80));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(55));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(120));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(130));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(90));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);

		} else if (idInsuranceComp == 2) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(29));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(45));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setTotalPremium(new Double(180));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(true);
			coverage3.setTotalPremium(new Double(200));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(87));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(90));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(100));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(130));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);

		} else if (idInsuranceComp == 3) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(90));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(70));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(false);
			coverage2.setTotalPremium(new Double(6000));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(false);
			coverage3.setTotalPremium(new Double(6000));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(false);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(6000));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(70));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(45));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(98));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		} else if (idInsuranceComp == 4) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(99));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(105));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setTotalPremium(new Double(300));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(true);
			coverage3.setTotalPremium(new Double(25));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(65));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(false);
			coverage.setTotalPremium(new Double(6000));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(80));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(150));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		} else if (idInsuranceComp == 5) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(82));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(80));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setTotalPremium(new Double(210));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(true);
			coverage3.setTotalPremium(new Double(205));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(110));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(97));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(70));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(89));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		} else if (idInsuranceComp == 6) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(106));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(70));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(false);
			coverage2.setTotalPremium(new Double(6000));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(false);
			coverage3.setTotalPremium(new Double(6000));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(350));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(250));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(130));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(60));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		} else if (idInsuranceComp == 7) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(70));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(90));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setTotalPremium(new Double(380));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(true);
			coverage3.setTotalPremium(new Double(290));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(90));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(80));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(67));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(290));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		} else if (idInsuranceComp == 8) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(105));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(250));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setTotalPremium(new Double(350));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(true);
			coverage3.setTotalPremium(new Double(380));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(30));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(200));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(88));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(90));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		} else if (idInsuranceComp == 9) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(20));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(20));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(false);
			coverage2.setTotalPremium(new Double(6000));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(false);
			coverage3.setTotalPremium(new Double(6000));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(78));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(180));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(false);
			coverage1.setTotalPremium(new Double(6000));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(80));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		} else if (idInsuranceComp == 10) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(65));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(105));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setTotalPremium(new Double(130));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(true);
			coverage3.setTotalPremium(new Double(390));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(200));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(90));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(130));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(78));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		} else if (idInsuranceComp == 11) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(105));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(105));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setTotalPremium(new Double(250));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(true);
			coverage3.setTotalPremium(new Double(190));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(230));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(100));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(90));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(90));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		} else if (idInsuranceComp == 12) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(100));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(130));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setTotalPremium(new Double(200));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(true);
			coverage3.setTotalPremium(new Double(88));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(99));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(97));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(70));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(100));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		} else if (idInsuranceComp == 13) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(80));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(100));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setTotalPremium(new Double(130));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(true);
			coverage3.setTotalPremium(new Double(300));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(200));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(190));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(50));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(230));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		} else if (idInsuranceComp == 14) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(100));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(90));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(false);
			coverage2.setTotalPremium(new Double(6000));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(true);
			coverage3.setTotalPremium(new Double(80));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(90));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(false);
			coverage.setTotalPremium(new Double(6000));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(300));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setTotalPremium(new Double(290));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		} else if (idInsuranceComp == 15) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(false);
			coverage.setTotalPremium(new Double(6000));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(70));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(false);
			coverage2.setTotalPremium(new Double(6000));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(true);
			coverage3.setTotalPremium(new Double(90));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(80));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(100));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(false);
			coverage1.setTotalPremium(new Double(6000));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(false);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(6000));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		} else if (idInsuranceComp == 16) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(false);
			coverage.setTotalPremium(new Double(102));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(130));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setTotalPremium(new Double(40));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(true);
			coverage3.setTotalPremium(new Double(30));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(70));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(180));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(230));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(130));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		} else if (idInsuranceComp == 17) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(false);
			coverage.setTotalPremium(new Double(6000));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(30));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setTotalPremium(new Double(120));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(true);
			coverage3.setTotalPremium(new Double(290));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(130));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(93));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(68));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(45));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		} else if (idInsuranceComp == 18) {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(false);
			coverage.setTotalPremium(new Double(6000));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(80));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(false);
			coverage2.setTotalPremium(new Double(6000));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(false);
			coverage3.setTotalPremium(new Double(6000));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(60));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(false);
			coverage.setTotalPremium(new Double(6000));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(false);
			coverage1.setTotalPremium(new Double(6000));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(90));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		} else {
			// 1. Group1 Policy coverage
			CoverageGroup group1 = new CoverageGroup();
			group1.setCode(1L);
			group1.setSequence(1);
			group1.setLevel("P");
			group1.setName("Policy Coverage");
			group1.setCoverages(new ArrayList<Coverage>());

			// creating master coverages
			Coverage coverage = new Coverage();
			MasterCoverage masterCoverage = new MasterCoverage();
			masterCoverage.setCode("1001");
			masterCoverage.setName("Enhancer Endorsement");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("PolicyCov");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(130));

			Coverage coverage1 = new Coverage();
			MasterCoverage masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("1002");
			masterCoverage1.setName("Liability");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("PolicyCov");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setRequired(true);
			coverage1.setTotalPremium(new Double(60));

			Coverage coverage2 = new Coverage();
			MasterCoverage masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("1003");
			masterCoverage2.setName("Terrorism Building");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("PolicyCov");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(false);
			coverage2.setTotalPremium(new Double(80));

			Coverage coverage3 = new Coverage();
			MasterCoverage masterCoverage3 = new MasterCoverage();
			masterCoverage3.setCode("1004");
			masterCoverage3.setName("Terrorism Business Personal Building");
			masterCoverage3.setTypeCoverage("P");
			masterCoverage3.setCategory("PolicyCov");
			coverage3.setMasterCoverage(masterCoverage3);
			coverage3.setContracted(true);
			coverage3.setTotalPremium(new Double(300));

			Coverage coverage4 = new Coverage();
			MasterCoverage masterCoverage4 = new MasterCoverage();
			masterCoverage4.setCode("1005");
			masterCoverage4.setName("Terrorism Liability");
			masterCoverage4.setTypeCoverage("P");
			masterCoverage4.setCategory("PolicyCov");
			coverage4.setMasterCoverage(masterCoverage4);
			coverage4.setContracted(true);
			coverage4.setRequired(true);
			coverage4.setTotalPremium(new Double(360));

			group1.getCoverages().add(coverage);
			group1.getCoverages().add(coverage1);
			group1.getCoverages().add(coverage2);
			group1.getCoverages().add(coverage3);
			group1.getCoverages().add(coverage4);

			// 2. group 2 additional coverage
			CoverageGroup group2 = new CoverageGroup();
			group2.setCode(2L);
			group2.setSequence(3);
			group2.setName("Additional Coverages");
			group2.setLevel("P");
			group2.setCoverages(new ArrayList<Coverage>());

			coverage = new Coverage();
			masterCoverage = new MasterCoverage();
			masterCoverage.setCode("2001");
			masterCoverage.setName("Equipment Breakdown");
			masterCoverage.setTypeCoverage("P");
			masterCoverage.setCategory("Additional");
			coverage.setMasterCoverage(masterCoverage);
			coverage.setContracted(true);
			coverage.setTotalPremium(new Double(90));

			coverage1 = new Coverage();
			masterCoverage1 = new MasterCoverage();
			masterCoverage1.setCode("2002");
			masterCoverage1.setName("Data Compromise");
			masterCoverage1.setTypeCoverage("P");
			masterCoverage1.setCategory("Additional");
			coverage1.setMasterCoverage(masterCoverage1);
			coverage1.setContracted(true);
			coverage1.setTotalPremium(new Double(74));

			coverage2 = new Coverage();
			masterCoverage2 = new MasterCoverage();
			masterCoverage2.setCode("2003");
			masterCoverage2.setName("Cyberone Liability");
			masterCoverage2.setTypeCoverage("P");
			masterCoverage2.setCategory("Additional");
			coverage2.setMasterCoverage(masterCoverage2);
			coverage2.setContracted(true);
			coverage2.setRequired(true);
			coverage2.setTotalPremium(new Double(98));

			group2.getCoverages().add(coverage);
			group2.getCoverages().add(coverage1);
			group2.getCoverages().add(coverage2);

			productCoverage.getCoveragesGroupList().add(group1);
			productCoverage.getCoveragesGroupList().add(group2);
		}

		return productCoverage;
	}

}
