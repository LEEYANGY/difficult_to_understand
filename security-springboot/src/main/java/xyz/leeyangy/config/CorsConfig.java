package xyz.leeyangy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author liyangyang
 * @Date: 2023/04/03 1:15
 * @Package xyz.leeyangy.config
 * @Version 1.0
 * @Description: 跨域处理
 */

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    /**
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//       允许跨域路径
        registry.addMapping("/**")
//                允许跨域请求签名
                .allowedOriginPatterns("*")
//        是否允许cookie
                .allowCredentials(true)
//        允许请求方式
                .allowedMethods("POST","GET","DELETE","PUT")
//        允许handler属性
                .allowedHeaders("*")
//        跨域时间
                .maxAge(3600);
//        WebMvcConfigurer.super.addCorsMappings(registry);
    }
}
