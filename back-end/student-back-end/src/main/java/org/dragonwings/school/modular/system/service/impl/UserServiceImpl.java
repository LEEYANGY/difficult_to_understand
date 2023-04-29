package org.dragonwings.school.modular.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.dragonwings.school.framework.exception.enums.abs.AbstractBaseExceptionEnum;
import org.dragonwings.school.framework.respone.ResponseData;
import org.dragonwings.school.framework.respone.ResponseResult;
import org.dragonwings.school.framework.respone.ResponseUtils;
import org.dragonwings.school.modular.system.entity.User;
import org.dragonwings.school.modular.system.entity.paramter.LoginUser;
import org.dragonwings.school.modular.system.mapper.UserMapper;
import org.dragonwings.school.modular.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dragonwings.school.modular.utils.jwt.JwtUtil;
import org.dragonwings.school.modular.utils.redis.RedisCache;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static org.dragonwings.school.framework.constants.AuthHeadConstant.Authorization;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService, UserDetailsService {

    @Resource
    private RedisCache redisCache;

    @Resource
    private UserMapper userMapper;

    @Resource
    private AuthenticationManager authenticationManager;

    //    实现从数据库中校验用户身份
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        使用用户id登录判断
        queryWrapper.eq(User::getUserId, username);
        User user = userMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(user)) {
            throw new  RuntimeException("没有该用户");
        }
//        查询权限
        List<String> list = new ArrayList<>();
        list.add("admin");
        list.add("hello");

        return new LoginUser(user, list);
    }

    //    登录校验
    @Override
    public ResponseResult login(User user, HttpServletResponse response) {
//        封装用户名和密码
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUserId(), user.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        if (Objects.isNull(authentication)) {
            throw new RuntimeException("登录失败");
        }

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userId = (Long) loginUser.getUser().getUserId();
//        创建jwt
        String jwt = JwtUtil.createJWT(userId.toString());
//        将用户信息存入redis中
//        Map<Long, String> map = new HashMap<>();
//        map.put(userId, jwt);
        redisCache.setCacheObject("login:" + userId, loginUser);
//        将jwt添加到响应头中
        response.setHeader(Authorization, jwt);
//        清空密码
        loginUser.getUser().setPassword("");
        List<User> list = new ArrayList<>();
        list.add(loginUser.getUser());
//        数据响应给前端
        return new ResponseResult(200, "登录成功", list);
    }

    //    注销登录
    @Override
    public ResponseResult logout() {
        //      获取SecurityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userId = loginUser.getUser().getUserId();
        //删除redis中的值
        redisCache.deleteObject("login:" + userId);
        return new ResponseResult(200, "注销成功");
    }


}
