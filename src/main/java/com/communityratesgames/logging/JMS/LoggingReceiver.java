package com.communityratesgames.logging.JMS;

import org.apache.log4j.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = {@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/crg")})
public class LoggingReceiver implements MessageListener {

    private final static Logger logger = Logger.getLogger(com.communityratesgames.logging.JMS.LoggingReceiver.class);

/* Instead of REST end point, this will be the "endpoint" for a JMS queue. Works like an websocket listener*/
    @Override
    public void onMessage(Message message) {
        logger.info("ONMESSAGE IN RECEIVER: " + message);
        try {
            System.out.println(message.getBody(String.class));
        } catch (JMSException ex) {
            logger.error("Reciever:  " + ex);
        }
    }
}
