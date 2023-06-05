//package xyz.leeyangy.school.framework.filter;
//
//import io.jsonwebtoken.Claims;
//import org.dragonwings.school.framework.exception.ServiceException;
//import org.dragonwings.school.framework.exception.enums.AuthExceptionEnum;
//import org.dragonwings.school.framework.exception.enums.abs.AbstractBaseExceptionEnum;
//import org.dragonwings.school.framework.response.ResponseUtils;
//import org.dragonwings.school.modular.system.entity.paramter.LoginUser;
//import org.dragonwings.school.modular.utils.jwt.JwtUtil;
//import org.dragonwings.school.modular.utils.redis.RedisCache;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.annotation.Resource;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Objects;
//
///**
// * @Author liyangyang
// * @Date: 2023/04/17 23:02
// * @Package org.dragonwings.school.framework.filter
// * @Version 1.0
// * @Description:
// */
//
//@Component
//public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
//
//    @Resource
//    private RedisCache redisCache;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
////        获取token
//        String token = request.getHeader("Authorization");
//
////        非空判断
//        if (!StringUtils.hasText(token)) {
////            放行
//            filterChain.doFilter(request, response);
//            return;
//        }
//
////        解析token获取用户userId
//        Long userId;
//        try {
//            Claims claims = JwtUtil.parseJWT(token);
//            userId = Long.valueOf(claims.getSubject());
//        } catch (Exception e) {
//            throw new  RuntimeException("解析token异常");
////            throw ResponseUtils.responseExceptionError(
////                    response,
////                    AuthExceptionEnum.REQUEST_TOKEN_ERROR.getCode(),
////                    AuthExceptionEnum.REQUEST_TOKEN_ERROR.getMessage(),
////                    new ServiceException(AuthExceptionEnum.REQUEST_TOKEN_ERROR).getStackTrace().toString()
////            );
//        }
//
////        从redis中查出用户信息
////        字符串拼接
//        String redisKey = "login:" + userId;
//
//        LoginUser loginUser = redisCache.getCacheObject(redisKey);
////        非空判断
//        if (Objects.isNull(loginUser)) {
//            //获取response信息,提示AuthExceptionEnum.LOGIN_EXPIRED
//            ResponseUtils.responseExceptionError(response,
//                    AuthExceptionEnum.LOGIN_EXPIRED.getCode(),
//                    AuthExceptionEnum.LOGIN_EXPIRED.getMessage(),
//                    new ServiceException((AbstractBaseExceptionEnum) AuthExceptionEnum.LOGIN_EXPIRED).getStackTrace()[0].toString());
//            return;
//        };
//
////        刷新缓存时间
////        redisCache.setCache(redisKey, loginUser, RedisConstant.LOGIN_TOKEN_INVALID_TIME, TimeUnit.DAYS);
////        将用户信息封装进SecurityContext中
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
////        放行
//        filterChain.doFilter(request, response);
//    }
//}
