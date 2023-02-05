package xyz.leeyangy.service.impl;

import xyz.leeyangy.dao.BookDao;
import xyz.leeyangy.dao.impl.BookDaoImpl;
import xyz.leeyangy.service.BookService;

/**
 * @Package: xyz.leeyangy.service.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/8 20:41
 * @Description:
 */
public class BookServiceImpl implements BookService {
//    删除业务层使用new方法创建的Dao对象
//    private BookDao bookDao = new BookDaoImpl() ;
    private BookDao bookDao;

    public BookDao getBookDao() {
        return bookDao;
    }

//    提供对应的set方法
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("----------Book service save---------");
        bookDao.save();
    }


}
