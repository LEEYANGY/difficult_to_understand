package xyz.leeyangy.filter;

import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import xyz.leeyangy.pojo.LoginUser;
import xyz.leeyangy.utils.jwt.JwtUtil;
import xyz.leeyangy.utils.redis.RedisCache;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @Author liyangyang
 * @Date: 2023/02/24 21:57
 * @Package xyz.leeyangy.filter
 * @Version 1.0
 * @Description:
 */

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private RedisCache redisCache;

    /**
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
//            为空直接放行
            filterChain.doFilter(request, response);
            return;
        }
//        解析token
        String userId;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
//        从redis中获取用户信息
        String redisKey = "login:"+ userId;
//        反序列化获取登录用户信息
        LoginUser loginUser = redisCache.getCacheObject(redisKey);
        if (Objects.isNull(loginUser)){
            throw new RuntimeException("用户未登录");
        }
//        存入SecurityContext
//        获取权限信息封装
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//        放行
        filterChain.doFilter(request,response);
    }
}
