package xyz.leeyangy;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.leeyangy.dao.BookDao;

/**
 * @Package: xyz.leeyangy
 * @Author: LEEYANGYANG
 * @Create: 2022/10/8 22:08
 * @Description:
 */
public class AppForInstanceBook{
    @Test
    public void testSpring(){
        //   获取ioc容器
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        BookDao bookDao=(BookDao) context.getBean("bookDao");
//        bookDao.save();
    }

}
