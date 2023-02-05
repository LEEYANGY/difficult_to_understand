package xyz.leeyangy.dao.impl;

import org.springframework.stereotype.Component;
import xyz.leeyangy.dao.BookDao;

/**
 * @Package: xyz.leeyangy.dao.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/9 18:13
 * @Description:
 */
@Component("bookDao")
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao save... ");
    }
}
