package xyz.leeyangy;

import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.leeyangy.domain.User;

/**
 * @Package: xyz.leeyangy
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 13:11
 * @Description:
 */
public class UserDITest {

    @Test
    void testGetUser(){
//        创建ioc容器
        ApplicationContext cpx = new ClassPathXmlApplicationContext("applicationCtx.xml");
//        获取bean
        User user = (User) cpx.getBean(User.class);
        System.out.println(user);
    }

}
