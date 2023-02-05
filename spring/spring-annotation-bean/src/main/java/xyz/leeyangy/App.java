package xyz.leeyangy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import xyz.leeyangy.dao.BookDao;
import xyz.leeyangy.service.BookService;

import javax.sql.DataSource;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao = (BookDao) context.getBean("bookDao");
        bookDao.save();
        BookService bookService=(BookService) context.getBean(BookService.class);
        bookService.save();
    }
}
