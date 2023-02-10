package com.leeyangy.dao;

import com.leeyangy.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * @author LEEYANGY
 *用户持久层操作
 */
public interface IUserDao {
    /**
     *查询所有操作
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
//此处创建的操作需要映射到Resource目录下的 同当前结构目录的IUserDao.xml内