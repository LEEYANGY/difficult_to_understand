package xyz.leeyangy.system.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.leeyangy.model.system.SysRole;
import xyz.leeyangy.model.vo.SysRoleQueryVo;
import xyz.leeyangy.system.mapper.SysRoleMapper;
import xyz.leeyangy.system.service.SysRoleService;

@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Override
    public IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo
            roleQueryVo) {
        return baseMapper.selectPage(pageParam, roleQueryVo);
    }

}
