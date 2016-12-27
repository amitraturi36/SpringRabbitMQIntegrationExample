package com.companyName.SpringRabbitMQIntegrationExample.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.companyName.SpringRabbitMQIntegrationExample.util.Constants;

@Configuration
public class RabbitMqConfiguration {
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
		return connectionFactory;
	}

	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory());
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		return new RabbitTemplate(connectionFactory());
	}

	@Bean
	public Queue myQueue() {
		return new Queue(Constants.queueName);
	}
	
	@Bean(name="rabbitListenerContainerFactory")
	 public SimpleRabbitListenerContainerFactory listenerFactory(){
	  SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
	  factory.setConnectionFactory(connectionFactory());
	  return factory;
	 }

}
