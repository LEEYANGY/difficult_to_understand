package xyz.leeyangy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.leeyangy.dao.UserDao;
import xyz.leeyangy.domain.User;
import xyz.leeyangy.service.UserService;

import java.util.Collection;

/**
 * @Package: xyz.leeyangy.service.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/24 16:35
 * @Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Collection<User> findAll() {
        return userDao.findAll();
    }
}
