package com.companyName.SpringRabbitMQIntegrationExample.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.companyName.SpringRabbitMQIntegrationExample.util.Constants;
import com.companyName.SpringRabbitMQIntegrationExample.util.Events;


@Service
public class EventPublisherService {
	@Autowired
	AmqpTemplate template;
	public void publishEvent(Events event, Object messages) throws IOException, TimeoutException {
		Map<String, Object> message = new HashMap<String, Object>();
		message.put("event", event);
		message.put("message", messages);
		template.convertAndSend(Constants.queueName,message);
	}
	

}
