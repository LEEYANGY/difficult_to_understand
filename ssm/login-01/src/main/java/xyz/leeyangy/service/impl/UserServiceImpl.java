package xyz.leeyangy.service.impl;

import org.springframework.stereotype.Service;
import xyz.leeyangy.dao.UserMapper;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.service.UserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
//    登录接口实现
    public User login(User user) {
        return userMapper.login(user);
    }
}
