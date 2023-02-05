package xyz.leeyangy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.leeyangy.domain.User;
import xyz.leeyangy.service.UserService;

import java.util.Collection;

/**
 * @Package: xyz.leeyangy
 * @Author: LEEYANGYANG
 * @Create: 2022/10/24 16:52
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationCtx.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
//        遍历结果
        Collection<User> collection=userService.findAll();
        collection.forEach(user -> System.out.println(user));
    }

}
