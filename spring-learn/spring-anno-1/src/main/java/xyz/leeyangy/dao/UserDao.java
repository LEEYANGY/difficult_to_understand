package xyz.leeyangy.dao;

import xyz.leeyangy.domain.User;

import java.util.Collection;
import java.util.List;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/10/24 16:29
 * @Description:
 */
public interface UserDao {

//    获取所有用户
    Collection<User> findAll();
}
