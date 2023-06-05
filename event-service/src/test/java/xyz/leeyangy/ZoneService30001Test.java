package xyz.leeyangy;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.leeyangy.school.modular.system.entity.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@MapperScan("org.dragonwings.school.modular.system.mapper")
public class ZoneService30001Test {

    @Resource
    UserService userService;

    @Test
    void test() {
        List<User> list = userService.list();
        list.forEach(System.out::println);
    }
}
