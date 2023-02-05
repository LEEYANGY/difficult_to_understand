package xyz.leeyangy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.service.UserService;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//加载spring配置文件
@ContextConfiguration("classpath:spring-config.xml")
public class UserMapperTest {

    @Resource
    private UserService userService;

    //    登录接口测试
    @Test
    public void testLogin(){
//        new对象
        User user=new User();
        user.setName("");
        user.setPassword("2222");
//        执行功能
        User user1 = userService.login(user);
        System.out.println(user1);
    }
}
