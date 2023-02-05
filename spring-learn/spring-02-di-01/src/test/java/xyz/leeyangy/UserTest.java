package xyz.leeyangy;


import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.leeyangy.domain.User;
import xyz.leeyangy.service.UserService;

import java.util.List;

/**
 * @Package: xyz.leeyangy
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 18:01
 * @Description:
 */
public class UserTest {

//    @Autowired
    private static UserService userService;

    @Test
    void testFindAllUser(){

//        get ioc container
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationCtx.xml");
        userService =(UserService) ctx.getBean("userService");
        List<User> list = userService.findAllUser();
        for (User user:list){
            System.out.println(user);
        }
        System.out.println("------------------");
        boolean checkAddUser = userService.checkAddUser(new User(1006, "挂科难"));
        System.out.println(checkAddUser);
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationCtx.xml");
        userService =(UserService) ctx.getBean("userService");
        List<User> list = userService.findAllUser();
        for (User user:list){
            System.out.println(user);
        }
        System.out.println("------------------");
        boolean checkAddUser = userService.checkAddUser(new User(1006, "挂科难"));
        System.out.println(checkAddUser);
    }


}
