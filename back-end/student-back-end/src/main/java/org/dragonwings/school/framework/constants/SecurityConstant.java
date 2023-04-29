package org.dragonwings.school.framework.constants;

/**
 * @Package: com.lyy.security.framwork.constants
 * @Author: LEEYANGYANG
 * @Create: 2022/11/2 19:54
 * @Description:
 */
public interface SecurityConstant {

    //    开放接口
    String[] SECURITY_URL = {
//            登录接口
            "/system/user/login/**",
//            动态内容
            "/system/zone/getAllArticle/**",
            "/system/zone/getDetail/**",
            "/system/zone/getMaxTotal/**",
//            聊天
//            "/imserver/**"
    };
}
