package xyz.leeyangy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import xyz.leeyangy.filter.JwtAuthenticationTokenFilter;
import xyz.leeyangy.handle.AccessDeniedHandleImpl;
import xyz.leeyangy.handle.AuthenticationEntryPointImpl;

import javax.annotation.Resource;

/**
 * @Author liyangyang
 * @Date: 2023/02/14 2:47
 * @Package xyz.leeyangy.config
 * @Version 1.0
 * @Description: 重写一些方法，实现功能
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * @param http
     * @throws Exception
     */
    /**
     * Override this method to configure the {@link HttpSecurity}. Typically subclasses
     * should not invoke this method by calling super as it may override their
     * configuration. The default configuration is:
     *
     * <pre>
     * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
     * </pre>
     * <p>
     * Any endpoint that requires defense against common vulnerabilities can be specified
     * here, including public ones. See {@link HttpSecurity#authorizeRequests} and the
     * `permitAll()` authorization rule for more details on public endpoints.
     *
     * @param http the {@link HttpSecurity} to modify
     * @throws Exception if an error occurs
     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //       所有人首页都可以访问，功能页只有登录才能访问
//        http.authorizeHttpRequests().antMatchers("/").permitAll()
//                .antMatchers("/level1/**").hasRole("vip1")
//                .antMatchers("/level2/**").hasRole("vip2")
//                .antMatchers("/level3/**").hasRole("vip3");
////        没有权限默认跳转到登录
//        http.formLogin();
////        定制登录页面
////        http.formLogin().loginPage("/login");
////        开启注销
////        http.logout().logoutUrl("/logout");
////        http.logout().deleteCookies("remove").invalidateHttpSession(true)
////                .logoutUrl("/logout");
//        http.logout().logoutSuccessUrl("/");
////        http.exceptionHandling().accessDeniedPage("/e403");
//    }
//
//    /**
//     * Used by the default implementation of {@link #authenticationManager()} to attempt
//     * to obtain an {@link AuthenticationManager}. If overridden, the
//     * {@link AuthenticationManagerBuilder} should be used to specify the
//     * {@link AuthenticationManager}.
//     *
//     * <p>
//     * The {@link #authenticationManagerBean()} method can be used to expose the resulting
//     * {@link AuthenticationManager} as a Bean. The {@link #userDetailsServiceBean()} can
//     * be used to expose the last populated {@link UserDetailsService} that is created
//     * with the {@link AuthenticationManagerBuilder} as a Bean. The
//     * {@link UserDetailsService} will also automatically be populated on
//     * {@link HttpSecurity#getSharedObject(Class)} for use with other
//     * {@link SecurityContextConfigurer} (i.e. RememberMeConfigurer )
//     * </p>
//     *
//     * <p>
//     * For example, the following configuration could be used to register in memory
//     * authentication that exposes an in memory {@link UserDetailsService}:
//     * </p>
//     *
//     * <pre>
//     * &#064;Override
//     * protected void configure(AuthenticationManagerBuilder auth) {
//     * 	auth
//     * 	// enable in memory based authentication with a user named
//     * 	// &quot;user&quot; and &quot;admin&quot;
//     * 	.inMemoryAuthentication().withUser(&quot;user&quot;).password(&quot;password&quot;).roles(&quot;USER&quot;).and()
//     * 			.withUser(&quot;admin&quot;).password(&quot;password&quot;).roles(&quot;USER&quot;, &quot;ADMIN&quot;);
//     * }
//     *
//     * // Expose the UserDetailsService as a Bean
//     * &#064;Bean
//     * &#064;Override
//     * public UserDetailsService userDetailsServiceBean() throws Exception {
//     * 	return super.userDetailsServiceBean();
//     * }
//     *
//     * </pre>
//     *
//     * @param auth the {@link AuthenticationManagerBuilder} to use
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        String arr[]={"vip1","vip2"};
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("null").password(new BCryptPasswordEncoder().encode("null")).roles("vip1", "vip2", "vip3")
////                and 连接更多
//                .and().withUser("lee").password(new BCryptPasswordEncoder().encode("lee")).roles(arr);
//    }
//
//    /**
//     * Override this method to configure {@link WebSecurity}. For example, if you wish to
//     * ignore certain requests.
//     * <p>
//     * Endpoints specified in this method will be ignored by Spring Security, meaning it
//     * will not protect them from CSRF, XSS, Clickjacking, and so on.
//     * <p>
//     * Instead, if you want to protect endpoints against common vulnerabilities, then see
//     * {@link #configure(HttpSecurity)} and the {@link HttpSecurity#authorizeRequests}
//     * configuration method.
//     *
//     * @param web
//     */
////    静态资源处理
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/css");
//    }

//    加密
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Override this method to expose the {@link AuthenticationManager} from
     * {@link #configure(AuthenticationManagerBuilder)} to be exposed as a Bean. For
     * example:
     *
     * <pre>
     * &#064;Bean(name name="myAuthenticationManager")
     * &#064;Override
     * public AuthenticationManager authenticationManagerBean() throws Exception {
     *     return super.authenticationManagerBean();
     * }
     * </pre>
     *
     * @return the {@link AuthenticationManager}
     * @throws Exception
     */

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
                //STATELESS表示不会通过session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //对于登录接口 允许匿名访问（未登录可以访问，anonymous表示可以匿名访问）
                .antMatchers("/user/login").anonymous()
                //除上面外的所有请求全部需要认证即可访问
                .anyRequest().authenticated();

//        添加过滤器
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

//        配置移仓处理
        http.exceptionHandling()
//                配置认证失败过滤器
                .authenticationEntryPoint(authenticationEntryPoint)
//                配置授权失败过滤器
                .accessDeniedHandler(accessDeniedHandler);

//        允许跨域
        http.cors();
    }
}
