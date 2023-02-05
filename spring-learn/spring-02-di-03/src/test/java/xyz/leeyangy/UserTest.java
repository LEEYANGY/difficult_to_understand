package xyz.leeyangy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.leeyangy.config.JdbcConfig;
import xyz.leeyangy.config.SpringConfig;
import xyz.leeyangy.domain.Account;
import xyz.leeyangy.service.AccountService;

import java.util.List;

/**
 * @Package: xyz.leeyangy
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 19:16
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserTest {
    @Autowired
    JdbcConfig jdbcConfig;
    @Autowired
    private AccountService accountService;

//    测试数据库连接
    @Test
    public void testConnectDB(){
        System.out.println(jdbcConfig);
    }

//    测试获取所有用户
    @Test
    public void testFindAllUser(){
        List<Account> list = accountService.findAllUser();
        for (Account account:list){
            System.out.println(account);
        }
    }
}
