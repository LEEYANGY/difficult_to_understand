package xyz.leeyangy.school.modular.system.controller;


import xyz.leeyangy.school.framework.response.ResponseResult;
import xyz.leeyangy.school.modular.system.entity.User;
import xyz.leeyangy.school.modular.system.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * @Param: [user, response]
     * @return: org.dragonwings.school.framework.response.ResponseResult
     * @Author: liyangyang
     * @Date: 2023/5/3 1:29
     * @Description: 登录
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user, HttpServletResponse response) {
        System.out.println("==== 请求了登录接口 ====");
        System.out.println("controller====" + user);
        return userService.login(user, response);
    }

    /**
     * @Param: []
     * @return: org.dragonwings.school.framework.response.ResponseResult
     * @Author: liyangyang
     * @Date: 2023/5/3 1:29
     * @Description: 注销
     */
    @GetMapping("/logout")
    public ResponseResult logout() {
        return userService.logout();
    }


    /**
     * @Param: [userId]
     * @return: org.dragonwings.school.framework.response.ResponseResult
     * @Author: liyangyang
     * @Date: 2023/5/3 4:40
     * @Description: 获取用户信息
     */
    @GetMapping("/getUserInfo/{userId}")
    public ResponseResult getUserInfo(@PathVariable Long userId) {
        System.out.println(userId);
        return userService.getUserInfo(userId);
    }

    /**
     * @Param: [user]
     * @return: org.dragonwings.school.framework.response.ResponseResult
     * @Author: liyangyang
     * @Date: 2023/5/3 19:02
     * @Description: 修改用户信息，该接口需要复用，比如说，在数据库中预先注册的用户，在首次登录之后需要请求此接口修改密码
     */
    @PutMapping("/putUserInfo")
    public ResponseResult putUserInfo(@RequestBody User user) {

        System.out.println(user);

        return userService.putUserInfo(user);
    }
}

