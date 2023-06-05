package xyz.leeyangy;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.leeyangy.school.modular.system.entity.User;
import xyz.leeyangy.school.modular.system.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@MapperScan("org.dragonwings.school.modular.system.mapper")
public class UserService8001Test {

    @Resource
    UserService userService;

    @Test
    void test() {
        List<User> list = userService.list();
        list.forEach(System.out::println);
    }
}
