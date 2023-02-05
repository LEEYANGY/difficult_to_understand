package xyz.leeyangy.service.impl;

import lombok.Data;
import xyz.leeyangy.dao.BookDao;
import xyz.leeyangy.dao.UserDao;
import xyz.leeyangy.service.BookService;

/**
 * @Package: xyz.leeyangy.service.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/8 20:41
 * @Description:
 */
//@Data
public class BookServiceImpl implements BookService {

    private BookDao bookDao;
    private UserDao userDao;

//    构造器注入
    public BookServiceImpl(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
        userDao.save();
    }

}
