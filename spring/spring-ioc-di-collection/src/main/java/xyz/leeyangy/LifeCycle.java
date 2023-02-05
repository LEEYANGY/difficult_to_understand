package xyz.leeyangy;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.leeyangy.dao.BookDao;
import xyz.leeyangy.dao.impl.BookDaoImpl;
import xyz.leeyangy.service.BookService;

/**
 * @Package: xyz.leeyangy
 * @Author: LEEYANGYANG
 * @Create: 2022/10/9 11:38
 * @Description:
 */
public class LifeCycle {
    @Test
    public void testLifeCycleForBookServiceImpl(){
        //    获取ioc容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.registerShutdownHook();
        BookDao bookDao=(BookDao) context.getBean("bookDao");
        bookDao.save();
    }

}
