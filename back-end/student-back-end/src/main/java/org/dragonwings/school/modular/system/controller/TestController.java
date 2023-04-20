package org.dragonwings.school.modular.system.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liyangyang
 * @Date: 2023/04/17 0:48
 * @Package org.dragonwings.school.modular.system.controller
 * @Version 1.0
 * @Description:
 */

@RestController
@RequestMapping("/hello")
public class TestController {

    @GetMapping
    public String hello(){
        return "看到测试json了吗？";
    }

    @PreAuthorize("hasAnyAuthority('admin')")
    @GetMapping("/vip1")
    public String vip1(){
        return "这里是付费内容噢!";
    }
}
