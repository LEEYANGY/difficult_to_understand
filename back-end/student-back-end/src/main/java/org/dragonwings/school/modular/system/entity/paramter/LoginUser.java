package org.dragonwings.school.modular.system.entity.paramter;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dragonwings.school.modular.system.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author liyangyang
 * @Date: 2023/04/17 21:57
 * @Package org.dragonwings.school.modular.system.entity.paramter
 * @Version 1.0
 * @Description: 重写UserDetails方法
 */

@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {

    //    用户
    private User user;

    //    用户权限列表
    private List<String> permissions;

    //    实现自己的构造方法
    public LoginUser(User user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }


    //    不需要序列化到redis中
    @JSONField(serialize = false)
//    List<GrantedAuthority> authorities;
    private List<GrantedAuthority> authorities;

    //    用户权限
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //        不为空直接返回
        if (authorities != null) return authorities;

        //        为空，new ArrayList<>()
        authorities = new ArrayList<>();
        for (String permission : permissions) {
//            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permission);
//            添加权限
//            assert authorities != null;
            authorities.add(new SimpleGrantedAuthority(permission));
        }
        return authorities;
    }

    //    获取用户密码
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    //    获取用户名
    @Override
    public String getUsername() {
        return user.getUserId().toString();
    }

    //    账户过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //    账户锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //    凭证过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
