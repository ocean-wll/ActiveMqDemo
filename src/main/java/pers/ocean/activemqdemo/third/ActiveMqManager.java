package pers.ocean.activemqdemo.third;

import javax.jms.Destination;

/**
 * @author ocean_wll
 * @date 2021/7/22
 */
public interface ActiveMqManager {

    /**
     * 发送消息
     *
     * @param destination 目的地
     * @param message     消息内容
     */
    void sendMessage(Destination destination, final String message);
}
