package xyz.leeyangy;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.leeyangy.domain.User;
import xyz.leeyangy.service.UserService;

import java.util.List;

/**
 * @Package: xyz.leeyangy
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 18:01
 * @Description:
 */
//使用junit测试
@RunWith(SpringJUnit4ClassRunner.class)
//加载spring配置文件
@ContextConfiguration("classpath:applicationCtx.xml")
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void testFindAllUser() {
        System.out.println(userService.checkAddUser(new User(66,"洋")));
    }
}
