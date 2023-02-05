package xyz.leeyangy;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.leeyangy.config.SpringConfig;
import xyz.leeyangy.dao.BookDao;
import xyz.leeyangy.dao.impl.BookDaoImpl;
import xyz.leeyangy.service.BookService;

/**
 * @Package: xyz.leeyangy
 * @Author: LEEYANGYANG
 * @Create: 2022/10/9 20:59
 * @Description:
 */
public class AppForAnnotation {
    @Test
    public void testAnnotation() {
//        加载ioc容器
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//        BookDao bd=(BookDao) ctx.getBean(BookDaoImpl.class);
//        bd.save();
        BookService bookService=(BookService) ctx.getBean(BookService.class);
        bookService.save();
    }
}
