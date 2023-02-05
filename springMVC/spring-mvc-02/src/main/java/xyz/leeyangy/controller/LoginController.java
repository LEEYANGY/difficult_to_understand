package xyz.leeyangy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.leeyangy.domain.User;

/**
 * @Package: xyz.leeyangy.controller
 * @Author: LEEYANGYANG
 * @Create: 2022/10/21 15:31
 * @Description:
 */
@Controller
public class LoginController {

//    @RequestMapping("/testPOJO")
//    public String login(@RequestParam(value = "user_name", defaultValue = "null") String username,
//                        @RequestParam(value = "passwd", defaultValue = "null") String password,
//                        @RequestParam(value = "sex", defaultValue = "null") String sex,
//                        @RequestParam(value = "age", defaultValue = "0") String age,
//                        @RequestParam(value = "email", defaultValue = "null") String email,
//                        @CookieValue(value = "JSESSIONID") String JSESSIONID) {
//        System.out.println("The people info: " +
//                " username=" + username +
//                " password=" + password +
//                " sex=" + sex +
//                " age=" + age +
//                " email=" + email
//        );
//        System.out.println("JSESSIONID=" + JSESSIONID);
//        return "success";
//    }

    @RequestMapping("/testPOJO")
    public String login(User user, @CookieValue(value = "JSESSIONID") String JSESSIONID) {
        System.out.println(user);
        System.out.println("JSESSIONID=" + JSESSIONID);
        return "success";
    }

}
