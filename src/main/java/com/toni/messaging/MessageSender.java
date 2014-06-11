package com.toni.messaging;

import org.springframework.jms.core.JmsTemplate;

public class MessageSender {

	private final JmsTemplate jmsTemplate;

	public MessageSender(final JmsTemplate jmsTemplate) {
		super();
		this.jmsTemplate = jmsTemplate;
	}

	public void send(final Object message){
		jmsTemplate.convertAndSend(message);
	}
}
