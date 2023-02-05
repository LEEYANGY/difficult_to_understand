package xyz.leeyangy.service;

import xyz.leeyangy.domain.User;

import java.util.List;

/**
 * @Package: xyz.leeyangy.service
 * @Author: LEEYANGYANG
 * @Create: 2022/10/24 17:02
 * @Description:
 */
public interface UserService {
//    获取所有用户
    List<User> findAll();
}
