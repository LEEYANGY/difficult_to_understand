package xyz.leeyangy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.leeyangy.domain.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Package: xyz.leeyangy.controller
 * @Author: LEEYANGYANG
 * @Create: 2022/10/24 21:21
 * @Description:
 */
@Controller
public class HttpController {

//    获取请求体
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody="+requestBody);
        return "success";
    }

//    获取请求实体
    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        System.out.println("requestHeader="+requestEntity.getHeaders());
        System.out.println("requestBody"+requestEntity.getBody());
        return "success";
    }

//    servlet原生API
    @RequestMapping("/testResponse")
    public void testRespone(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello,response");
    }

//    SpringMVC API
    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success?";
    }

    /**
     *  springMVC的核心配置文件中开启mvc注解驱动
     *  此时HandleAdaptor中回自动装配一个消息转换器：MappingJackson2HttpMessageConverter
     *  响应到浏览器的java对象转换为json格式字符串
     *
     *
     * @return User
     */
    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        HttpStatus statusCode=HttpStatus.OK;
        return new User(statusCode,"admin","admin","男","22","foxmail.com");
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAjax(String username, String password){
        System.out.println("username:"+username+",password:"+password);
        return "hello,ajax";
    }

}
