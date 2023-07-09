package xyz.leeyangy.security_learn1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liyangyang
 * @Date: 2023/07/10 2:54
 * @Package xyz.leeyangy.security_learn1.controller
 * @Version 1.0
 * @Description: 错误信息拦截
 */

@RestController
@RequestMapping("/error")
public class ErrorController {
    @GetMapping("/403")
    public String error403(){
        return "您没有权限访问此接口";
    }
}
