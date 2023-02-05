package xyz.leeyangy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Resource
    private UserService userService;

    //    login controller
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request,HttpSession session) {
        System.out.println("---- 登录 ----");
        User user2 = userService.login(user);
        if (user2!=null) {
            session.setAttribute("user2",user2);
            return "main";
        }else {
            request.setAttribute("msg","账号密码错误");
            return "login";
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        System.out.println("---- 注销登录 ----");
        session.invalidate();
        return "redirect:login";
    }
}
