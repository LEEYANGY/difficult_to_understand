package com.lyy.security.modular;

import cn.hutool.core.lang.Dict;
import com.lyy.security.framwork.constants.RedisConstant;
import com.lyy.security.framwork.jwt.JwtUtils;
import com.lyy.security.framwork.redis.RedisCache;
import com.lyy.security.framwork.respone.ResponseData;
import com.lyy.security.framwork.spring.LoginUserInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.lyy.security.modular
 * @Author: LEEYANGYANG
 * @Create: 2022/11/2 19:34
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/info")
    public ResponseData info() {
        List<String> tempList = new ArrayList<>();

        tempList.add("1.");
        tempList.add("2.");
        tempList.add("3.");
        tempList.add("4.");
        System.out.println(tempList+"_____");
        return ResponseData.success(tempList);
    }

    @Resource
    private RedisCache redisCache;


    @GetMapping("/login")
    public String login(){

        Long  userId = 123L;
        LoginUserInfo  info = new LoginUserInfo();
        info.setId(123L);
        info.setAccount("zxw-lly");
        //执行登录
        //拼接redisKey
        String redisKey = RedisConstant.LOGIN_TOKEN_KEY + userId;
        //login_token:123
        redisCache.setCache(redisKey,info,RedisConstant.LOGIN_TOKEN_INVALID_TIME, TimeUnit.DAYS);
        return JwtUtils.createToken(userId);



    }
}
