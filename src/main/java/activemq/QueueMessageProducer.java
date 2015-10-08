package activemq;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import activemq.NotifyMessageConverter;

@Component("queueMessageProducer")
public class QueueMessageProducer {
	private JmsTemplate jmsTemplate;
	private Destination notifyQueue;
	private NotifyMessageConverter messageConverter;

	public void sendQueue(String msg) {
		sendMessage(msg);
	}

	private void sendMessage(String msg) {
		// TODO Auto-generated method stub
		jmsTemplate.setMessageConverter(messageConverter);
		jmsTemplate.setPubSubDomain(false);
		jmsTemplate.convertAndSend(notifyQueue, msg);
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public Destination getNotifyQueue() {
		return notifyQueue;
	}

	public void setNotifyQueue(Destination notifyQueue) {
		this.notifyQueue = notifyQueue;
	}

	public NotifyMessageConverter getMessageConverter() {
		return messageConverter;
	}

	public void setMessageConverter(NotifyMessageConverter messageConverter) {
		this.messageConverter = messageConverter;
	}
}
