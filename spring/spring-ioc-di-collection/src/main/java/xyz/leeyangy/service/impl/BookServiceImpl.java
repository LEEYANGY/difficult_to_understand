package xyz.leeyangy.service.impl;

import xyz.leeyangy.dao.BookDao;
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

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }

}
