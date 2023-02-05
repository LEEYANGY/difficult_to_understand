package xyz.leeyangy.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import xyz.leeyangy.dao.UserDao;
import xyz.leeyangy.domain.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Package: xyz.leeyangy.dao.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/24 16:30
 * @Description:
 */
@Repository("userDao")
@Slf4j
public class UserDaoImpl implements UserDao {


    @Override
    public Collection<User> findAll() {
        log.info("使用了collection，手动赋值");
        Collection<User> collectionUser=new ArrayList<>();
        collectionUser.add(new User(1,""));
        collectionUser.add(new User(2,"李洋"));
        collectionUser.add(new User(3,"李"));
        return collectionUser;
    }
}
