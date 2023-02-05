package xyz.leeyangy.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xyz.leeyangy.dao.UserDao;
import xyz.leeyangy.domain.User;
import xyz.leeyangy.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.leeyangy.service.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 18:11
 * @Description:
 */
@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {

//    根据UserDao.class类型注入
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAllUser() {
        System.out.println("userService:"+userDao);
        log.info("使用了slf4j");
        List<User> list=userDao.findAllUser();
        return list;
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
