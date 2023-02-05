package xyz.leeyangy.framework.security.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Package: xyz.leeyangy.framework.security.spring
 * @Author: LEEYANGYANG
 * @Create: 2022/11/1 0:18
 * @Description:
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
////        WebMvcConfigurer.super.addInterceptors(registry);
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/user/**")
//                .addPathPatterns("/userInfo/**")
//                .excludePathPatterns("/user/login");//开放登录路径
//    }
}
