package org.dragonwings.school.framework.config;

import org.dragonwings.school.framework.constants.SecurityConstant;
import org.dragonwings.school.framework.filter.JwtAuthenticationTokenFilter;
import org.dragonwings.school.framework.handle.AccessDeniedHandleImpl;
import org.dragonwings.school.framework.handle.AuthenticationEntryPointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @Author liyangyang
 * @Date: 2023/04/17 20:39
 * @Package org.dragonwings.config
 * @Version 1.0
 * @Description:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //    密码加密
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //    授权(身份验证)
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Resource
    private AuthenticationEntryPointImpl authenticationEntryPoint;

    @Resource
    private AccessDeniedHandleImpl accessDeniedHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
//               STATELESS表示不会通过session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //    配置需要放行的接口
                .antMatchers(SecurityConstant.SECURITY_URL).anonymous()
//                其它所有接口,请求都需要认证
                .anyRequest().authenticated();

//        添加自己的认证过滤器
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//        异常处理,暂时不配
        http.exceptionHandling()
//                配置认证失败过滤器
                .authenticationEntryPoint(authenticationEntryPoint)
//                配置授权失败过滤器
                .accessDeniedHandler(accessDeniedHandler);

//        允许跨域
        http.cors();
    }
}
