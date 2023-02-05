package xyz.leeyangy.dao;

import org.apache.ibatis.annotations.Select;
import xyz.leeyangy.domain.Account;

import java.util.List;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 19:08
 * @Description:
 */
public interface AccountDao {
    //    查询所有
    @Select("select * from t_account")
    List<Account> findAllUser();
}
