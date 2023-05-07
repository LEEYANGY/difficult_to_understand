package org.dragonwings.school.modular.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import org.dragonwings.school.framework.pojo.base.BaseUserTimeEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <p>
 * 聊天室信息
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_chats")
public class Chats extends BaseUserTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 聊天室ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 查找聊天室的UID
     */
    private Long gid;

    /**
     * 聊天室名称
     */
    private String roomName;

    /**
     * 聊天室简介
     */
    private String roomDescription;

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


    /**
     *  对应的聊天记录,不参与查询，但将查询结果塞到该类中
     */
    @TableField(exist = false)
    private List<ChatsContent> chatsContentList;
}
