package xyz.leeyangy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.leeyangy.domain.User;

/**
 * @Package: xyz.leeyangy.controller
 * @Author: LEEYANGYANG
 * @Create: 2022/10/21 23:26
 * @Description:
 */
@Controller
public class UserController {

    /**
     *
     * 使用RESTful 模拟用户资源的增删改查
     *  /users      GET     查询所有用户信息
     *  /user/1    GET     查询id=1的用户信息
     *  /user      POST    添加用户信息
     *  /user/1    DELETE  删除用户信息
     *  /user      PUT     修改用户信息
     */

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("--- 查询所有用户信息 ---");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(){
        System.out.println("--- 根据id查询用户信息 ---");
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String addUser(User user){
        System.out.println("--- 添加用户信息 ---");
        System.out.println(user);
        return "success";
    }

    @RequestMapping(value = "/usersss",method = RequestMethod.GET)
    public String deleteUserById(){
        System.out.println("--- 删除用户信息 ---");
        return "success";
    }

    @RequestMapping(value = "/userssss",method = RequestMethod.GET)
    public String updateUserById(){
        System.out.println("--- 更新用户信息 ---");
        return "success";
    }

}
