package xyz.leeyangy;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.leeyangy.config.SpringConfig;
import xyz.leeyangy.dao.BookDao;

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
        BookDao bookDao1=ctx.getBean(BookDao.class);
        BookDao bookDao2=ctx.getBean(BookDao.class);
        System.out.println(bookDao1);
        System.out.println(bookDao2);
//        销毁程序
        ctx.close();
    }
}
