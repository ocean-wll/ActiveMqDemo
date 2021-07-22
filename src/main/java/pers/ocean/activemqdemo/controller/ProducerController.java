package pers.ocean.activemqdemo.controller;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.ocean.activemqdemo.third.ActiveMqManager;

/**
 * activeMq producer 测试controller
 *
 * @author ocean_wll
 * @date 2021/7/22
 */
@RestController
@RequestMapping("/api/activemq")
public class ProducerController {

    @Autowired
    private ActiveMqManager activeMqManager;

    @GetMapping("/queue")
    public String sendQueue(@RequestParam String msg) {
        activeMqManager.sendMessage(new ActiveMQQueue("ocean_queue"), msg);
        return "success";
    }

    @GetMapping("/topic")
    public String sendTopic(@RequestParam String msg) {
        activeMqManager.sendMessage(new ActiveMQTopic("ocean_topic"), msg);
        return "success";
    }
}
