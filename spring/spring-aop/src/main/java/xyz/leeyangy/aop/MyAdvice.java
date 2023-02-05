package xyz.leeyangy.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Package: xyz.leeyangy.aop
 * @Author: LEEYANGYANG
 * @Create: 2022/10/11 20:35
 * @Description:
 */
@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(void xyz.leeyangy.dao.BookDao.update())")
    private void pt(){
        System.out.println("pt...");
    }

    @Before("pt()")
    public void method(){
        System.out.println(System.currentTimeMillis());
    }
}
