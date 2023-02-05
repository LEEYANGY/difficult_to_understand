package xyz.leeyangy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: xyz.leeyangy.controller
 * @Author: LEEYANGYANG
 * @Create: 2022/10/20 0:41
 * @Description:
 */
@Controller
//@RequestMapping("login")
public class IndexController {


    @RequestMapping("/")
    public String index(){
        System.out.println("post index");
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        System.out.println("post index");
        return "login";
    }

    @RequestMapping(value = "/login/success",
            method = {RequestMethod.GET},
            params = {"username=admin","password=admin"},
            headers = {"Hots=127.0.0.1:8080"})
    public String success(){
        System.out.println("login success");
        return "success";
    }

//    @PathVariable 加载控制方法的形参上
    @RequestMapping("/testPath/{id}")
    public String testPath(@PathVariable("id")Integer id){
        System.out.println("post /testPath success"+" id="+id);
        return "success";
    }

    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id")Integer id,@PathVariable("username")String username){
        System.out.println("post context /testPath success"+" id="+id +" username="+username);
        return "success";
    }

//    test post param
//    @RequestMapping("/param")
//    public String testParam(HttpServletRequest request){
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        System.out.println("username="+username+" password="+password);
//        return "test_param";
//    }

    @RequestMapping("/param")
    public String testParam(){
        System.out.println("param controller");
        return "test_param";
    }

    @RequestMapping("/Param")
    public String testParams(){
        System.out.println("params controller");
        return "test_param";
    }

    @RequestMapping("/test_view")
    public String testView(){
        System.out.println("--- test_view ---");
        return "test_view";
    }
}
