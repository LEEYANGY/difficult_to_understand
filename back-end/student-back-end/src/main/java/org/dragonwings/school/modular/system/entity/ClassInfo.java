package org.dragonwings.school.modular.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import org.dragonwings.school.framework.pojo.base.BaseUserTimeEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 班级表
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ClassInfo extends BaseUserTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 班级id
     */
    private Long classId;

    /**
     * 班级名
     */
    private String className;

    /**
     * 班级状态 (0正常，1停用)
     */
    private String status;

    /**
     * 删除标志(0代表未删除，1代表逻辑删除)
     */
    private Integer delFlag;

    /**
     * 备注
     */
    private String remark;


}
