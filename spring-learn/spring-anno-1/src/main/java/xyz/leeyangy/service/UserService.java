package xyz.leeyangy.service;

import xyz.leeyangy.domain.User;

import java.util.Collection;

/**
 * @Package: xyz.leeyangy.service
 * @Author: LEEYANGYANG
 * @Create: 2022/10/24 16:34
 * @Description:
 */
public interface UserService {
//    获取所有用户信息
    Collection<User> findAll();
}
