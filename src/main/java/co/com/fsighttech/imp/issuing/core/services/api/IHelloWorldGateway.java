/**
 * 
 */
package co.com.fsighttech.imp.issuing.core.services.api;

import org.springframework.integration.annotation.Gateway;

/**
 * @author YANKER
 *
 */
public interface IHelloWorldGateway {


	@Gateway(requestChannel="say.hello.channel")
	void sayHello (String name);
}
