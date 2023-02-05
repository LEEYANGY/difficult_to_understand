package xyz.leeyangy.dao.impl;

import xyz.leeyangy.dao.UserDao;
import xyz.leeyangy.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.leeyangy.dao.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 18:54
 * @Description:
 */
public class UserDaoImpl implements UserDao {

//    声明接口对象
    private UserDao userDao;

//    模拟数据库查询数据
    @Override
    public List<User> findAllUser() {
        List<User> list=new ArrayList<>();
        list.add(new User(1001,"李洋洋"));
        list.add(new User(1002,"李洋"));
        return list;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
