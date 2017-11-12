package com.test.first.config.rabbitconf.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by liuning on 2017/9/28.
 */
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiver1 {
    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver A  : " + message);
    }
}
