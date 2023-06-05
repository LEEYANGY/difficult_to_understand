package xyz.leeyangy.school.modular.system.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.leeyangy.school.framework.pojo.base.BaseUserTimeEntity;

/**
 * <p>
 * 用户和角色关联表
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserRole extends BaseUserTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;


}
