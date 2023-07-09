package xyz.leeyangy.security_learn1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author liyangyang
 * @Date: 2023/07/10 3:09
 * @Package xyz.leeyangy.security_learn1.controller
 * @Version 1.0
 * @Description:
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
