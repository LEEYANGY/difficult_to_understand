package xyz.leeyangy.school.modular.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.leeyangy.school.framework.response.ResponseData;
import xyz.leeyangy.school.framework.response.ResponseResult;
import xyz.leeyangy.school.modular.system.entity.User;

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
    * @return: xyz.leeyangy.school.framework.response.ResponseResult
    * @Author: liyangyang
    * @Date: 2023/5/9 10:53
    * @Description: 管理员登录
    */
    ResponseResult adminLogin(User user, HttpServletResponse response);

    /**
    * @Param: [user]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 13:50
    * @Description: 更新用户信息
    */
    ResponseData updateUserInfo(User user);

    /**
    * @Param: [page, limit]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 13:52
    * @Description: 分页查询所有用户
    */
    ResponseData getAllUserByPage(Integer page, Integer limit);
}
