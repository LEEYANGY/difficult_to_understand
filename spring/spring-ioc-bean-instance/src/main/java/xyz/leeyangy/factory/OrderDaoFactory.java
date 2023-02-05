package xyz.leeyangy.factory;

import xyz.leeyangy.dao.OrderDao;
import xyz.leeyangy.dao.impl.OrderDaoImpl;

/**
 * @Package: xyz.leeyangy.factory
 * @Author: LEEYANGYANG
 * @Create: 2022/10/9 0:14
 * @Description:
 */
public class OrderDaoFactory {
    public static OrderDao getOrderDao(){
        System.out.println("factory setup");
        return new OrderDaoImpl();
    }
}
