package com.meng.library.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.meng.library.mybatisplus.entiy.UserHeadUrl;
import com.meng.library.mybatisplus.param.UserHeadUrlParam;
import com.meng.library.mybatisplus.result.UserHeadUrlResult;

public interface UserHeadUrlService extends IService<UserHeadUrl> {

    /**
     * 分页联表
     * @param userHeadUrlParam
     * @return
     */
    Page<UserHeadUrlResult> pageUserUrlResult(UserHeadUrlParam userHeadUrlParam);

    /**
     * 注册
     * @param userHeadUrlParam
     */
    void register(UserHeadUrlParam userHeadUrlParam);
}
