package xyz.leeyangy.dao;

import xyz.leeyangy.domain.User;

import java.util.List;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/10/24 17:00
 * @Description:
 */
public interface UserDao {

//    查询全部用户
    List<User> findAll();
}
