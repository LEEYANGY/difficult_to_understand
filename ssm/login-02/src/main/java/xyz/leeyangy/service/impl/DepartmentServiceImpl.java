package xyz.leeyangy.service.impl;

import org.springframework.stereotype.Service;
import xyz.leeyangy.dao.DepartmentMapper;
import xyz.leeyangy.pojo.Department;
import xyz.leeyangy.service.DepartmentService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    public List<Department> findAllDepartment() {
        return departmentMapper.findAllDepartment();
    }
}
