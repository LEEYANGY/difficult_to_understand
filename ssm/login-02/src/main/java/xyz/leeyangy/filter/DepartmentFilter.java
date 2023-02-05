package xyz.leeyangy.filter;


import org.springframework.context.annotation.Configuration;
import xyz.leeyangy.pojo.Department;
import xyz.leeyangy.service.DepartmentService;

import javax.annotation.Resource;
import javax.servlet.*;
import java.io.IOException;
import java.util.List;

@Configuration("departFilter")
public class DepartmentFilter implements Filter {

    @Resource
    private DepartmentService departmentService;

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("---- deptFilter init ----");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---- deptFilter doFilter ----");
        //        获取部门
        List<Department> list = departmentService.findAllDepartment();
        servletRequest.setAttribute("list",list);
        for (Department department:list) System.out.println(department);
//        请求向下传递
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
