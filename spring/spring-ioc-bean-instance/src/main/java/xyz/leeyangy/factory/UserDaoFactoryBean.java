package xyz.leeyangy.factory;

import org.springframework.beans.factory.FactoryBean;
import xyz.leeyangy.dao.UserDao;
import xyz.leeyangy.dao.impl.UserDaoImpl;

/**
 * @Package: xyz.leeyangy.factory
 * @Author: LEEYANGYANG
 * @Create: 2022/10/9 0:14
 * @Description:
 */
public class UserDaoFactoryBean implements FactoryBean<UserDao> {
//    代替原始实例工厂创建对象的方法
    @Override
    public UserDao getObject() throws Exception {
        return new UserDaoImpl();
    }


    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }
}
