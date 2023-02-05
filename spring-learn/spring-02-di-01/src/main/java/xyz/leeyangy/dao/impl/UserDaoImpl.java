package xyz.leeyangy.dao.impl;

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
//@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAllUser() {
        List<User> list=new ArrayList<>();
        list.add(new User(1001,"李洋洋"));
        list.add(new User(1002,"李大洋"));
        list.add(new User(1003,"李海洋"));
        list.add(new User(1004,"李小洋"));
        list.add(new User(1005,"李洋"));
//        for (User user:list) {
//            System.out.println(user);
//        }
        return list;
    }

    @Override
    public int addUser(User user) {
        System.out.println("---- 添加成功 ----");
        return 1;
    }
}
