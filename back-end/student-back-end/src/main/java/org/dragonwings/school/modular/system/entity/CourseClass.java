package org.dragonwings.school.modular.system.entity;

import org.dragonwings.school.framework.pojo.base.BaseUserTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class CourseClass extends BaseUserTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 班级关联ID
     */
    private Long classId;

    /**
     * 课程关联ID
     */
    private Long courseId;


}
