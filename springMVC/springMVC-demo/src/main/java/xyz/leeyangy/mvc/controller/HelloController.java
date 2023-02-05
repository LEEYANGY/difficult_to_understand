package xyz.leeyangy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package: xyz.leeyangy.mvc.controller
 * @Author: LEEYANGYANG
 * @Create: 2022/10/16 0:33
 * @Description: kong'zhi'qi
 */
@Controller
public class HelloController {

    @RequestMapping
    public String index(){
        System.out.println("---- 默认index ----");
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        System.out.println("进入控制器");
        //返回视图名称
        return "login";
    }

    @RequestMapping("/success")
    public String success(){
        System.out.println("进入控制器");
        //返回视图名称
        return "success";
    }

    @RequestMapping("/fail")
    public String fail(){
        System.out.println("---- fail page ----");
        return "fail";
    }

}
