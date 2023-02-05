package xyz.leeyangy.service;

import xyz.leeyangy.domain.User;

import java.util.List;

/**
 * @Package: xyz.leeyangy.service
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 18:10
 * @Description:
 */
public interface UserService {
//    查询所有人
    List<User> findAllUser();
//    添加一个用户是否添加成功
    boolean checkAddUser(User user);
}
