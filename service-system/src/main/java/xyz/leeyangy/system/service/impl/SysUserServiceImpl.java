package xyz.leeyangy.system.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import xyz.leeyangy.model.dto.SysUserDto;
import xyz.leeyangy.model.system.SysUser;
import xyz.leeyangy.model.vo.SysUserQueryVo;
import xyz.leeyangy.system.mapper.SysUserMapper;
import xyz.leeyangy.system.service.SysUserService;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    /**
     * @Param: [sysUserDto]
     * @return: xyz.leeyangy.model.vo.SysUserQueryVo
     * @Author: liyangyang
     * @Date: 2023/9/18 14:29
     * @Description: 用户登录
     */
    @Override
    public SysUserQueryVo login(SysUserDto sysUserDto) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("roles", "[\"admin\"]");
        maps.put("introduction", "I am a super administaror");
        maps.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        maps.put("name", "Super admin leeyangy");
//        正常登录
        SysUser sysUser =
                new LambdaQueryChainWrapper<SysUser>(baseMapper)
                        .eq(SysUser::getUsername, sysUserDto.getUsername())
                        .eq(SysUser::getPassword, sysUserDto.getPassword())
                        .one();
        if (sysUser != null) {
            SysUserQueryVo userQueryVo = new SysUserQueryVo();
            BeanUtils.copyProperties(sysUser, userQueryVo);
//            userQueryVo.setToken("123456");
            return userQueryVo;
        } else {

            return null;
        }

    }
}
