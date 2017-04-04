/**
 * 
 */
package co.com.fsighttech.imp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YANKER
 *
 */
//@Configuration
public class AmqpAsyncConfig {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private ConnectionFactory connectionFactory;

//	@Autowired
//	private MessageListenerAdapter listenerAdapter;
//	
//	@Bean
//	Queue replyQueue() {
//		return QueueBuilder.durable("response-policy-queue").build();
//	}

	@Bean
	public AsyncRabbitTemplate asyncTemplate() {

		AsyncRabbitTemplate asyncTemplate = new AsyncRabbitTemplate(rabbitTemplate, replyContainer(connectionFactory));
//		asyncTemplate.setEnableConfirms(true);
		return asyncTemplate; 
	}

	@Bean
	public SimpleMessageListenerContainer replyContainer(ConnectionFactory connectionFactory/*,
			MessageListenerAdapter listenerAdapter*/) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
		container.setQueueNames("response-policy-queue");
//		listenerAdapter.addQueueOrTagToMethodName("response-policy-queue", "receiveMessage");
//		container.setMessageListener(listenerAdapter);
		return container;
	}
//
//	@Bean
//	MessageListenerAdapter listenerAdapter(Receiver receiver) {
//		return new MessageListenerAdapter(receiver, "receiveMessage");
//	}

}