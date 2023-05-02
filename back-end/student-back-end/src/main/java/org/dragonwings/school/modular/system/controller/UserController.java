package org.dragonwings.school.modular.system.controller;


import org.dragonwings.school.framework.response.ResponseResult;
import org.dragonwings.school.modular.system.entity.User;
import org.dragonwings.school.modular.system.service.UserService;
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
        return userService.getUserInfo(userId);
    }

    @PutMapping("/putUserInfo")
    public ResponseResult putUserInfo(@RequestBody User user) {
        return userService.putUserInfo(user);
    }
}

