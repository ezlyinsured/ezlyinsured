package co.com.fsighttech.imp.integration.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import co.com.fsighttech.imp.issuing.core.services.api.IQuoteService;

@Component
public class SimpleEchoResponder {

	@Autowired
	private IQuoteService quoteService;

		@ServiceActivator
		public String issueResponseFor(String message) {
			
			//TODO aqui se deberia ersistir la respuestas de las diferentes compañias de seguros
//			
//			ObjectMapper mapper = new ObjectMapper();
//			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//			Policy pol;
//			List<PolicySummary> lisTP = new ArrayList<>();
//			String policies="";
//			System.out.println(message.getPayload());
//			try {
//				pol = mapper.readValue(message.getPayload(),Policy.class);
//				lisTP =  quoteService.quotePolicySummary(pol);
////				
//				policies = mapper.writeValueAsString(lisTP);
//			} catch (JsonParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (JsonMappingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println("ACTIVATOR--> " +  message );

			return message;
		}
		
		

}
