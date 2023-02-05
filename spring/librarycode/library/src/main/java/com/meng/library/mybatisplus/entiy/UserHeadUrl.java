package com.meng.library.mybatisplus.entiy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.meng.library.utils.base.BaseEntiy;
import lombok.Data;


@Data
@TableName("user_head_url")
public class UserHeadUrl extends BaseEntiy {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户头像
     */
    private String userHeadImg;

}
