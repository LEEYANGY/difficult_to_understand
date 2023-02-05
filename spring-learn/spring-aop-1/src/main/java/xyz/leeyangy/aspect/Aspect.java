package xyz.leeyangy.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import xyz.leeyangy.domain.User;

/**
 * @Package: xyz.leeyangy.aspect
 * @Author: LEEYANGYANG
 * @Create: 2022/10/24 19:26
 * @Description:
 */
@Slf4j
public class Aspect {
    //    前置增强
    /**
     * 通过连接点拿到目标方法以及形参
     * @param joinPoint
     */
    public void beforeLog(JoinPoint joinPoint){
        log.info("获取目标类："+joinPoint.getThis());
//        log.info("getSignature:"+joinPoint.getSignature());
        log.info("获取目标方法："+joinPoint.getSignature().getName());
//        log.info("获取形参："+joinPoint.getArgs()[0]);
        if(joinPoint.getArgs().length>0){
            User user = (User) joinPoint.getArgs()[0];
            user.setId(666);
            user.setName("不是洋");
            log.info("目标方法形参："+user);
        }

    }
    //    后置增强
    public void afterLog(JoinPoint joinPoint,Object res){
        log.info(joinPoint.getThis()+"类的"+joinPoint.getSignature().getName()+"方法执行完毕");
        log.info(joinPoint.getSignature().getName()+"方法的返回值是:"+res);
    }
}
