package xyz.leeyangy.security_learn1.controller;

import org.springframework.context.annotation.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liyangyang
 * @Date: 2023/07/09 22:29
 * @Package xyz.leeyangy.security_learn1.controller
 * @Version 1.0
 * @Description:
 */

@RestController
@RequestMapping("/api/system")
public class TestController {

    @GetMapping("/getInfo")
    public String getInfo(){
        return "获取网站信息";
    }

    @GetMapping("/updateInfo")
    public String updateInfo(){
        return "更新网站信息";
    }

    @GetMapping("/addInfo")
    public String addInfo(){
        return "添加网站信息";
    }

    @GetMapping("/delInfo")
    public String delInfo(){
        return "删除网站信息";
    }

}
