package com.test.springboot.rabbitmq;

import com.test.first.Application;
import com.test.first.config.rabbitconf.onetomany.OneSender;
import com.test.first.config.rabbitconf.onetomany.OneSender2;
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
public class OnetoMany {

    @Autowired
    private OneSender oneSender;

    @Autowired
    private OneSender2 oneSender2;

    @Test
    public void oneToMany(){
        for (int i = 0;i<20;i++){
            oneSender.send(i);
        }
    }

    @Test
    public void manyToMany(){
        for (int i = 0;i<20;i++){
            oneSender.send(i);
            oneSender2.send(i);
        }
    }

}
