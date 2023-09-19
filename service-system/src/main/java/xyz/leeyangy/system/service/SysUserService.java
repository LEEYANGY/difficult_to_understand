package xyz.leeyangy.system.service;

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
}
