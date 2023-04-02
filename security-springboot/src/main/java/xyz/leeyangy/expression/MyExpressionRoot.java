package xyz.leeyangy.expression;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import xyz.leeyangy.pojo.LoginUser;

import java.util.List;

/**
 * @Author liyangyang
 * @Date: 2023/04/03 1:46
 * @Package xyz.leeyangy.expression
 * @Version 1.0
 * @Description: 自定义权限校验方法
 */

@Component("myExpression")
public class MyExpressionRoot {

    public boolean hasAuthority(String authority) {
//        获取当前用户权限
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<String> permissions = loginUser.getPermissions();
//        判断用户是否有权限,存在 true  不存在 false


        return permissions.contains(authority);
    }

}
