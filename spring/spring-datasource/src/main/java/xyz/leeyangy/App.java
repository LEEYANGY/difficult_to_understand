package xyz.leeyangy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.leeyangy.dao.BookDao;

import javax.sql.DataSource;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//        DataSource dataSource1=(DataSource) context.getBean("dataSourceForDruid");
//        DataSource dataSource2=(DataSource) context.getBean("dataSourceForC3p0");
//        System.out.println(dataSource1);
//        System.out.println(dataSource2);
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//        DataSource dataSource=(DataSource) context.getBean("dataSource");
//        System.out.println(dataSource);
        BookDao bookDao=(BookDao) context.getBean("bookDao");
        bookDao.save();
    }
}
