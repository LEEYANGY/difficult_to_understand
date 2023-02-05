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
 * @Create: 2022/10/17 19:15
 * @Description:
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAllUser() {
        return accountDao.findAllUser();
    }
}
