package xyz.leeyangy.service;

import xyz.leeyangy.domain.Account;

import java.util.List;

/**
 * @Package: xyz.leeyangy.service.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/10 0:21
 * @Description:
 */
public interface AccountService {
    //    新增用户
    int addUser(Account account);

    //    更新用户
    int updateById(Account account);

    //    删除用户
    int deleteUserById(Integer ids);

    //    通过id查找用户
    Account findById(Integer ids);

    //    查询所有用户
    List<Account> findAll();
}
