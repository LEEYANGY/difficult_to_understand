package com.meng.library.mybatisplus.entiy;


import com.baomidou.mybatisplus.annotation.*;
import com.meng.library.utils.base.BaseEntiy;
import lombok.Data;

/**
 * 用户
 *
 * @data 2021/06/28 16:29
 */
@Data
@TableName("user")
public class User extends BaseEntiy {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态  1/0 启用、禁用
     */
    private Integer state;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer deleted;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;
}
