package org.dragonwings.school.modular.system.controller;


import org.dragonwings.school.framework.respone.ResponseData;
import org.dragonwings.school.framework.respone.ResponseResult;
import org.dragonwings.school.modular.system.entity.User;
import org.dragonwings.school.modular.system.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    //    注入
    @Resource
    private UserService userService;

    //    登录
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user, HttpServletResponse response) {
        System.out.println("==== 请求了登录接口 ====");
        System.out.println("controller====" + user);
        return userService.login(user, response);
    }

    //    注销
    @GetMapping("/logout")
    public ResponseResult logout() {
        return userService.logout();
    }
}

