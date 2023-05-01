package org.dragonwings.school.modular.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import org.dragonwings.school.framework.pojo.base.BaseUserTimeEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 广播消息message
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("message")
public class Message extends BaseUserTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 广播ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 发送用户ID
     */
    private Long author;

    /**
     * 消息主题
     */
    private String title;

    /**
     * 消息内容
     */
    private String subject;

    /**
     * 角色状态（0正常 1停用）
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
