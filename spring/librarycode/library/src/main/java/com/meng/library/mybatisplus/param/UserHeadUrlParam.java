package com.meng.library.mybatisplus.param;

import com.meng.library.utils.base.BaseParam;
import lombok.Data;

@Data
public class UserHeadUrlParam extends BaseParam {

    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户头像
     */
    private String userHeadImg;

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
}
