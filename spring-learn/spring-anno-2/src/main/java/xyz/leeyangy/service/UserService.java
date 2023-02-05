package xyz.leeyangy.service;

import xyz.leeyangy.domain.User;

import java.util.Collection;

/**
 * @Package: xyz.leeyangy.service
 * @Author: LEEYANGYANG
 * @Create: 2022/10/24 16:48
 * @Description:
 */
public interface UserService {

//    查询所有用户
    Collection<User> findAll();
}
