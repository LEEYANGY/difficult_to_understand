package xyz.leeyangy.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import xyz.leeyangy.pojo.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author liyangyang
 * @Date: 2023/02/23 20:52
 * @Package xyz.leeyangy.service.impl
 * @Version 1.0
 * @Description:
 */

@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {

    private User user;

    private List<String> permissions;

    public LoginUser(User user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }


    //    不需要序列化到redis中
    @JSONField(serialize = false)
//    List<GrantedAuthority> authorities;
    private List<GrantedAuthority> authorities;
//    private List<SimpleGrantedAuthority> authorities;

    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     * 该方法用于返回用户权限信息
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

//        List<GrantedAuthority> authorities = new ArrayList<>();
//        List<GrantedAuthority> authorities;
//        不为空直接返回
        if (authorities != null) return authorities;

//        为空，new ArrayList<>()
        authorities = new ArrayList<>();
//        下面是为空的过程
//        把permissions中权限信息封装成SimpGrantedAuthority
//        方法一:遍历
        for (String permission : permissions) {
//            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permission);
//            添加权限
            authorities.add(new SimpleGrantedAuthority(permission));
        }

//        方法二：stream流
//        authorities = permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        return authorities;
    }

    //原因

    /**
     * Returns the password used to authenticate the user.
     * 获取用户密码
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Returns the username used to authenticate the user. Cannot return
     * <code>null</code>.
     * 获取用户名
     *
     * @return the username (never <code>null</code>)
     */
    @Override
    public String getUsername() {
        return user.getUserName();
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     * 账户过期
     *
     * @return <code>true</code> if the user's account is valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     * 账户锁定
     *
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
