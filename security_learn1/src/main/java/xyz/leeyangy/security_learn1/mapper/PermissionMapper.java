package xyz.leeyangy.security_learn1.mapper;

import java.security.Permission;
import java.util.List;


import org.apache.ibatis.annotations.Select;
import xyz.leeyangy.security_learn1.entity.PermissionEntity;


public interface PermissionMapper {

    @Select(" select * from sys_permission ")
    List<PermissionEntity> findAllPermission();

}
