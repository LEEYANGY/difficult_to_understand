package xyz.leeyangy.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.leeyangy.model.system.SysRole;
import xyz.leeyangy.model.vo.SysRoleQueryVo;

public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
    * @Param: [page, roleQueryVo]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<xyz.leeyangy.model.system.SysRole>
    * @Author: liyangyang
    * @Date: 2023/9/13 0:07
    * @Description: 分页查询所有角色
    */
    IPage<SysRole> selectPage(Page<SysRole> page, @Param("vo") SysRoleQueryVo roleQueryVo);
}
