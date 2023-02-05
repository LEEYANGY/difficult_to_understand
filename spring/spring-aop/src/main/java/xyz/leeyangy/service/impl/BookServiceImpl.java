package xyz.leeyangy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import xyz.leeyangy.dao.BookDao;
import xyz.leeyangy.service.BookService;

/**
 * @Package: xyz.leeyangy.service.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/8 20:41
 * @Description:
 */
@Service
public class BookServiceImpl implements BookService {
//    配置自动装配(默认是按类型装配) 无需提供setter
    @Autowired
//    如果有多个bean,则添加@Qualifier手动写入
    @Qualifier("bookDao")
    private BookDao bookDao;

    public void save() {
        System.out.println("----------Book service save---------");
        bookDao.save();
    }


}
