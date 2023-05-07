package org.dragonwings;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * Unit test for simple App.
 */
@SpringBootTest
@MapperScan("org.dragonwings.school.modular.system.mapper")
public class StudentApplicationTest {

//    @Resource
//    private RedisTemplate<String,String> redisTemplate;

//    @Resource

//
//    @Resource
//    private DataSource dataSource;
//
//
//    @Test
//    void testMysql() throws SQLException {
//        System.out.println(dataSource);
//        System.out.println(dataSource.getConnection());
//    }
//
//    @Test
//    void testGetEncodePassword(){
//        String pass = "20223035104";
////        redisTemplate.ge
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        final String passHas = encoder.encode(pass);
//        System.out.println(passHas);
//    }


//    @Resource
//    private ChatsService chatsService;
//
//    @Test
//    public void testGetContentByGid() {
//        Chats chats = chatsService.findChatContentByGid(10000000L);
//        System.out.println(chats);
//    }

}
