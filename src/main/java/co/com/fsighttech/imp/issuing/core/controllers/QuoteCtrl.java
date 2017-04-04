/**
 * 
 */
package co.com.fsighttech.imp.issuing.core.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.fsighttech.imp.issuing.bo.core.Policy;
import co.com.fsighttech.imp.issuing.bo.core.PolicySummary;
import co.com.fsighttech.imp.issuing.core.services.api.IQuoteService;

/**
 * @author jtorres
 *
 */
@RestController
public class QuoteCtrl {

	
	@Autowired
	private IQuoteService quoteService;

	/**
	 * expose a service to offer the quote operation
	 * quote.
	 * 
	 * @return Questionnaire, set of questions
	 */
	@RequestMapping(value = "/processQuickQuote", method = RequestMethod.POST)
	public List<Policy> quickQuote(@RequestBody Policy policy) {
		
		//policy quoted
		List<Policy> policies = new ArrayList<Policy>();
		
		//retrieving policies quoted
		policies =  quoteService.quotePolicy(policy);
		
		return policies;
	}
	
	/**
	 * expose a service to offer the quote operation
	 * quote.
	 * 
	 * @return Questionnaire, set of questions
	 */
	@RequestMapping(value = "/processQuickQuoteSummary", method = RequestMethod.POST)
	public List<PolicySummary> quickQuoteSummary(@RequestBody Policy policy) {
		
		//policy quoted
		List<PolicySummary> policies = new ArrayList<PolicySummary>();
		
		//retrieving policies quoted
		policies =  quoteService.quotePolicySummary(policy);
		
		return policies;
	}
	
	
	/**
	 * expose a ws to get the configuration structure to identify the product to
	 * quote.
	 * 
	 * @return List<User>, user list
	 */
	@RequestMapping(value = "/policyStr", method = RequestMethod.GET)
	public Policy getPolicyStr() {

		Policy policy = new Policy();
		
//		policy.setCompany(new Company());
//		policy.setRisks(new ArrayList<Risk>());
//		Risk risk = new Risk();
//		
//		
//		VariableData d1 = new VariableData();
//		d1.setCode("zipCode");
//		d1.setValue("3306");
//		
//		VariableData d2 = new VariableData();
//		d2.setCode("industryId");
//		d2.setValue("IT");
//		
//		VariableData d3 = new VariableData();
//		d3.setCode("numberEmployee");
//		d3.setValue("1-4");
//		
//		List<VariableData>  vardata = new ArrayList<VariableData>();
//		vardata.add(d1);
//		vardata.add(d2);
//		vardata.add(d3);
//		
//		risk.setVariableDataRisk(vardata);
//		
//		List<Coverage> coverages = new ArrayList<Coverage>();
//		
//		Coverage c1  = new Coverage();
//		c1.setName("Equipment Breakdown");
//		c1.setState("Yes");
//		
//		Coverage c2  = new Coverage();
//		c2.setName("Data Compromise - Identity Recovery Coverage");
//		c2.setState("No");
//		
//		Coverage c3  = new Coverage();
//		c3.setName("CiberOne Liability");
//		c3.setState("Available");
//		
//		coverages.add(c1);
//		coverages.add(c2);
//		coverages.add(c3);
//		risk.setCoverages(coverages);
		
//		policy.getRisks().add(risk);
		
		return policy;
		
	}

}
