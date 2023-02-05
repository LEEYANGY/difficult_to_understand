package xyz.leeyangy.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import xyz.leeyangy.dao.BookDao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Package: xyz.leeyangy.dao.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/9 18:13
 * @Description:
 */
@Repository("bookDao2")
//设置单例/多例  默认单例 singleton
@Scope("singleton")
//@Scope("prototype")
public class BookDaoImpl2 implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao save...2 ");
    }
}
