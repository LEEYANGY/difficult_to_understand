//package xyz.leeyangy.school.framework.handle;
//
//import com.alibaba.fastjson.JSON;
//import org.dragonwings.school.framework.response.ResponseResult;
//import org.dragonwings.school.modular.utils.web.WebUtil;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @Author liyangyang
// * @Date: 2023/04/03 0:59
// * @Package xyz.leeyangy.handle
// * @Version 1.0
// * @Description: 授权失败处理
// */
//
//@Component
//public class AccessDeniedHandleImpl implements AccessDeniedHandler {
//    /**
//     * @param request
//     * @param response
//     * @param accessDeniedException
//     * @throws IOException
//     * @throws ServletException
//     */
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
//        ResponseResult result = new ResponseResult<>(HttpStatus.FORBIDDEN.value(), "未激活对应权限");
//        String json = JSON.toJSONString(result);
////        处理异常
//        WebUtil.renderString(response,json);
//    }
//}
