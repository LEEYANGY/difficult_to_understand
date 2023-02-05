package xyz.leeyangy.framework.security.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import xyz.leeyangy.framework.security.jwt.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Package: xyz.leeyangy.framework.security.spring
 * @Author: LEEYANGYANG
 * @Create: 2022/10/31 23:29
 * @Description: 登录拦截器实现自HandlerInterceptor
 */
@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        http的header中获取token
//        String token = request.getHeader()
        System.out.println("预拦截");
//        获取请求头中token
        String token = request.getHeader("token");
//        验证token
        if(token == null || token.equals("")) {
            return true;
        }
        boolean b = JwtUtil.checkToken(token);
        if (b){
            return false;
        }else {

            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("请求后拦截");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("渲染视图后拦截");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
