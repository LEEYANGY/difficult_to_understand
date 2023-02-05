package xyz.leeyangy.dao.impl;

import xyz.leeyangy.dao.UserDao;

/**
 * @Package: xyz.leeyangy.dao.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/9 14:57
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("user dao save...");
    }
}
