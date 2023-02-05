package xyz.leeyangy.service;

import xyz.leeyangy.domain.Account;

import java.util.List;

/**
 * @Package: xyz.leeyangy.service
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 19:15
 * @Description:
 */
public interface AccountService {
    //    查询所有
    List<Account> findAllUser();
}
