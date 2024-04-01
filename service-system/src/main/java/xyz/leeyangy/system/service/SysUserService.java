package xyz.leeyangy.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.leeyangy.model.dto.SysUserDto;
import xyz.leeyangy.model.system.SysUser;
import xyz.leeyangy.model.vo.SysUserQueryVo;

public interface SysUserService extends IService<SysUser> {

    /**
    * @Param: [sysUserDto]
    * @return: xyz.leeyangy.model.vo.SysUserQueryVo
    * @Author: liyangyang
    * @Date: 2023/9/18 14:29
    * @Description: 用户登录
    */
    SysUserQueryVo login(SysUserDto sysUserDto);


    /**
    * @Param: [pageParam, adminQueryVo]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<xyz.leeyangy.model.system.SysUser>
    * @Author: liyangyang
    * @Date: 2023/9/20 14:20
    * @Description: 用户信息分页查询
    */
    IPage<SysUser> selectPage(Page<SysUser> pageParam, SysUserQueryVo
            adminQueryVo);

    void updateStatus(Long id, Integer status);
}
