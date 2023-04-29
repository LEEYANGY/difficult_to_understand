package org.dragonwings.school.modular.system.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import org.dragonwings.school.framework.pojo.base.BaseUserTimeEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 成绩表
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CourseScore extends BaseUserTimeEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联学生id
     */
    private String userId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程成绩
     */
    private BigDecimal degree;

    /**
     * 成绩状态状态 (0正常，1毕业)
     */
    private String status;


}
