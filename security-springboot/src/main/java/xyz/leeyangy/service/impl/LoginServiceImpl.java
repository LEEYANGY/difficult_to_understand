package xyz.leeyangy.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import xyz.leeyangy.pojo.LoginUser;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.respone.ResponseResult;
import xyz.leeyangy.service.LoginService;
import xyz.leeyangy.utils.jwt.JwtUtil;
import xyz.leeyangy.utils.redis.RedisCache;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author liyangyang
 * @Date: 2023/02/24 12:46
 * @Package xyz.leeyangy.service.impl
 * @Version 1.0
 * @Description:
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisCache redisCache;

    /**
     * @param user
     * @return
     */
    @Override
    public ResponseResult login(User user) {
//        封装用户名和密码
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
//        使用Authentication 进行用户认证
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

//        不通过给出提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
//        通过生成jwt
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
//        把用户信息存入redis  key:userId  value: jwt token
        Map<String, String> map = new HashMap<>();
        map.put(userId, jwt);
        redisCache.setCacheObject("login:" + userId, loginUser);
        System.out.println(loginUser);
        return new ResponseResult<>(200, "登录成功", map);
    }

    /**
     * @return
     */
    @Override
    public ResponseResult logout() {
//      获取SecurityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userId = loginUser.getUser().getId();
        //删除redis中的值
        redisCache.deleteObject("login:" + userId);
        return new ResponseResult(200, "注销成功");

    }
}
