package pers.ocean.activemqdemo.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * queue消费者
 *
 * @author ocean_wll
 * @date 2021/7/22
 */
@Component
public class ConsumerListener {

    @JmsListener(destination = "ocean_queue", containerFactory = "queueListener")
    public void readActiveQueueOne(final TextMessage msg, Session session) throws JMSException {
        // 模拟失败重试
        session.recover();
        System.out.println("readActiveQueueOne, read: " + msg.getText());
    }

    @JmsListener(destination = "ocean_queue", containerFactory = "queueListener")
    public void readActiveQueueTwo(final String msg) {
        System.out.println("readActiveQueueTwo, read: " + msg);
    }

    @JmsListener(destination = "ocean_topic", containerFactory = "topicListener")
    public void readActiveTopicOne(final String msg) {
        System.out.println("readActiveTopicOne, read: " + msg);
    }

    @JmsListener(destination = "ocean_topic", containerFactory = "topicListener")
    public void readActiveTopicTwo(final TextMessage msg) throws JMSException {
        System.out.println("readActiveTopicTwo, read: " + msg.getText());
    }
}
