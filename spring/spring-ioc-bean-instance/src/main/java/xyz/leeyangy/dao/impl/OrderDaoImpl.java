package xyz.leeyangy.dao.impl;

import xyz.leeyangy.dao.OrderDao;

/**
 * @Package: xyz.leeyangy.dao.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/8 22:05
 * @Description:
 */
public class OrderDaoImpl implements OrderDao {
    @Override
    public void save() {
        System.out.println("order dao save");
    }
}
