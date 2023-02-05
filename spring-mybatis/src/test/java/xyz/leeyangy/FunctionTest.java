package xyz.leeyangy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.leeyangy.config.SpringConfig;
import xyz.leeyangy.domain.Account;
import xyz.leeyangy.service.AccountService;

import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class FunctionTest {

    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
//        获取ioc容器
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = ctx.getBean(AccountService.class);
        Account account = accountService.findById(1);
        System.out.println(account);
    }

    @Test
    public void testFindById(){
        System.out.println(accountService.findById(1));
    }

}

