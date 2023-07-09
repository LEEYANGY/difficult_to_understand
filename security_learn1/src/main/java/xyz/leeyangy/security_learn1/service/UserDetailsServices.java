package xyz.leeyangy.security_learn1.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.leeyangy.security_learn1.entity.PermissionEntity;
import xyz.leeyangy.security_learn1.entity.UserEntity;
import xyz.leeyangy.security_learn1.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author liyangyang
 * @Date: 2023/07/10 5:29
 * @Package xyz.leeyangy.security_learn1.service
 * @Version 1.0
 * @Description:
 */

@Service
public class UserDetailsServices implements UserDetailsService {

    @Resource
    UserMapper userMapper;

    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       登录时候调用该方法
        UserEntity userEntity = userMapper.findByUsername(username);
//        非空判断
        if (userEntity == null) return null;

//        遍历用户权限信息
//        List<PermissionEntity> permissionByUsername = userMapper.findPermissionByUsername(username);
//         类型转换
        ArrayList<GrantedAuthority> authorityArrayList = new ArrayList<>();
        userMapper.findPermissionByUsername(username).forEach(
                p -> {
//                  等价于这段代码  auth.inMemoryAuthentication().withUser("lee_get").password("0713").authorities("get");
                    authorityArrayList.add(new SimpleGrantedAuthority(p.getPermTag()));
                }
        );
        userEntity.setAuthorities(authorityArrayList);
        return userEntity;
    }
}
