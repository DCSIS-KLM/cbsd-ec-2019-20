package org.glassfish.movieplex7.points;

import java.util.Enumeration;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;

@Named
@RequestScoped
@JMSDestinationDefinition(name = "java:global/jms/pointsQueue",
        interfaceName = "javax.jms.Queue")
public class ReceivePointsBean {

    @Inject
    JMSContext context;

    @Resource(lookup = "java:global/jms/pointsQueue")
    Queue pointsQueue;

    public String receiveMessage() {
        String message = context.createConsumer(pointsQueue)
                .receiveBody(String.class);
        System.out.println("Received message: " + message);

        return message;
    }

    public int getQueueSize() {
        int count = 0;

        try {
            QueueBrowser browser = context.createBrowser(pointsQueue);
            Enumeration elements = browser.getEnumeration();

            while (elements.hasMoreElements()) {
                elements.nextElement();
                count++;
            }
        } catch (JMSException ex) {
            ex.printStackTrace();
        }

        return count;
    }
}
