package org.dragonwings.school.modular.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import org.dragonwings.school.framework.pojo.base.BaseUserTimeEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 健康信息上报
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class HealthReport extends BaseUserTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 广播ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 申报用户ID
     */
    private Long sponsorId;

    /**
     * 发布人姓名
     */
    private String sponsor;

    /**
     * 申报主题
     */
    private String title;

    /**
     * 申报内容
     */
    private String subject;

    /**
     * 申报状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;

    /**
     * 备注
     */
    private String remark;


}
