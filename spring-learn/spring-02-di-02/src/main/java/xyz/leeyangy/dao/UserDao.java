package xyz.leeyangy.dao;

import xyz.leeyangy.domain.User;

import java.util.List;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 18:54
 * @Description:
 */
public interface UserDao {
//    查询所有
    List<User> findAllUser();
}
