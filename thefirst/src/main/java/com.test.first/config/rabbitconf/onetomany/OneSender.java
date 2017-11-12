package com.test.first.config.rabbitconf.onetomany;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liuning on 2017/9/28.
 */
@Component
public class OneSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i){
        String context = "rabbitmq one to many"+"****"+i;
        System.out.println("Sender1 : " + context);
        this.rabbitTemplate.convertAndSend("neo", context);
    }
}
