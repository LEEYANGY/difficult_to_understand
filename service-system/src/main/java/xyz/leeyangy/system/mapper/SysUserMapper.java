package xyz.leeyangy.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import xyz.leeyangy.model.system.SysUser;
import xyz.leeyangy.model.vo.SysUserQueryVo;

public interface SysUserMapper extends BaseMapper<SysUser> {
    IPage<SysUser> selectPage(Page<SysUser> page, @Param("vo") SysUserQueryVo
            userQueryVo);
}
