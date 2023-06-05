package xyz.leeyangy.school.modular.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import xyz.leeyangy.school.modular.system.entity.User;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
public interface UserMapper extends BaseMapper<User> {

    /***
    * @Param: [user]
    * @return: java.util.List<org.dragonwings.school.modular.system.entity.User>
    * @Author: liyangyang
    * @Date: 2023/5/10 3:08
    * @Description: 管理员登录
    */
    List<User> adminLogin(User user);

}