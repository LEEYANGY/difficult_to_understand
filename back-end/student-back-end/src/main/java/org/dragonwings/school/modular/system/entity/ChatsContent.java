package org.dragonwings.school.modular.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import org.dragonwings.school.framework.pojo.base.BaseUserTimeEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 聊天室信息
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("chats_content")
public class ChatsContent extends BaseUserTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 聊天记录ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联聊天室ID
     */
    private Long cid;

    /**
     * 发送人
     */
    private Long fromUserId;

    /**
     * 消息
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
