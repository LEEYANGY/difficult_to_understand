package org.dragonwings.school.modular.system.mapper;

import org.dragonwings.school.modular.system.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

//    查询用户的所有权限
    List<String> selectPermsByUserId(Long userId);

}
