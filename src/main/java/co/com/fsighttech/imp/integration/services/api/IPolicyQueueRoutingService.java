/**
 * 
 */
package co.com.fsighttech.imp.integration.services.api;

import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * @author YANKER
 *
 */
public interface IPolicyQueueRoutingService {

	public String routePolicyOperationProduct(@Header MessageHeaders policyHeader);
}
