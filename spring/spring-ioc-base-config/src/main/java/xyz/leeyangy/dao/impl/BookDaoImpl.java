package xyz.leeyangy.dao.impl;

import xyz.leeyangy.dao.BookDao;

/**
 * @Package: xyz.leeyangy.dao.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/8 20:40
 * @Description:
 */
public class BookDaoImpl implements BookDao {
//    bean默认使用无参构造方法（常用）
//    如果无参构造方法不存在，则抛出异常beanCreationException
    public BookDaoImpl(){
        System.out.println("book dao constructor is running ...");
    }
    public void save(){
        System.out.println("book dao save");
    }
}
