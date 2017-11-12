package com.test.first.config.rabbitconf.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by liuning on 2017/9/28.
 */
@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiver3 {
    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver C: " + message);
    }

}
