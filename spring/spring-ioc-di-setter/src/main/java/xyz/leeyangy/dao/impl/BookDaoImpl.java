package xyz.leeyangy.dao.impl;

import xyz.leeyangy.dao.BookDao;

/**
 * @Package: xyz.leeyangy.dao.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/8 20:40
 * @Description:
 */
public class BookDaoImpl implements BookDao {
    public void save(){
        System.out.println("book dao save"+","+databaseName+","+connectionNum);
    }

    public int connectionNum;
    private String databaseName;

    public void setConnectionNum(int connectionNum) {
        this.connectionNum = connectionNum;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    //    public void init(){
//        System.out.println("init...");
//    }
//    public void destroy(){
//        System.out.println("destroy...");
//    }
}
