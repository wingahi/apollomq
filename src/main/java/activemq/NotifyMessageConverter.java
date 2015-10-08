package activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class NotifyMessageConverter implements MessageConverter {
	private static Logger logger = LoggerFactory
			.getLogger(NotifyMessageConverter.class);

	public Object fromMessage(Message message) throws JMSException,
			MessageConversionException {
		Msg msg=new Msg();
		String ss = "";// TODO Auto-generated method stub
		if (logger.isDebugEnabled()) {
			logger.debug("Receive JMS message :" + message);
		}
		if (message instanceof ObjectMessage) {
			ObjectMessage oMsg = (ObjectMessage) message;
			if (oMsg instanceof ActiveMQObjectMessage) {
				ActiveMQObjectMessage aMsg = (ActiveMQObjectMessage) oMsg;
				try {
					msg = (Msg)aMsg.getObject();
				} catch (Exception e) {
					// TODO: handle exception
					logger.error("Message:${} is not a instance of NoticeInfo."
							+ message.toString());
					throw new JMSException("Message:" + message.toString()
							+ "is not a instance of NoticeInfo."
							+ message.toString());
				}
			} else {
				logger
						.error("Message:${} is not a instance of ActiveMQObjectMessage."
								+ message.toString());
				throw new JMSException("Message:" + message.toString()
						+ "is not a instance of ActiveMQObjectMessage."
						+ message.toString());
			}
		} else {
			logger.error("Message:${} is not a instance of ObjectMessage."
					+ message.toString());
			throw new JMSException("Message:" + message.toString()
					+ "is not a instance of ObjectMessage."
					+ message.toString());
		}
		return msg;
	}

	public Message toMessage(Object obj, Session session) throws JMSException,
			MessageConversionException {
		// TODO Auto-generated method stub
		ActiveMQObjectMessage msg = (ActiveMQObjectMessage) session
				.createObjectMessage();
		Msg msg2=new Msg();
		msg2.setContents(String.valueOf(obj));
		msg.setObject(msg2);
		return msg;
	}
}
