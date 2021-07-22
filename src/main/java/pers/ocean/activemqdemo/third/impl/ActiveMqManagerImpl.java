package pers.ocean.activemqdemo.third.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import pers.ocean.activemqdemo.third.ActiveMqManager;

import javax.jms.Destination;

/**
 * @author ocean_wll
 * @date 2021/7/22
 */
@Service
public class ActiveMqManagerImpl implements ActiveMqManager {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void sendMessage(Destination destination, String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
