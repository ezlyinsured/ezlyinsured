package co.com.fsighttech.imp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DynamicQueueLoaderConfig implements BeanFactoryPostProcessor {

//	@Bean
//	DirectExchange exchange() {
//		return new DirectExchange("policy-exchange");
//	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		// TODO es necesario cargar el archivo de propiedades para cargar colas
		// y exhanges keys
		for (int i = 0; i < 3; i++) {

			String queueNameConf = "QUOTE_BOP801" + (i + 1);
			String queueExchangeKeyConf = "ROUTE_BOP801";// + (i + 1);

			//0 creating the exchange
//			GenericBeanDefinition beanDefinitionExch = new GenericBeanDefinition();
//			beanDefinitionExch.setBeanClass(DirectExchange.class);
//			beanDefinitionExch.setAutowireCandidate(true);
//
//			ConstructorArgumentValues constructorQueueExch = new ConstructorArgumentValues();
//			constructorQueueExch.addIndexedArgumentValue(0, "policy-exchange");
//			beanDefinitionExch.setConstructorArgumentValues(constructorQueueExch);
//			
			BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
//			registry.registerBeanDefinition("policy-exchange", beanDefinitionExch);

			
			//1. registering the queue configuration
			GenericBeanDefinition beanDefinitionQueue = new GenericBeanDefinition();
			beanDefinitionQueue.setBeanClass(Queue.class);
			beanDefinitionQueue.setAutowireCandidate(true);

			ConstructorArgumentValues constructorQueueValue = new ConstructorArgumentValues();
			constructorQueueValue.addIndexedArgumentValue(0, queueNameConf);
			beanDefinitionQueue.setConstructorArgumentValues(constructorQueueValue);
			
			// Creating and registering the queue
//			Queue configQueueInstance = QueueBuilder.durable(queueNameConf).build();

			registry = (BeanDefinitionRegistry) beanFactory;
			registry.registerBeanDefinition(queueNameConf, beanDefinitionQueue);

			//2.  registering the binding exchange key to route the messages in
			// queues
//			GenericBeanDefinition beanDefinitionExKey = new GenericBeanDefinition();
//			beanDefinitionExKey.setBeanClass(Binding.class);
//			beanDefinitionExKey.setAutowireCandidate(true);
//
//			ConstructorArgumentValues constructorExKeyValue = new ConstructorArgumentValues();
//			constructorExKeyValue.addIndexedArgumentValue(0, queueNameConf);
//			constructorExKeyValue.addIndexedArgumentValue(1, DestinationType.QUEUE);
//			constructorExKeyValue.addIndexedArgumentValue(2, "policy-exchange");
//			constructorExKeyValue.addIndexedArgumentValue(3, queueExchangeKeyConf);
//			beanDefinitionExKey.setConstructorArgumentValues(constructorExKeyValue);
//
//			// creating and registering the exchange routing key
//			Binding bindingRouteKey = BindingBuilder.bind(configQueueInstance).to(exchange())
//					.with(queueExchangeKeyConf);
//			bindingRouteKey.setShouldDeclare(true);
//
//			registry = (BeanDefinitionRegistry) beanFactory;
//			registry.registerBeanDefinition(queueExchangeKeyConf, beanDefinitionExKey);

		}
		
		
		BeanDefinitionRegistry registry1 = (BeanDefinitionRegistry) beanFactory;
		
		//1. registering the queue configuration
		GenericBeanDefinition beanDefinitionQueue = new GenericBeanDefinition();
		beanDefinitionQueue.setBeanClass(Queue.class);
		beanDefinitionQueue.setAutowireCandidate(true);

		ConstructorArgumentValues constructorQueueValue = new ConstructorArgumentValues();
		constructorQueueValue.addIndexedArgumentValue(0, "response-policy-queue");
		beanDefinitionQueue.setConstructorArgumentValues(constructorQueueValue);
		registry1 = (BeanDefinitionRegistry) beanFactory;
		registry1.registerBeanDefinition("response-policy-queue", beanDefinitionQueue);

	}
}