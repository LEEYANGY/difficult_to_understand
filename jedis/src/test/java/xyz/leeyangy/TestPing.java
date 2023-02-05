package xyz.leeyangy;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class TestPing {

    @Test
    public void testPing() {
//        1.newjedis对象
        Jedis jedis = new Jedis("localhost", 6379);
//        2.jedis命令
        System.out.println(jedis.ping());
//        清空数据库
        System.out.println(jedis.flushAll());
        System.out.println(jedis.set("k1", "v11"));
        System.out.println(jedis.get("k1"));
    }
}
