package org.dragonwings.school.modular.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import org.dragonwings.school.framework.pojo.base.BaseUserTimeEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 校园动态表
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Zone extends BaseUserTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 圈子ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 事件名称
     */
    private String title;

    /**
     * 动态内容
     */
    private String content;

    /**
     * 发布人id
     */
    private String sponsorId;

    /**
     * 发布人姓名
     */
    private String sponsor;

    /**
     * 事件状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private Integer delFlag;

    /**
     * 备注
     */
    private String remark;


}
