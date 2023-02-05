package xyz.leeyangy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.leeyangy.dao.UserDao;
import xyz.leeyangy.domain.User;
import xyz.leeyangy.service.UserService;

import java.util.List;

/**
 * @Package: xyz.leeyangy.service.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 18:11
 * @Description:
 */
//@Service("userService")
public class UserServiceImpl implements UserService {

//    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAllUser() {
        List<User> list=userDao.findAllUser();
        return list;
    }

//    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean checkAddUser(User user) {
        int total=userDao.addUser(user);
        if(total>0){
            return true;
        }else {
            return false;
        }
    }
}
