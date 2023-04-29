package org.dragonwings;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class StudentApplicationTest {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

//    @Resource


    @Resource
    private DataSource dataSource;


    @Test
    void testMysql() throws SQLException {
        System.out.println(dataSource);
        System.out.println(dataSource.getConnection());
    }

    @Test
    void testGetEncodePassword(){
        String pass = "123321456";
//        redisTemplate.ge
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String passHas = encoder.encode(pass);
        System.out.println(passHas);
    }

}
