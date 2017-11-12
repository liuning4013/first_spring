package com.test.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by liuning on 2017/9/18.
 */
@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableTransactionManagement //如果mybatis中service实现类中加入事务注解，需要此处添加该注解
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);

    }
}
