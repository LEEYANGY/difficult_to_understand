package xyz.leeyangy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.leeyangy.dao.UserDao;
import xyz.leeyangy.domain.User;

import java.util.Collection;

/**
 * @Package: xyz.leeyangy.service
 * @Author: LEEYANGYANG
 * @Create: 2022/10/24 16:49
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
