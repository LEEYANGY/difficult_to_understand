package org.dragonwings.school.modular.system.entity;

import org.dragonwings.school.framework.pojo.base.BaseUserTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 班级关联老师表
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TeacherClass extends BaseUserTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 班级ID
     */
    private Long classId;


}
