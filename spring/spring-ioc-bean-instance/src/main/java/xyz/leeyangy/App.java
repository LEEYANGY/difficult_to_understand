package xyz.leeyangy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.leeyangy.dao.BookDao;
import xyz.leeyangy.service.BookService;
import xyz.leeyangy.service.impl.BookServiceImpl;

/**
 * @Package: xyz.leeyangy
 * @Author: LEEYANGYANG
 * @Create: 2022/10/8 20:46
 * @Description:
 */
public class App {
    public static void main(String[] args) {
//        获取ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        获取bean
//        BookDao bookDao = (BookDao) context.getBean("bookDao");
//        bookDao.save();
//        获取bean
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.save();
    }
}
