package xyz.leeyangy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.respone.ResponseResult;
import xyz.leeyangy.service.LoginService;

/**
 * @Author liyangyang
 * @Date: 2023/02/24 12:47
 * @Package xyz.leeyangy.controller
 * @Version 1.0
 * @Description:
 */

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
//        System.out.println("user:"+user);
        return loginService.login(user);
    }

    @RequestMapping("/user/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }

}
