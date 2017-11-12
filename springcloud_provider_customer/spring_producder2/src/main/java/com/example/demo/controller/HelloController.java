package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuning on 2017/10/10.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(@RequestParam String name){
        return "你好"+name;
    }
}
