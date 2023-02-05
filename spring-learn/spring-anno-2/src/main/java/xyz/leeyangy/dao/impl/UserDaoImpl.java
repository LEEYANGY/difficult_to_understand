package xyz.leeyangy.dao.impl;

import org.springframework.stereotype.Repository;
import xyz.leeyangy.dao.UserDao;
import xyz.leeyangy.domain.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Package: xyz.leeyangy.dao.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/24 16:48
 * @Description:
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public Collection<User> findAll() {
        List<User> listUser=new ArrayList<>();
        listUser.add(new User(1,"李"));
        listUser.add(new User(2,"李洋"));
        listUser.add(new User(3,""));
        return listUser;
    }
}
