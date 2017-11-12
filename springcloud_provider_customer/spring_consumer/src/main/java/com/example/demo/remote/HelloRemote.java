package com.example.demo.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by liuning on 2017/10/10.
 */
/*
* 设置fallback参数，当熔断时，返回去执行fallback的函数。
* */
@FeignClient(name ="spring-cloud-producer",fallback = HelloRemoteHeric.class)
public interface HelloRemote {

    /*name:表示远程服务名
    * 此类中的方法和远程服务中的controller中的方法名和参数需要保持一致
    * */
    @RequestMapping(value="/hello")
    public String hello(@RequestParam(value = "name") String name);
}
