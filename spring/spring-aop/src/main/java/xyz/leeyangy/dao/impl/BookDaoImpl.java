package xyz.leeyangy.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import xyz.leeyangy.dao.BookDao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Package: xyz.leeyangy.dao.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/9 18:13
 * @Description:
 */
@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        //    记录当前执行的系统时间
//        Long startTime=System.currentTimeMillis();

//    执行万次操作
//        for(int i=0;i<10000;++i){
//            System.out.println("book dao save... "+i);
//        }
//        结束万次执行的当前时间
//        Long endTime=System.currentTimeMillis();
//        累计耗时
//        Long totalTime=endTime-startTime;
//        System.out.println("执行万次时间: "+totalTime+" ms");
        System.out.println(System.currentTimeMillis());
        System.out.println("book dao save ... ");
    }

    @Override
    public void delete() {
        System.out.println("book dao delete... ");
    }

    @Override
    public void update() {
        System.out.println("book dao update... ");
    }

    @Override
    public void select() {
        System.out.println("book dao select... ");
    }
}
