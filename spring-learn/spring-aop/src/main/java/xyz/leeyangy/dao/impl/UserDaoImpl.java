package xyz.leeyangy.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import xyz.leeyangy.dao.UserDao;
import xyz.leeyangy.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.leeyangy.dao.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 17:57
 * @Description:
 */
@Repository("userDao")
@Slf4j
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAllUser() {
        List<User> list=new ArrayList<>();
        list.add(new User(1001,"666"));
        System.out.println("进到这里了userDaoImpl");
        return list;
    }

    @Override
    public int addUser(User user) {
        System.out.println("---- 添加成功 ----");
        return 1;
    }
}
