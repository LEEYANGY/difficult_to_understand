package org.dragonwings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liyangyang
 * @Date: 2023/04/03 23:55
 * @Package org.dragonwings.controller
 * @Version 1.0
 * @Description:
 */

@RestController
public class HelloController {

    @GetMapping
    public String hello(){
        return "hello，storm 38888";
    }
}
