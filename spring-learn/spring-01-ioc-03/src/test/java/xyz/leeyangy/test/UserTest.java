package xyz.leeyangy.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.leeyangy.domain.User;

/**
 * @Package: xyz.leeyangy.test
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 16:35
 * @Description:
 */

public class UserTest {

    @Test
    void testUser() {
//        获取ioc容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationCtx.xml");
//        获取bean
        User user1 = (User) ctx.getBean("user1");
        System.out.println(user1);
        User user2 = (User) ctx.getBean("user2");
        System.out.println(user2);
        User user3 = (User) ctx.getBean("user3");
        System.out.println(user3);
        User user4 = (User) ctx.getBean("user4");
        System.out.println(user4);
    }
}
