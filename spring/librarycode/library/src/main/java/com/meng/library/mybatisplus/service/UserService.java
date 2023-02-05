package com.meng.library.mybatisplus.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.meng.library.mybatisplus.entiy.User;
import com.meng.library.mybatisplus.param.UserParam;


/**
 * @author Nemo
 * @date 2021/06/29
 */
public interface UserService extends IService<User> {

    /**
     * 分页数据
     *
     * @param userParam
     * @return
     */
    Page<User> page(UserParam userParam);

    /**
     * 分页条件查询
     *
     * @param userParam
     * @return
     */
    Page<User> pageSearch(UserParam userParam);

    /**
     * 添加
     *
     * @return
     */
    boolean edit(UserParam userParam);

    /**
     * 更新
     *
     * @param userParam
     * @return
     */
    boolean update(UserParam userParam);

    /**
     * 删除
     *
     * @param userParam
     * @return
     */
    boolean delete(UserParam userParam);
}
