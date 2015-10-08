package activemq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("queueMessageConsumer")
public class QueueMessageConsumer {
	@Autowired
	ActiveMQConnectionFactory connectinFactory;

	@Autowired
	Destination queue;
	public Object receiveMsg() throws JMSException {

		Connection connection = connectinFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		MessageConsumer consumer = session.createConsumer(queue);
		Object msg = consumer.receive();
		System.out.println(msg);
		return msg;
	}
}
