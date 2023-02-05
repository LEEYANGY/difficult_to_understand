package xyz.leeyangy.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import xyz.leeyangy.domain.User;

/**
 * @Package: xyz.leeyangy.aspect
 * @Author: LEEYANGYANG
 * @Create: 2022/10/25 14:19
 * @Description:
 */
@Component
@Aspect
@Slf4j
public class MyAspect {

    //    定义切点，需要曾强的类/接口
    @Pointcut("execution(public * xyz.leeyangy.service.*.*(..))")
    public void pc() {

    }

    //    前置增强
    @Before("pc()")
    public void beforeLog(JoinPoint joinPoint) {
        long start = System.currentTimeMillis();
//        log.info("执行前置增强");
        System.out.println("当前的目标对象是：" + joinPoint.getThis());
        System.out.println("目标方法是：" + joinPoint.getSignature().getName());

        //获取目标方法的参数列表
        Object obj[] = joinPoint.getArgs();
        for (Object o : obj) {
            System.out.println("原参数:" + o);
        }
        if (joinPoint.getArgs().length > 0) {
            User user = (User) joinPoint.getArgs()[0];
            user.setId(1);
            user.setName("洋");
            log.info("修改后的目标方法形参：" + user);
        }

//        log.info("前置增强执行完毕时间" + (System.currentTimeMillis() - start) + "ms");
    }

    //    后置增强
    @AfterReturning(value = "pc()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
//        log.info("执行后置增强");
        System.out.println("后置增强获得的目标方法的返回结果是：" + result);
//        log.info("后置增强结束");
    }

    //    异常增强
    @AfterThrowing(value = "pc()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
//        log.info("异常增强开始");
        System.out.println("---------异常日志增强---------");
//        log.info("异常增强结束");
    }

    //    最终增强
    public void after(JoinPoint joinPoint) {
//        log.info("最终增强");
        System.out.println("---------最终日志增强---------");
    }

    //    环绕增强
    @Around(value = "pc()")
    public Object around(ProceedingJoinPoint joinPoint) {
//        System.out.println("----- 分割线 ----\n");
        Object result = null; //用于保存方法的返回值
        //获取目标方法名
        // joinPoint.getSignature().getName();
        //获取目标方法的参数列表
        //Object objs[]=joinPoint.getArgs();
        try {
            System.out.println("----循环增强中的前置增强-----");
            result = joinPoint.proceed();
            System.out.println("----循环增强中的后置增强----目标方法返回结果：" + result);
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("-----循环增强中的异常增强-----");
        }
        System.out.println("-----循环增强中的最终增强------");
//        log.info("---- 循环增强中的最终增强--结束 ----");
        return result;
    }

}
