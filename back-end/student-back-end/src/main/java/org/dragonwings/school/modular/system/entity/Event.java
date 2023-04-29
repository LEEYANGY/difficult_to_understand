package org.dragonwings.school.modular.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import org.dragonwings.school.framework.pojo.base.BaseUserTimeEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 自助审批事件表
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Event extends BaseUserTimeEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 事件主题
     */
    private String title;

    /**
     * 发起人工号
     */
    private String sponsorId;

    /**
     * 发起人姓名
     */
    private String sponsor;

    /**
     * 事件状态 (0正常，1停用)
     */
    private String status;


}
