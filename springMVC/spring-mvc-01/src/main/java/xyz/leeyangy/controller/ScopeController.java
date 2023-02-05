package xyz.leeyangy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Package: xyz.leeyangy.controller
 * @Author: LEEYANGYANG
 * @Create: 2022/10/21 18:33
 * @Description:
 */
@Controller
public class ScopeController {

    //    servletAPI
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request) {
        request.setAttribute("testRequestScope", "hello,servlet");
        return "success";
    }

//    spring提供的向request域共享数据方法

    /**
     * 向request域共享数据，向视图设置视图名称
     *
     * @return ModelAndView必须做为返回值返回
     */
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("使用了 ModelAndView");
        ModelAndView mav = new ModelAndView();
//        处理模型数据，想请求域request共享数据
        mav.addObject("testRequestScope", "hello,ModelAndView");
//        设置视图名称  view
        mav.setViewName("success");
        return mav;
    }

    //    model
    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "hello,model");
        return "success";
    }

    //    使用map向request域对象共享数据
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("testRequestScope", "hello,Map");
        return "success";
    }

    //    testModelMap
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testRequestScope", "hello,ModelMap");
        return "success";
    }

    //    test servlet http session
    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    //

    /**
     * 向application域共享数据，也就是ServletCOntext中
     * applicaiton 代表整个应用中的范围
     * 整个工程都需要用到application时候，才会写application
     * <p>
     * 一般情况下选择requset和session
     * 列表，修改，回显，用到request功能，错误信息提示
     * session常用于保存用户登录状态，登录之后，只要浏览器不关闭，就表示当前状态下是登录成功
     * session默认最大存活时间是30分钟，一般情况下不需要改
     *
     * @param session
     * @return
     */

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "hello,application");
        return "success";
    }
}
