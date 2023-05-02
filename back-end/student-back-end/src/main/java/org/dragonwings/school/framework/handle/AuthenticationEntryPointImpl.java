package org.dragonwings.school.framework.handle;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.dragonwings.school.framework.response.ResponseResult;
import org.dragonwings.school.modular.utils.web.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author liyangyang
 * @Date: 2023/04/03 0:52
 * @Package xyz.leeyangy.handle
 * @Version 1.0
 * @Description: 自定义未授权处理
 */

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    /**
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult result = new ResponseResult<>(HttpStatus.UNAUTHORIZED.value(),"用户认证失败，请检查账号和密码");
        String json = JSON.toJSONString(result);
        //        处理异常
        WebUtil.renderString(response,json);
    }
}
