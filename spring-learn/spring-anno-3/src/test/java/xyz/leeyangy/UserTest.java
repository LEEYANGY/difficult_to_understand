package xyz.leeyangy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.leeyangy.domain.User;
import xyz.leeyangy.service.UserService;

/**
 * @Package: xyz.leeyangy
 * @Author: LEEYANGYANG
 * @Create: 2022/10/24 17:04
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationCtx.xml")
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
//        获取用户
        for (User user:
                userService.findAll()) {
            System.out.println(user);
        }
    }
}
