package xyz.leeyangy.factory;

import xyz.leeyangy.dao.UserDao;
import xyz.leeyangy.dao.impl.UserDaoImpl;

/**
 * @Package: xyz.leeyangy.factory
 * @Author: LEEYANGYANG
 * @Create: 2022/10/9 0:14
 * @Description:
 */
public class UserDaoFactory {
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
