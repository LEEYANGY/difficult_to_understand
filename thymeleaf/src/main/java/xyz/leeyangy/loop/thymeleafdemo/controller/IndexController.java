package xyz.leeyangy.loop.thymeleafdemo.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import xyz.leeyangy.loop.thymeleafdemo.vo.UserV0;

import java.util.Arrays;
import java.util.Date;

/**
 * @author LEEYANGY
 * @date 2022/2/14 19:34
 */
@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("title","传递的Title");
        model.addAttribute("description","这是描述");
        model.addAttribute("keywords","这是关键字");
        return "index";
    }
    @GetMapping("/basic")
    public String basic(Model model){
        UserV0 userV0 = new UserV0();
        userV0.setUsername("lee");
        userV0.setAge(22);
        userV0.setSex(1);
        userV0.setCreateTime(new Date());
        userV0.setIsVip(false);
        userV0.setTags(Arrays.asList("C","Java"));
        model.addAttribute("user", userV0);
        return "basic";
    }
}
