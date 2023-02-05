package com.meng.library.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meng.library.mybatisplus.entiy.User;
import com.meng.library.mybatisplus.mapper.UserMapper;
import com.meng.library.mybatisplus.param.UserParam;
import com.meng.library.mybatisplus.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public Page<User> page(UserParam userParam) {
        //分页插件
        Page<User> page = new Page<>(userParam.getPageNo(), userParam.getPageSize());
        return this.page(page);
    }

    @Override
    public Page<User> pageSearch(UserParam userParam) {
        //条件构造器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //分页插件
        Page<User> page = new Page<>(userParam.getPageNo(), userParam.getPageSize());
        //账号
        if (ObjectUtils.isNotEmpty(userParam.getAccount())) {
            queryWrapper.lambda().eq(User::getAccount, userParam.getAccount());
        }
        //状态
        if (ObjectUtils.isNotEmpty(userParam.getState())) {
            queryWrapper.lambda().eq(User::getState, userParam.getState());
        }
        //时间区间查询
        if (ObjectUtils.isNotEmpty(userParam.getStartTime()) && ObjectUtils.isNotEmpty(userParam.getEndTime())) {
            queryWrapper.lambda().ge(User::getCreateTime, userParam.getStartTime());
            queryWrapper.lambda().le(User::getCreateTime, userParam.getEndTime());
        }
        return this.page(page, queryWrapper);
    }

    @Override
    public boolean edit(UserParam userParam) {
        User user = new User();
        BeanUtils.copyProperties(userParam, user);
        return this.save(user);
    }

    @Override
    public boolean update(UserParam userParam) {
        //条件构造器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getId, userParam.getId());
        User user = new User();
        BeanUtils.copyProperties(userParam, user);
        return this.update(user, queryWrapper);
    }

    @Override
    public boolean delete(UserParam userParam) {
        //条件构造器
        return this.removeById(userParam.getId());
    }
}
