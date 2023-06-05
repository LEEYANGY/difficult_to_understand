package xyz.leeyangy.school.modular.system.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.leeyangy.school.framework.pojo.base.BaseUserTimeEntity;

/**
 * <p>
 * 角色和菜单关联表
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleMenu extends BaseUserTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;


}
