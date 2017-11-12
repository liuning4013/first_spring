package com.example.demo.remote;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by liuning on 2017/10/10.
 * 当发生熔断时的处理类
 */
@Component
public class HelloRemoteHeric implements HelloRemote {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "hello"+name+"send failed!";
    }
}
