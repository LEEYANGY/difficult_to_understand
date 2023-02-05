package xyz.leeyangy.dao.impl;

import xyz.leeyangy.dao.BookDao;

/**
 * @Package: xyz.leeyangy.dao.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/8 20:40
 * @Description:
 */
public class BookDaoImpl implements BookDao {

    public int connectionNum;
    private String databaseName;

//    构造器注入---简单数据类型
    public BookDaoImpl(int connectionNum, String databaseName) {
        this.connectionNum = connectionNum;
        this.databaseName = databaseName;
    }

    public void save(){
        System.out.println("book dao save"+","+databaseName+","+connectionNum);
    }
}
