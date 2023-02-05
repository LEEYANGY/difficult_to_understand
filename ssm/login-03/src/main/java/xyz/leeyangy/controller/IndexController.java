package xyz.leeyangy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
public class IndexController {

    @RequestMapping
    public String index(){
        System.out.println("---- 访问首页 ----");
        return "login";
    }
//    @RequestMapping("/login")
//    public String login(){
//        System.out.println("---- 转发登录 ----");
//        return "login";
//    }
}
