package xyz.leeyangy.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.leeyangy.model.system.SysRole;
import xyz.leeyangy.model.vo.AssginRoleVo;
import xyz.leeyangy.model.vo.SysRoleQueryVo;

import java.util.Map;

public interface SysRoleService extends IService<SysRole> {
    IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo roleQueryVo);

    /**
     * 根据用户获取角色数据
     * @param userId
     * @return
     */
    Map<String, Object> getRolesByUserId(Long userId);
    /**
     * 分配角色
     * @param assginRoleVo
     */
    void doAssign(AssginRoleVo assginRoleVo);
}
