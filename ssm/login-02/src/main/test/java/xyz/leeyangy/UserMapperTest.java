package xyz.leeyangy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.leeyangy.pojo.Department;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.service.DepartmentService;
import xyz.leeyangy.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//加载spring配置文件
@ContextConfiguration("classpath:spring-config.xml")
public class UserMapperTest {

    @Resource
    private UserService userService;

    @Resource
    private DepartmentService departmentService;
    //    登录接口测试
    @Test
    public void testLogin(){
//        new对象
        User user=new User();
        user.setName("李洋洋");
        user.setPassword("1111");
        user.setDid(1);
//        执行功能
        User user1 = userService.login(user);
        System.out.println(user1);

        List<Department> list = departmentService.findAllDepartment();
        for (Department department:list)
            System.out.println(department);

    }
}
