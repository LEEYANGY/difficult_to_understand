package xyz.leeyangy.dao;

import xyz.leeyangy.domain.User;

import java.util.Collection;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/10/24 16:43
 * @Description:
 */
public interface UserDao {

//    查询所有用户
    Collection<User> findAll();
}
