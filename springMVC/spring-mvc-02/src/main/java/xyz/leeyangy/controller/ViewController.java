package xyz.leeyangy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package: xyz.leeyangy.controller
 * @Author: LEEYANGYANG
 * @Create: 2022/10/21 22:00
 * @Description:
 */
@Controller
public class ViewController {

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        System.out.println("--- testThymeleafView ---");
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward(){
        System.out.println("--- forward ---");
        return "forward:/testThymeleafView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("--- Redirect ---");
        return "redirect:/testThymeleafView";
    }

    /**
     *
     *  转发请求：（一次请求）
     *          第一次由浏览器，第二次是发送在内部服务器 （转发后的请求还是同一个request）
     *  重定向请求：
     *          第一次由servlet，第二次访问重定向地址（两次请求对应两个request/两次请求）
     *
     *      web-inf下的资源具有安全性，不允许重定向访问，只能通过服务器内部访问，不能通过浏览器访问
     *
     *      转发不能跨域(只能访问服务器内部资源)，重定向可以跨域(通过浏览器可以访问任意网络资源)
     *
     */
}
