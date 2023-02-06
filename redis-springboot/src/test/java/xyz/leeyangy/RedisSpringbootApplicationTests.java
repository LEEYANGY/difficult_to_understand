package xyz.leeyangy;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.data.redis.connection.RedisConnection;

import org.springframework.data.redis.core.RedisTemplate;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.utils.RedisUtil;

import javax.annotation.Resource;

@SpringBootTest
class RedisSpringbootApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
//        redisTemplate
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        清空数据库
        connection.flushDb();
        redisTemplate.opsForValue().set("k1","v1");
        System.out.println(redisTemplate.opsForValue().get("k1"));
//        关闭连接
        connection.close();
    }


    /**
    * @Param: []
    * @return: void
    * @Author: liyangyang
    * @Date: 2023/2/7 5:06
    * @Description: 测试自己编写的redisTemplate类是否正常
    */
    @Test
    public void testTemplate() throws JsonProcessingException {
        User user = new User("我是谁啊？我的天呐", 20);
//        String json = new ObjectMapper().writeValueAsString(user);
//        redisTemplate.opsForValue().set("user",json);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Resource
    private RedisUtil redisUtil;
    /**
    * @Param: []
    * @return: void
    * @Author: liyangyang
    * @Date: 2023/2/7 5:07
    * @Description: 测试自己编写的redisUtil是否正常
    */
    @Test
    public void testRedisUtil(){
        redisUtil.del("k");
//        redisUtil.set("k","my redisutil");
        System.out.println(redisUtil.get("k"));
    }

}
