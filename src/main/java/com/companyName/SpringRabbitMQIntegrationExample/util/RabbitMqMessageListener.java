package com.companyName.SpringRabbitMQIntegrationExample.util;

import java.util.Map;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.companyName.SpringRabbitMQIntegrationExample.util.Events;

@EnableRabbit
@Component
public class RabbitMqMessageListener {
	@RabbitListener(queues = Constants.queueName)
	public void processQueue(Map<String, Object> message) {
		EventHandler.handler((Events) message.get("event"), message.get("message"));
	}
}
