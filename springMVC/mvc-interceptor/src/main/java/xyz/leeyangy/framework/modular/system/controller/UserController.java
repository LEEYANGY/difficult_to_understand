package xyz.leeyangy.framework.modular.system.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xyz.leeyangy.framework.modular.system.entity.User;
import xyz.leeyangy.framework.respone.ResponseData;
import xyz.leeyangy.framework.security.jwt.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Package: xyz.leeyangy.controller
 * @Author: LEEYANGYANG
 * @Create: 2022/10/31 19:11
 * @Description:
 */
@RestController
public class UserController {

    private final static String USERNAME = "admin";
    private final static String PASSWORD = "admin";

    String token;

//    @GetMapping
//    public String index(){
//        return "index";
//    }

    @PostMapping("/user/login")
    public ResponseData login(@RequestBody User user, HttpServletResponse response) {
//        判断密码
        if (USERNAME.equals(user.getUsername()) && PASSWORD.equals(user.getPassword())) {
            System.out.println("密码正确，正在创建token。。。");
            token = JwtUtil.createToken(user);
            response.setHeader("token",token);
            return ResponseData.success(200,"登录成功",token);
        } else {
            System.out.println("密码错误");
            return ResponseData.error(token);
        }
    }
    @GetMapping("/user/sumPages")
    public String inter(HttpServletResponse response) {
        return "/sumPages";
    }


    @PostMapping("/checkToken")
    @ResponseBody
    public String checkToken(User user, HttpServletRequest request){
       token = request.getHeader("token");
        System.out.println(token);
        if (JwtUtil.checkToken(token)){
            System.out.println("验证成功");
            return "认证成功";
        }else {
            System.out.println("验证失败，重新登录");
            return "认证失败,请重新登陆!";
        }

    }

}