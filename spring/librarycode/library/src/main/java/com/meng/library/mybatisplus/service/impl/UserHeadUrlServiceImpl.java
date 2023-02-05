package com.meng.library.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meng.library.mybatisplus.entiy.User;
import com.meng.library.mybatisplus.entiy.UserHeadUrl;
import com.meng.library.mybatisplus.mapper.UserHeadUrlMapper;
import com.meng.library.mybatisplus.param.UserHeadUrlParam;
import com.meng.library.mybatisplus.result.UserHeadUrlResult;
import com.meng.library.mybatisplus.service.UserHeadUrlService;
import com.meng.library.mybatisplus.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserHeadUrlServiceImpl extends ServiceImpl<UserHeadUrlMapper, UserHeadUrl> implements UserHeadUrlService {

    @Autowired
    private UserService userService;

    @Override
    public Page<UserHeadUrlResult> pageUserUrlResult(UserHeadUrlParam userHeadUrlParam) {
        //条件构造器
        QueryWrapper<UserHeadUrlResult> queryWrapper = new QueryWrapper<>();
        //分页插件
        Page page = new Page(userHeadUrlParam.getPageNo(),userHeadUrlParam.getPageSize());
        //名字
        if (ObjectUtils.isNotEmpty(userHeadUrlParam.getAccount())){
            queryWrapper.like("a.account",userHeadUrlParam.getAccount());
        }
        //状态
        if (ObjectUtils.isNotEmpty(userHeadUrlParam.getState())){
            queryWrapper.like("a.state",userHeadUrlParam.getState());
        }
        return this.baseMapper.pageUserHeadUrlJoin(page,queryWrapper);
    }

    @Override
    @Transactional
    public void register(UserHeadUrlParam userHeadUrlParam) {
        if (ObjectUtils.isNotEmpty(userHeadUrlParam)){
            //插入User表
            User user = new User();
            BeanUtils.copyProperties(userHeadUrlParam,user);
            boolean info = userService.save(user);
            //获取User id 插入UserHeadUrl
            if (info){
                Long userId = user.getId();
                userHeadUrlParam.setUserId(userId);
                UserHeadUrl userHeadUrl = new UserHeadUrl();
                BeanUtils.copyProperties(userHeadUrlParam,userHeadUrl);
                this.save(userHeadUrl);
            }
        }
    }
}
