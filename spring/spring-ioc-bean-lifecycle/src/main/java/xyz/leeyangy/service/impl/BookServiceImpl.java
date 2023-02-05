package xyz.leeyangy.service.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import xyz.leeyangy.dao.BookDao;
import xyz.leeyangy.dao.impl.BookDaoImpl;
import xyz.leeyangy.service.BookService;

/**
 * @Package: xyz.leeyangy.service.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/8 20:41
 * @Description:
 */
public class BookServiceImpl implements BookService, InitializingBean, DisposableBean {

    private BookDao bookDao;

    public BookDao getBookDao() {
        System.out.println("get ....");
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        System.out.println("set ....");
        this.bookDao = bookDao;
    }

    @Override
    public void save() {
        System.out.println("book service save ...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("service destroy...");
    }

//    在属性启动之后
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("service init");
    }
}
