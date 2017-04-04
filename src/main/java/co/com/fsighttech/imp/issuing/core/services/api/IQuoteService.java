/**
 * 
 */
package co.com.fsighttech.imp.issuing.core.services.api;

import java.util.List;

import co.com.fsighttech.imp.issuing.bo.core.Policy;
import co.com.fsighttech.imp.issuing.bo.core.PolicySummary;

/**
 * This interface is simulating a service to quote a policy with the information
 * provided by user. THIs INTERFACE IS A TEMPORARY SERVICE AND NEEDs TO BE
 * INCLUDED IN THE INTEGRATOR COMPONENT CREATED IN THE FUTURE.
 * 
 * @author jtorres
 *
 */
public interface IQuoteService {

	/**
	 * Quote a policy according to the policy information provided by user
	 * 
	 * @param policy Policy with the information used to quote in the insurance companies
	 * 
	 * @return List <Policy>, set of policies quoted per company
	 */
	public List <Policy> quotePolicy(Policy policy);
	
	/**
	 * Quote a policy summary list, according to the policy information provided by user
	 * 
	 * @return List <PolicySummary>, set of policies quoted per company
	 */
	public List<PolicySummary> quotePolicySummary(Policy policy);
}
