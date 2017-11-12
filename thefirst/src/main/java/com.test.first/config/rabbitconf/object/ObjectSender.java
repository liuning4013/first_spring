package com.test.first.config.rabbitconf.object;

import com.test.first.domain.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liuning on 2017/9/28.
 */
@Component
public class ObjectSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(User user){
        System.out.println("sender object" + user.toString());
        this.rabbitTemplate.convertAndSend("object",user);
    }
}
