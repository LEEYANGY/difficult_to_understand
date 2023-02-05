package xyz.leeyangy.dao;

import xyz.leeyangy.pojo.Department;

import java.util.List;

public interface DepartmentMapper {
    List<Department> findAllDepartment();
}
