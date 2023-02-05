package xyz.leeyangy.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import xyz.leeyangy.dao.UserDao;
import xyz.leeyangy.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.leeyangy.dao.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/24 17:00
 * @Description:
 */
@Repository("userDao")
@Slf4j
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> findAll() {

        List<User> list=new ArrayList<>();
        list.add(new User(1,"testUser1"));
        list.add(new User(2,"testUser2"));
        list.add(new User(3,"testUser3"));
        list.add(new User(4,"testUser4"));
        list.add(new User(5,"testUser5"));
        list.add(new User(6,"testUser6"));
        list.add(new User(7,"testUser7"));
        return list;
    }
}
