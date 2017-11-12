package com.test.first.controller;


import com.test.first.config.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liuning on 2017/9/18.
 */
@Controller
public class FirstController {

    @RequestMapping("/freemarker")
    public String index(Model model){
        model.addAttribute("liuning","我的家在长治！");
        return "freemarker";
    }

    @RequestMapping("/excep")
    public String exce() throws Exception {
        throw new Exception("发生错误！");
    }

    @RequestMapping("/json")
    public String jsonexception() throws MyException {
        throw new MyException("json发生错误！");
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
