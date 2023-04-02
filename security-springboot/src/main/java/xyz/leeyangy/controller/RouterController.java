package xyz.leeyangy.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author liyangyang
 * @Date: 2023/02/14 2:07
 * @Package xyz.leeyangy.controller
 * @Version 1.0
 * @Description:
 */

@Controller
public class RouterController {

    @RequestMapping({"/", "index","hello"})
    public String index() {
        System.out.println("into index");
        return "home";
    }

    @RequestMapping("/level1/{id}")
    @PreAuthorize("hasAnyAuthority('system:admin:list')")
    public String level1(@PathVariable("id") int id) {
        System.out.println("into level1 pages");
        return "views/level1/"+id;
    }

    @RequestMapping("/level2/{id}")
    @PreAuthorize("hasAnyAuthority('vip2')")
    public String level2(@PathVariable("id") int id) {
        System.out.println("into level2 pages");
        return "views/level2/"+id;
    }

    @RequestMapping("/level3/{id}")
    @PreAuthorize("hasAnyAuthority('vip3')")
    public String level3(@PathVariable("id") int id) {
        System.out.println("into level3 pages");
        return "views/level3/"+id;
    }
}
