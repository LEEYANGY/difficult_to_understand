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
 * @Create: 2022/10/24 16:36
 * @Description:
 */
//使用junit测试
@RunWith(SpringJUnit4ClassRunner.class)
//加载spring配置文件
@ContextConfiguration("classpath:applicationCtx.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        System.out.println(userService.findAll());
//        使用lambda表达式
        Collection<User> collection=userService.findAll();
        collection.forEach(user -> System.out.println(user));
    }

}
