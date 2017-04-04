package co.com.fsighttech.imp.config;
import java.util.Random;

import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Zoltan Altfatter
 */
//@Component
//@Slf4j
public class Producer {

	private AsyncRabbitTemplate asyncRabbitTemplate;

	public Producer(AsyncRabbitTemplate asyncRabbitTemplate) {
		this.asyncRabbitTemplate = asyncRabbitTemplate;
	}

//	@Scheduled(fixedDelay = 50000L)
//	    public void send() {
//	        int number = new Random().nextInt(45);
//
////	        FiboCalcRequest request = new FiboCalcRequest(number);
//
//	        String request = "{company:{id:null,name:null},}" + number;
//	        
//	        AsyncRabbitTemplate.RabbitConverterFuture<String> future =
//	                asyncRabbitTemplate.convertSendAndReceive("policy-exchange","QUOTE_BOP8011", request);
//	        log.info("Thread: '{}' calc fibonacci for number '{}'", Thread.currentThread().getName(), number);
//
//	        future.addCallback(new ListenableFutureCallback<String>() {
//	            @Override
//	            public void onFailure(Throwable throwable) {
//	                throwable.printStackTrace();
//	            }
//
//	            @Override
//	            public void onSuccess(String result) {
//	                log.info("Thread: '{}' result: '{}'", Thread.currentThread().getName(), result);
//	            }
//	        });
//
//	    }

}
