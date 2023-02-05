package xyz.leeyangy.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
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
@Repository("bookDao")
public class BookDaoImpl implements BookDao {
//    简单数据类型注入
//    @Value("leeyangy")
    @Value("${jdbc.driver}")
    private String name;
    @Override
    public void save() {
        System.out.println("book dao save... 1  "+name);
    }
}
