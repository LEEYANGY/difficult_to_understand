package xyz.leeyangy.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.leeyangy.dao.OrderDao;
import xyz.leeyangy.factory.OrderDaoFactory;

/**
 * @Package: xyz.leeyangy
 * @Author: LEEYANGYANG
 * @Create: 2022/10/9 0:16
 * @Description:
 */
public class AppForInstanceOrder {
//    通过静态工厂创建对象
    @Test
    public void testOrder(){
//        OrderDao orderDao= OrderDaoFactory.getOrderDao();
//        orderDao.save();
        //   获取ioc容器
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderDao orderDao =(OrderDao) context.getBean("orderBean");
        orderDao.save();
    }
}
