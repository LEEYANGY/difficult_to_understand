package xyz.leeyangy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liyangyang
 * @Date: 2023/02/14 4:19
 * @Package xyz.leeyangy.controller
 * @Version 1.0
 * @Description: 一些异常跳转
 */

//@Controller
@RestController
public class ExceptionController {

    @GetMapping("/e403")
    public String e403() {
        return "403";
    }
}
