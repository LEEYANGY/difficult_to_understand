package xyz.leeyangy.security_learn1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import xyz.leeyangy.security_learn1.entity.PermissionEntity;
import xyz.leeyangy.security_learn1.mapper.PermissionMapper;
import xyz.leeyangy.security_learn1.service.UserDetailsServices;
import xyz.leeyangy.security_learn1.utils.MD5Util;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author liyangyang
 * @Date: 2023/06/27 3:24
 * @Package xyz.leeyangy.security_learn1.config
 * @Version 1.0
 * @Description:
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    UserDetailsServices userDetailsServices;

    /**
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        用户写死
//        auth.inMemoryAuthentication().withUser("admin").password("0713").authorities("get", "update", "dels", "adds");
//        auth.inMemoryAuthentication().withUser("lee_get").password("0713").authorities("get");
//        auth.inMemoryAuthentication().withUser("lee_up").password("0713").authorities("update");
//        auth.inMemoryAuthentication().withUser("lee_de").password("0713").authorities("dels");
//        auth.inMemoryAuthentication().withUser("lee_ad").password("0713").authorities("adds");
//        动态查询用户及用户权限
        auth.userDetailsService(userDetailsServices).passwordEncoder(new PasswordEncoder() {
//            加密密码
            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String) rawPassword);
            }

//            判断数据库密码
            // rawPassword 页面传过来的密码
            // encodedPassword 数据库中的代码
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                String rawPasswd = MD5Util.encode((String) rawPassword);
                return rawPasswd.equals(encodedPassword);
            }
        });
    }

    @Resource
    PermissionMapper permissionMapper;

    /**
     * @param http
     * @throws Exception
     * @description: basic认证
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        配置认证方式 token form 表单，设置为httBasic
//        http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic();
//        使用form表单
//        http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().formLogin();
        //        设置拦截规则
//        http.authorizeRequests().antMatchers("/**/getInfo").hasAnyAuthority("get")
//                .antMatchers("/**/updateInfo").hasAnyAuthority("update")
//                .antMatchers("/**/delInfo").hasAnyAuthority("dels")
//                .antMatchers("/**/addInfo").hasAnyAuthority("adds")
//                .antMatchers("/**").fullyAuthenticated().and().formLogin();

//            自定义登录页面
//        http.authorizeRequests().antMatchers("/**/getInfo").hasAnyAuthority("get")
//                .antMatchers("/**/updateInfo").hasAnyAuthority("update")
//                .antMatchers("/**/delInfo").hasAnyAuthority("dels")
//                .antMatchers("/**/addInfo").hasAnyAuthority("adds")
//                .antMatchers("/login").permitAll()
//                .antMatchers("/**").fullyAuthenticated().and().formLogin().loginPage("/login")
//                .and().csrf().disable();
//        动态获取需要的设置
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry
                authorizeRequests = http.authorizeRequests();
//        查询全部权限
        List<PermissionEntity> allPermission = permissionMapper.findAllPermission();
        allPermission.forEach(
                p->{
//                    添加规则
                    authorizeRequests.antMatchers(p.getUrl()).hasAnyAuthority(p.getPermTag());
                }
        );
        //添加登录页面,不拦截登录页面(要开放页面，也可以使用动态查询获取)
        authorizeRequests.antMatchers("/login").permitAll()
                .antMatchers("/**").fullyAuthenticated().and().formLogin()
                .loginPage("/login").and().csrf().disable();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    /**
     * @Param: []
     * @return: org.springframework.security.crypto.password.NoOpPasswordEncoder
     * @Author: liyangyang
     * @Date: 2023/7/10 0:16
     * @Description: 不需要加密
     */
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
