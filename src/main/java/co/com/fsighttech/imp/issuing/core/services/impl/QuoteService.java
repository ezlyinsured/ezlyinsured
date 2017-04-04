/**
 * 
 */
package co.com.fsighttech.imp.issuing.core.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.fsighttech.imp.issuing.bo.configuration.ProductCoverage;
import co.com.fsighttech.imp.issuing.bo.core.CacheQuote;
import co.com.fsighttech.imp.issuing.bo.core.Company;
import co.com.fsighttech.imp.issuing.bo.core.Coverage;
import co.com.fsighttech.imp.issuing.bo.core.CoverageGroup;
import co.com.fsighttech.imp.issuing.bo.core.CoverageSummary;
import co.com.fsighttech.imp.issuing.bo.core.Policy;
import co.com.fsighttech.imp.issuing.bo.core.PolicySummary;
import co.com.fsighttech.imp.issuing.bo.core.Premium;
import co.com.fsighttech.imp.issuing.bo.core.Risk;
import co.com.fsighttech.imp.issuing.bo.core.VariableData;
import co.com.fsighttech.imp.issuing.core.services.api.IQuoteService;
import co.com.fsighttech.imp.issuing.shared.services.api.IProductConfigurationService;
import co.com.fsighttech.imp.issuing.shared.services.impl.CacheService;

/**
 * This service is simulating a service to quote a policy with the information
 * provided by user. THIs INTERFACE IS A TEMPORARY SERVICE AND NEEDs TO BE
 * INCLUDED IN THE INTEGRATOR COMPONENT CREATED IN THE FUTURE.
 * 
 * @author jtorres
 *
 */
@Service
public class QuoteService implements IQuoteService {

	@Autowired
	IProductConfigurationService productConfigurationService;

	/**
	 * Quote a policy according to the policy information provided by user
	 * 
	 * @return List <Policy>, set of policies quoted per company
	 */
	@Override
	public List<Policy> quotePolicy(Policy policy) {

		List<Policy> policiesQuoted = null;

		// Dummy simulating the set of policies retrieved with the information
		// provided

		// building the cache object
		CacheQuote cacheQ = new CacheQuote();
		cacheQ.setZipCode(getPVariableDataByName(policy, "ZIP_CODE").getValue());
		cacheQ.setIndustryId(getPVariableDataByName(policy, "INDUSTRY_ID").getValue());
		// cacheQ.setCoveragesSelected(getPolicyCoveragesSelected(policy));
		cacheQ.setNumberEmployeeId(getPVariableDataByName(policy, "NUM_EMMPLOYEES").getValue());

		// trying to get the quotation from cache
		HashMap<CacheQuote, List<Policy>> cacheQuote = CacheService.getQuoteCache();

		// retrieving quote from cache
		policiesQuoted = cacheQuote.get(cacheQ);

		if (policiesQuoted == null || policiesQuoted.isEmpty()) {

			policiesQuoted = new ArrayList<Policy>();

			// it is necessary to make a new quote

			// Dummy simulating the quote process
			Random randomQuotes = new Random();
			Integer quotations = randomQuotes.nextInt(10)+3;

			for (int i = 0; i < quotations; i++) {
				// building the quotes retrieved by insurance companies
				Policy policyQ = new Policy();

				//associating product
				policyQ.setProduct(policy.getProduct());
				
				// association the company
				Company companyQ = new Company();
				companyQ.setId(new Long (i));
				companyQ.setName(getInsuranceCompany(i));
				policyQ.setCompany(companyQ);
				policyQ.setPolicyNumber("" + new Long(80100000 + i));
				// association the premium
				Premium premiumQ = new Premium();
				
//				//simulating the best policy to put it on the first array position 
//				if (i==0){
//					premiumQ.setValue(randomQuotes.nextInt(50) + 20);
//				}else{
//					premiumQ.setValue(randomQuotes.nextInt(200) + 150);
//				}
				premiumQ.setPeriodType("$/mo");
				policyQ.setPremium(premiumQ);

				// association variable data at policy level
				policyQ.setVariableDataList(policy.getVariableDataList());

				// associating the coverages at policy level
				policyQ.setCoveragesGroups(policy.getCoveragesGroups());

				// obtaining policy risks and coverages to calculate premium
				// given by user
				policyQ.setRisks(policy.getRisks());

				// iterating over policy risks
				/*for (int j = 0; j < policy.getRisks().size(); j++) {

					Risk riskJ = policy.getRisks().get(j);

					// assigning a simulated number of coverages contracted for
					// each group
					for (int k = 0; k < riskJ.getCoveragesGroups().size(); k++) {
						CoverageGroup coverageG = riskJ.getCoveragesGroups().get(k);
						coverageG.setCoveragesContracted(randomQuotes.nextInt(5));
					}
				}*/

				policiesQuoted.add(policyQ);
			}
		
//			cacheQuote.put(cacheQ, policiesQuoted);
		}		
		
		return policiesQuoted;

	}
	
	
	private String getInsuranceCompany (int idCompany){
		
		if (idCompany==1){
			return "Mapfre";
		}else if (idCompany==2){
			return "Alliance";
		}else if (idCompany==3){
			return "Liberty Mutual";
		}else if (idCompany==4){
			return "Allstate Insurance Company";
		}else if (idCompany==5){
			return "AIA Group Limited";
		}else if (idCompany==6){
			return "State Farm";
		}else if (idCompany==7){
			return "AAA";
		}else if (idCompany==8){
			return "Manulife";
		}else if (idCompany==9){
			return "Aflac";
		}else if (idCompany==10){
			return "Truckers Insurance HQ";
		}else if (idCompany==11){
			return "AIG";
		}else if (idCompany==12){
			return "Farmers Insurance Group";
		}else if (idCompany==13){
			return "Travelers";
		}else if (idCompany==14){
			return "Amica";
		}else if (idCompany==15){
			return "Royal Sundaram";
		}else if (idCompany==16){
			return "Cigna";
		}else if (idCompany==17){
			return "Ameriprise";
		}else if (idCompany==18){
			return "21st Century Insurance";
		}else{
			return "Mapfre";
		}
		
		
	}

