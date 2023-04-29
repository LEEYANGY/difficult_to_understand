package org.dragonwings.school.modular.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import org.dragonwings.school.framework.pojo.base.BaseUserTimeEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseUserTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 专业名,如计算机科学与技术...
     */
    private String profession;

    /**
     * 呢称
     */
    private String nickName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 账号状态 (0正常，1停用)
     */
    private String status;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 用户性别(0男，1女，2未知)
     */
    private String sex;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户类型(0管理员，1普通用户)
     */
    private String userType;

    /**
     * 删除标志(0代表未删除，1代表逻辑删除)
     */
    private Integer delFlag;


}
