package com.test.first.config.rabbitconf.hello;

import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by liuning on 2017/9/28.
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReciver {

    @RabbitHandler
    public void process(String hello){
        System.out.println("receiver:"+hello);
    }
}
