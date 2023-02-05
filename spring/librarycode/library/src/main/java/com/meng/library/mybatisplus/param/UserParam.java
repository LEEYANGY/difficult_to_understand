package com.meng.library.mybatisplus.param;

import com.meng.library.utils.base.BaseParam;
import lombok.Data;

/**
 * @author Nemo
 * @date 2021/06/29
 */
@Data
public class UserParam extends BaseParam {


    /**
     * 主键
     */
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

}
