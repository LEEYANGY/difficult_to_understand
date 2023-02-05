package xyz.leeyangy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.leeyangy.dao.AccountDao;
import xyz.leeyangy.domain.Account;
import xyz.leeyangy.service.AccountService;

import java.util.List;

/**
 * @Package: xyz.leeyangy.service.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/10 0:21
 * @Description:
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    //    新增用户
    @Override
    public int addUser(Account account) {
        return accountDao.addUser(account);
    }

    @Override
    public int updateById(Account account) {
        return accountDao.updateById(account);
    }

    @Override
    public int deleteUserById(Integer ids) {
        return accountDao.deleteUserById(ids);
    }

    @Override
    public Account findById(Integer ids) {
        return accountDao.findById(ids);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
