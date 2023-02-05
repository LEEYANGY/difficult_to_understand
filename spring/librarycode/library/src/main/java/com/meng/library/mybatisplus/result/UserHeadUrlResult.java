package com.meng.library.mybatisplus.result;


import com.meng.library.utils.base.BaseResult;
import lombok.Data;

@Data
public class UserHeadUrlResult extends BaseResult {

    /**
     * 主键
     */
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
     * 状态
     */
    private Integer state;
}
