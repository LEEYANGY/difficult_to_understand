package com.meng.library.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meng.library.mybatisplus.entiy.UserHeadUrl;
import com.meng.library.mybatisplus.result.UserHeadUrlResult;
import org.apache.ibatis.annotations.Param;

public interface UserHeadUrlMapper extends BaseMapper<UserHeadUrl> {

    Page<UserHeadUrlResult> pageUserHeadUrlJoin(@Param("page")Page page, @Param("ew")QueryWrapper queryWrapper);
}
