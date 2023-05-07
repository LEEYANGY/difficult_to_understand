package org.dragonwings.school.modular.system.mapper;

import org.apache.ibatis.annotations.Select;
import org.dragonwings.school.modular.system.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from sys_user where user_id=#{userId}")
    User findByUserId(Long userId);

}
