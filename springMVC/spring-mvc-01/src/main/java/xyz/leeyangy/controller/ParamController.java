package xyz.leeyangy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @Package: xyz.leeyangy.controller
 * @Author: LEEYANGYANG
 * @Create: 2022/10/21 1:55
 * @Description:
 */
@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
//    形参位置的request表示当前请求
    public String testServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username=" + username + " password=" + password);
        return "success";
    }

//    @RequestMapping("/testParams")
//    public String testParam(String username, String password) {
//        System.out.println("username=" + username + " password=" + password);
//        return "success";
//    }

//    name=username ==> String username  name值对应形参
//    @RequestMapping("/testParam")
//    public String testParam(String username, String password, String[] hobby) {
//        System.out.println("进来testParam");
//        System.out.println("username=" + username + " password=" + password + " hobby=" + Arrays.toString(hobby));
//        return "success";
//    }


    /**
     * @param username
     * @param password
     * @param hobby
     * @return
     * @RequestParam 请求参数和形参创建映射关系
     * 三个参数   value   require   defaultValue
     * 是前端页面表单中 name 的值，映射(类似起别名)
     * <p>
     * require默认值是 true 指定了改值必须要传输，否则报400
     * <p>
     * require 改为 false 指定了改值不必传输
     * <p>
     * defaultValue  是默认值，什么都不传来时候默认给值
     * @RequestHeader 请求头信息和控制方法形参创建创建映射关系
     * 该注解有三个属性：
     * value required defaultValue用法同RequestParam
     * @CookieValue 将cookie数据和控制器方法的形参创建映射关系
     * 该注解有三个属性：
     * value required defaultValue用法同RequestParam
     */
    @RequestMapping("/testParams")
    public String testParam(
            @RequestParam(value = "user_name", required = false, defaultValue = "null value") String username,
            @RequestParam(value = "passwd", required = true) String password,
            @RequestParam(value = "hob", required = false) String[] hobby,
            @RequestHeader(value = "hhh", required = true, defaultValue = "haha") String host,
            @CookieValue("JSESSIONID") String JSESSIONID) {
        System.out.println("进来testParam");
        System.out.println("username=" + username + " password=" + password + " hobby=" + Arrays.toString(hobby));
        System.out.println("RequestHeader info:\n" + "Host=" + host);
        System.out.println("JSESSIONID=" + JSESSIONID);
        return "success";
    }


}