	/**
	 * Quote a policy summary list, according to the policy information provided
	 * by user
	 * 
	 * @return List <PolicySummary>, set of policies quoted per company
	 */
	@Override
	public List<PolicySummary> quotePolicySummary(Policy policy) {

		List<PolicySummary> policiesQuotedSummary = new ArrayList<PolicySummary>();

		// obtaining policies result of quote process
		List<Policy> policiesQuoted = this.quotePolicy(policy);

		// obtaining coverages at policy level configuration
		ProductCoverage productCoverage = productConfigurationService
				.getCoveragesPolicyLevel(policy.getProduct().getId());
		
//		ProductCoverage riskCoveragesConf = productConfigurationService
//				.getCoveragesRiskLevel(policy.getProduct().getId());

		// Iterating over policies to calculated the quote information required
		// by group of coverages
		for (Policy policyQ : policiesQuoted) {

			PolicySummary policySummary = new PolicySummary();
			CoverageSummary coverageSummary = new CoverageSummary();
			policySummary.setCoveragesSummary(new ArrayList<CoverageSummary>());
			policySummary.setPolicy(policyQ);

			//calling the sergvice to get the coverage configuration vby company
			ProductCoverage productCoveragebyInsComp = productConfigurationService.getCoveragesPolicyLevelByInsComp(policyQ.getCompany().getId());
			
			//calling the sergvice to get the coverage configuration vby company
			ProductCoverage riskCoverages = productConfigurationService.getCoveragesRiskLevelByInsComp(policyQ.getCompany().getId());
			
			
			
			// iterating the coverages groups at policy level configured to calculated the information
			// required
			for (CoverageGroup covGrpQuote: policyQ.getCoveragesGroups()){
			
				//getting the offering of insurance company about coverages
				CoverageGroup coverageGroup =  new CoverageGroup();
				for (CoverageGroup coverageGroup1 : productCoveragebyInsComp.getCoveragesGroupList()) {
					if (coverageGroup1.getCode().equals(covGrpQuote.getCode())){
						coverageGroup = coverageGroup1;
						break;
					}
				}
	
				// validating that it is a group parent and it is at policy
				// level
				if (coverageGroup.getParentCode() == null && "P".equalsIgnoreCase(coverageGroup.getLevel())) {

					coverageSummary = new CoverageSummary();
					coverageSummary.setGroupCode(coverageGroup.getCode());
					
					// calculating contracted group and number of coverages
					// contracted
					if (policyQ.getCoveragesGroups() != null && policyQ.getCoveragesGroups().contains(coverageGroup)) {

						int realcovsContracted =  0;
						int allCovsContracted = 0;
						for (Coverage covQuote: covGrpQuote.getCoverages()){
							
							//getting the group to calculate the premium
							Coverage covGroup = null; 
							for (Coverage covGroup1:coverageGroup.getCoverages()){
								if (covGroup1.getMasterCoverage().getCode().equalsIgnoreCase(covQuote.getMasterCoverage().getCode())){
									covGroup = covGroup1;
									break;
								}
							}
						
							if (covQuote.getContracted()){
								allCovsContracted = allCovsContracted + 1;
								if (covGroup.getContracted()){
									covQuote.setTotalPremium(covGroup.getTotalPremium());
									realcovsContracted=realcovsContracted+1;
									
									//calculating total premium
									policyQ.getPremium().setValue(policyQ.getPremium().getValue()+covGroup.getTotalPremium());
								}
														
							}

						}

						coverageSummary.setCoverageContracted(realcovsContracted);
						coverageSummary.setAllCoveragesContracted(allCovsContracted);
						//calculating the percentage of coverages contracted for group
						Double percentageCovsCalculated =  (new Double(realcovsContracted)*100)/new Double(allCovsContracted);
						coverageSummary.setTotalPremiumGroup(policyQ.getPremium().getValue());
						coverageSummary.setPercentageContracted(percentageCovsCalculated);
					
					}
					
					if (coverageSummary.getGroupCode() != null) {
						// associating the coverageSummary to the policy summary
						policySummary.getCoveragesSummary().add(coverageSummary);
					}else{
						coverageSummary.setContracted(false);
						coverageSummary.setCoverageContracted(0);
						policySummary.getCoveragesSummary().add(coverageSummary);
					}
	    	    }
				
				
			}
			
			
			
			coverageSummary = new CoverageSummary();
			coverageSummary.setGroupCode(new Long (productCoverage.getCoveragesGroupList().size()+1));
			int realRcovsContracted =  0;
			int allRCovsContracted = 0;
			//iterating over risks
			for (Risk risk: policyQ.getRisks()){
			
			// iterating the coverages groups at policy level configured to calculated the information
				// required
				
				// calculating contracted group and number of coverages
				// contracted
				
				for (Coverage coveragesR: risk.getCoverages()){
									
					//getting the offering of insurance company about coverages
					Coverage coverageReference =  new Coverage();
					for (Coverage coverageI : riskCoverages.getCoveragesGroupList().get(0).getCoverages()) {
						if (coveragesR.getId().equals(coverageI.getId())){
							coverageReference = coverageI;
							break;
						}
					}
					
					if (coveragesR.getContracted()){
						allRCovsContracted = allRCovsContracted + 1;
						if (coverageReference.getContracted()){
							coveragesR.setTotalPremium(coverageReference.getTotalPremium());
							realRcovsContracted=realRcovsContracted+1;
							
							//calculating total premium
							policyQ.getPremium().setValue(policyQ.getPremium().getValue()+coverageReference.getTotalPremium());
						}
												
					}
					
					
					if (risk.getChildrenRisks()!=null && risk.getChildrenRisks().size()>0){
						
						//calculating premium of coverages selected in the second level
						for (Risk riskCh: risk.getChildrenRisks()){
							
							for (Coverage coveragesRCh: riskCh.getCoverages()){
								//getting the offering of insurance company about coverages
								
								Coverage coverageReferenceCh =  new Coverage();
								for (Coverage coverageICh : riskCoverages.getCoveragesGroupList().get(1).getCoverages()) {
									if (coveragesRCh.getId().equals(coverageICh.getId())){
										coverageReferenceCh = coverageICh;
										break;
									}
								}
								
								if (coveragesRCh.getContracted()){
									allRCovsContracted = allRCovsContracted + 1;
									if (coverageReferenceCh.getContracted()){
										coveragesR.setTotalPremium(coverageReferenceCh.getTotalPremium());
										realRcovsContracted=realRcovsContracted+1;
										
										//calculating total premium
										policyQ.getPremium().setValue(policyQ.getPremium().getValue()+coverageReferenceCh.getTotalPremium());
									}
															
								}
							}
						}
					}
					
				}
				
			}
			
			coverageSummary.setCoverageContracted(realRcovsContracted);
			coverageSummary.setAllCoveragesContracted(allRCovsContracted);
			//calculating the percentage of coverages contracted for group
			Double percentageCovsCalculated =  (new Double(realRcovsContracted)*100)/new Double(allRCovsContracted);
			coverageSummary.setTotalPremiumGroup(policyQ.getPremium().getValue());
			coverageSummary.setPercentageContracted(percentageCovsCalculated);
			
			
			if (coverageSummary.getGroupCode() != null) {
				// associating the coverageSummary to the policy summary
				policySummary.getCoveragesSummary().add(coverageSummary);
			}else{
				coverageSummary.setContracted(false);
				coverageSummary.setCoverageContracted(0);
				policySummary.getCoveragesSummary().add(coverageSummary);
			}
			
			
			

			//adding the quotation to the set of policy summary
			policiesQuotedSummary.add(policySummary);
			
		}
		
		
		//ordering the quote list
		Collections.sort(policiesQuotedSummary, Collections.reverseOrder(new Comparator<PolicySummary>() {
			@Override
			public int compare(PolicySummary p1, PolicySummary p2) {
				
				int comparePercentage =  p1.getTotalPercentage().compareTo(p2.getTotalPercentage());
				
				if (comparePercentage!=0){
					return comparePercentage;
				}else{
					
					 if (p1.getPolicy().getPremium().getValue()== p2.getPolicy().getPremium().getValue()){
						 return 0;
					 }else if (p1.getPolicy().getPremium().getValue()< p2.getPolicy().getPremium().getValue()){
						 return 1;
					 }else{
						 return -1;
					 }

				}
			}
		}));
		
		System.out.println("");
		
		return policiesQuotedSummary;

	}

	
	
	
	
	/**
	 * Operation to retrieve a variable data object given a name
	 * 
	 * @return VariableData, variableData attribute
	 */
	public VariableData getPVariableDataByName(Policy policy, String variableName) {

		VariableData variableDataResult = null;
		List<VariableData> riskVariableDataL = policy.getVariableDataList();
		if (riskVariableDataL != null) {
			for (VariableData variableData : riskVariableDataL) {

				if (variableName.equalsIgnoreCase(variableData.getCode())) {
					variableDataResult = variableData;
					break;
				}
			}
		}
		return variableDataResult;
	}

	// /**
	// * Operation to retrieve a variable data object given a name
	// *
	// * @return string, set of id coverages concatenated
	// */
	// public String getPolicyCoveragesSelected(Policy policy) {
	//
	// String coverageIds = "";
	//
	// // retrieving risk 0 that is the policy coverages
	// Risk policyRisk = policy.getRisks().get(0);
	//
	// // concatening the id's of coverages
	// for (Coverage coverage : policyRisk.getCoverages()) {
	// coverageIds = coverageIds + coverage.getCode();
	// }
	// return coverageIds;
	// }

}
