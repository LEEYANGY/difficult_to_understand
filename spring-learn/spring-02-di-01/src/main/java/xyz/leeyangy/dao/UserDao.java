package xyz.leeyangy.dao;

import xyz.leeyangy.domain.User;

import java.util.List;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 17:57
 * @Description:
 */
public interface UserDao {
//    查询所有用户
    List<User> findAllUser();

//    添加一个人
    int addUser(User user);
}
