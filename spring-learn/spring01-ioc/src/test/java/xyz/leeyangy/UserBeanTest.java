package xyz.leeyangy;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.leeyangy.pojo.User;

/**
 * Unit test for simple App.
 */
public class UserBeanTest extends TestCase {

    //    测试获取bean对象
    @Test
    public void testGetBean() {
        //        获取ioc容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) ctx.getBean("user");
        System.out.println(user);
    }
}
