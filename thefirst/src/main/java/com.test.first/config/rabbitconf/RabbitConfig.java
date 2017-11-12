package com.test.first.config.rabbitconf;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liuning on 2017/9/28.
 */
@Configuration
public class RabbitConfig {

    public Queue Queue(){
        return new Queue("hello");
    }
}
