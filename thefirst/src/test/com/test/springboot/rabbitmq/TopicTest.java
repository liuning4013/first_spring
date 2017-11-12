package com.test.springboot.rabbitmq;

import com.test.first.Application;
import com.test.first.config.rabbitconf.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by liuning on 2017/9/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TopicTest {

    @Autowired
    private TopicSender topicSender;


    @Test
    public void topic(){
        topicSender.send();
    }
    @Test
    public void topic1(){
        topicSender.send1();
    }

    @Test
    public void topic2(){
        topicSender.send2();
    }
}
