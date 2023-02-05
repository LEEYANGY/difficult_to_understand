package xyz.leeyangy;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.leeyangy.dao.UserDao;
import xyz.leeyangy.domain.User;

import java.util.List;

/**
 * @Package: xyz.leeyangy
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 18:56
 * @Description:
 */
public class UserTest {
//    声明接口
    private UserDao userDao;

    @Test
    void testGetUser() {
//        获取ioc容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationCtx.xml");
//        获取bean
        userDao = (UserDao) ctx.getBean("user");
//        执行功能
        List<User> allUser = userDao.findAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
    }
}
