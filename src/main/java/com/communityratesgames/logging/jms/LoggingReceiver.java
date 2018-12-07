package com.communityratesgames.logging.jms;

import com.communityratesgames.logging.transactions.LoggingDataMethods;
import com.communityratesgames.logging.domain.Logging;

import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.inject.*;
import javax.jms.*;
import java.sql.Timestamp;

@MessageDriven
public class LoggingReceiver implements MessageListener {

    private final static Logger logger = Logger.getLogger(com.communityratesgames.logging.jms.LoggingReceiver.class);

    @Inject
    public LoggingDataMethods logMethods;

/* Instead of REST end point, this will be the "endpoint" for a jms queue. Works like an websocket listener*/
    @Override
    public void onMessage(Message message) {
        try {
            Logging log = new Logging(0L, new Timestamp(System.currentTimeMillis()), ((TextMessage)message).getText());
            logger.info("Got log: " + log.getMessage());
            logMethods.addNewLog(log);
            System.out.println(message.getBody(String.class));
        } catch (JMSException ex) {
            logger.error("Reciever:  " + ex);
        }
    }
}
