package org.dragonwings.school.modular.system.service;

import org.dragonwings.school.framework.response.ResponseResult;
import org.dragonwings.school.modular.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
public interface UserService extends IService<User> {

    //    用户登录
    ResponseResult login(User user, HttpServletResponse response);

    //    注销
    ResponseResult logout();

    ResponseResult putUserInfo(User user);

    ResponseResult getUserInfo(Long userId);

    /***
    * @Param: [user, response]
    * @return: org.dragonwings.school.framework.response.ResponseResult
    * @Author: liyangyang
    * @Date: 2023/5/9 10:53
    * @Description: 管理员登录
    */
    ResponseResult adminLogin(User user, HttpServletResponse response);
}
