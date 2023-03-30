package xyz.leeyangy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author liyangyang
 * @Date: 2023/03/30 12:16
 * @Package xyz.leeyangy.pojo
 * @Version 1.0
 * @Description: 角色和菜单关联表
 */

@TableName(value = "sys_role_menu")
public class RoleMenu {

    /**
     * 角色ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;
    /**
     * 菜单ID
     */
    @TableField(value = "role_id")
    private Long roleId;
}
