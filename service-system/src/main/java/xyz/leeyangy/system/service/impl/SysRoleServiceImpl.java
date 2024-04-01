package xyz.leeyangy.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.leeyangy.model.system.SysRole;
import xyz.leeyangy.model.system.SysUserRole;
import xyz.leeyangy.model.vo.AssginRoleVo;
import xyz.leeyangy.model.vo.SysRoleQueryVo;
import xyz.leeyangy.system.mapper.SysRoleMapper;
import xyz.leeyangy.system.mapper.SysUserRoleMapper;
import xyz.leeyangy.system.service.SysRoleService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo
            roleQueryVo) {
        return baseMapper.selectPage(pageParam, roleQueryVo);
    }

    @Override
    public Map<String, Object> getRolesByUserId(Long userId) {
        //获取所有角色
        List<SysRole> roles = baseMapper.selectList(null);
        //根据用户id查询
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        //获取用户已分配的角色
        List<SysUserRole> userRoles =
                sysUserRoleMapper.selectList(queryWrapper);
        //获取用户已分配的角色id
        List<Long> userRoleIds = new ArrayList<>();
        for (SysUserRole userRole : userRoles) {
            userRoleIds.add(Long.valueOf(userRole.getRoleId()));
        }
        //创建返回的Map
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("allRoles", roles);
        returnMap.put("userRoleIds", userRoleIds);
        return returnMap;
    }

    @Override
    public void doAssign(AssginRoleVo assginRoleVo) {
        //根据用户id删除原来分配的角色
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", assginRoleVo.getUserId());
        sysUserRoleMapper.delete(queryWrapper);
        //获取所有的角色id
        List<String> roleIdList = assginRoleVo.getRoleIdList();
        for (String roleId : roleIdList) {
            if (roleId != null) {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(assginRoleVo.getUserId());
                sysUserRole.setRoleId(String.valueOf(roleId));
                //保存
                sysUserRoleMapper.insert(sysUserRole);
            }
        }
    }
}