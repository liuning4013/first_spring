package com.test.springboot.rabbitmq;

import com.test.first.Application;
import com.test.first.config.rabbitconf.hello.HelloSender;
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
public class HelloTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void testhello(){
        helloSender.send();
    }
}
