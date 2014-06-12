package com.toni.messaging;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MessageSendingTest {
	
	@Inject
	private MessageSender sender;
	
	@Inject
	private JmsTemplate jmsTemplate;
	
	@Inject
	private Destination destination;

	@Test
	public void testMessageSent() throws JMSException {
		String message = "test message";
		sender.send(message);
		TextMessage text = (TextMessage) jmsTemplate.receive(destination);
		assertEquals(message, text.getText());
	}
}
