package xyz.leeyangy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.leeyangy.mapper.UserMapper;
import xyz.leeyangy.pojo.LoginUser;
import xyz.leeyangy.pojo.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Author liyangyang
 * @Date: 2023/02/23 20:02
 * @Package xyz.leeyangy.service.impl
 * @Version 1.0
 * @Description:
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, username);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
        if (Objects.isNull(user)) {
            throw new RuntimeException("账号不存在");
        }
//        查询对应权限信息
//        模拟数据
        List<String> list = new ArrayList<>(Arrays.asList("test","vip1","vip2","admin"));

//        如果执行到此处，说明有该用户，需要返回一个UserDetail

        return new LoginUser(user,list);
    }
}
