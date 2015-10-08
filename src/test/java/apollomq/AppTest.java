package apollomq;

import javax.jms.JMSException;
import javax.jms.Message;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import activemq.Msg;
import activemq.QueueMessageConsumer;
import activemq.QueueMessageProducer;



/**
 * Unit test for simple App.
 */
public class AppTest {
	@org.junit.Test
	public void test1() throws JMSException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring-bean.xml");
		QueueMessageProducer destination = (QueueMessageProducer) applicationContext
				.getBean("queueMessageProducer");
		destination.sendQueue("�ɹ�������һ��JMS��Ϣ");

		System.out.println("�ɹ�������һ��JMS��Ϣ");

		QueueMessageConsumer queueMessageConsumer = (QueueMessageConsumer) applicationContext
				.getBean("queueMessageConsumer");
		ActiveMQObjectMessage message=(ActiveMQObjectMessage)queueMessageConsumer.receiveMsg();
		//Msg msg = (Msg)queueMessageConsumer.receiveMsg();
		// queueMessageListener.setMessageConverter(messageConverter)
		System.out.println("��ʼ����Ϣ������:"+message.getObject());
	}

}
