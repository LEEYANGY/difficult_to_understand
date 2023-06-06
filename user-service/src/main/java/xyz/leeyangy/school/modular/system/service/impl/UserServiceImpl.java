package xyz.leeyangy.school.modular.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.xml.internal.bind.v2.TODO;
import xyz.leeyangy.school.framework.response.ResponseData;
import xyz.leeyangy.school.framework.response.ResponseResult;
import xyz.leeyangy.school.modular.system.entity.User;
import xyz.leeyangy.school.modular.system.mapper.UserMapper;
import xyz.leeyangy.school.modular.system.service.UserService;

import xyz.leeyangy.school.modular.utils.redis.RedisCache;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static xyz.leeyangy.constants.AuthHeadConstant.Authorization;


/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private RedisCache redisCache;

    @Resource
    private UserMapper userMapper;




    //    登录校验
    @Override
    public ResponseResult login(User user, HttpServletResponse response) {
        //        密码解密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",user.getUserId());
        List<User> list =new ArrayList<>();
        User selectOne = baseMapper.selectOne(queryWrapper);

        if (selectOne==null){
            return new  ResponseResult(403,"请检查用户名和密码");
        }else {
            //                判断密码
            boolean matches = encoder.matches(user.getPassword(), selectOne.getPassword());
            if (matches){
                selectOne.setPassword(null);
                response.setHeader(Authorization, "Authorization");
                list.add(selectOne);
            }else {
                return new  ResponseResult(403,"请检查用户名和密码");
            }
        }
//        数据响应给前端
        return new ResponseResult(200, "登录成功", selectOne);
    }

    /**
     * @param user
     * @param response
     * @Param: [user, response]
     * @return: xyz.leeyangy.school.framework.response.ResponseResult
     * @Author: liyangyang
     * @Date: 2023/5/9 10:53
     * @Description: 管理员登录
     */
    @Override
    public ResponseResult adminLogin(User user, HttpServletResponse response) {
//        密码解密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user1 = baseMapper.selectOne(new QueryWrapper<User>().eq("user_id", user.getUserId()));
        if (user1 == null) {
            return new  ResponseResult(403,"没有该用户");
        } else {
//                判断密码
            boolean matches = encoder.matches(user.getPassword(), user1.getPassword());
            if (matches) {
                //        在校验是不是管理员
                List<User> list = userMapper.adminLogin(user);
                if (list != null) {
                    user1.setPassword(null);
                    return new ResponseResult<>(200, "登录成功", user1);
                } else {
                    return new  ResponseResult(403,"登录失败，请联系管理员");
                }
            } else {
                return new  ResponseResult(403,"密码错误");
            }
        }

    }

   /**
   * @Param: []
   * @return: xyz.leeyangy.school.framework.response.ResponseResult
   * @Author: liyangyang
   * @Date: 2023/6/6 13:25
   * @Description: 注销登录
   */
    @Override
    public ResponseResult logout() {
        //      获取SecurityContextHolder中的用户id

        return new ResponseResult(200, "注销成功");
    }

   /**
   * @Param: [user]
   * @return: xyz.leeyangy.school.framework.response.ResponseResult
   * @Author: liyangyang
   * @Date: 2023/6/6 13:25
   * @Description: 更新用户信息
   */
    @Override
    public ResponseResult putUserInfo(User user) {
//        密码需要加密处理  不为空的话，就需要加密密码
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            user.setPassword(baseMapper.selectById(user).getPassword());
        } else {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        }
//        修改用户数据
        if (baseMapper.updateById(user) >= 1) {
            return new ResponseResult<>(200, "更新成功", null);
        } else {
            return new ResponseResult<>(500, "更新失败", null);
        }
    }

    /**
     * @param userId
     * @return
     * @Description: 获取用户信息
     */
    @Override
    public ResponseResult getUserInfo(Long userId) {
        User user = baseMapper.selectOne(new QueryWrapper<User>().eq("user_id", userId));
//        保障密码安全
        if (user.getPassword() != null || user.getPassword() != "") user.setPassword(null);
        return new ResponseResult(200, "获取成功", user);
    }

    // TODO 管理员功能

    @Override
    public ResponseData updateUserInfo(User user) {
        //        Hutool StrUtil
        if (StrUtil.hasBlank(user.getPassword())) {
            User getPassword = baseMapper.selectById(user.getId());
            user.setPassword(getPassword.getPassword());
        } else {
            //            加密密码
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
        }
        if (baseMapper.updateById(user)>=1) {
            return ResponseData.success(200);
        } else {
            return ResponseData.error(501);
        }
    }

    /**
    * @Param: [page, limit]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 13:52
    * @Description: 分页查询所有用户信息
    */
    @Override
    public ResponseData getAllUserByPage(Integer page, Integer limit) {
        if (page == null || page < 1) page = 1;
        if (limit == null || limit <= 1) limit = 10;
//        分页查询
        Page<User> userPage =    new LambdaQueryChainWrapper<User>(baseMapper)
                .orderByDesc(User::getId)
                .page(new Page<>(page, limit));
        return ResponseData.success(200, "获取成功", userPage);
    }
}
