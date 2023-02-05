package com.meng.library.mybatisplus.controller;

import com.meng.library.mybatisplus.param.UserHeadUrlParam;
import com.meng.library.mybatisplus.service.UserHeadUrlService;
import com.meng.library.utils.base.RequestResult;
import com.meng.library.utils.constant.ResultConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/userService")
public class UserServiceController {

    @Autowired
    private UserHeadUrlService userHeadUrlService;

    @RequestMapping("/page")
    public RequestResult userServicePage(@RequestBody UserHeadUrlParam userHeadUrlParam) {

        try {
            return RequestResult.succ(userHeadUrlService.pageUserUrlResult(userHeadUrlParam));
        } catch (Exception e) {
            return RequestResult.fail(ResultConstant.SEARCHFAIL);
        }
    }
    @RequestMapping("/register")
    public RequestResult register(@RequestBody UserHeadUrlParam userHeadUrlParam) {

        try {
            userHeadUrlService.register(userHeadUrlParam);
            return RequestResult.succ(null);
        } catch (Exception e) {
            return RequestResult.fail(ResultConstant.SEARCHFAIL);
        }
    }

}
