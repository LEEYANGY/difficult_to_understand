package org.dragonwings.school.modular.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dragonwings.school.modular.system.entity.ChatsContent;
import org.dragonwings.school.modular.system.mapper.ChatsContentMapper;
import org.dragonwings.school.modular.system.service.ChatsContentService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 聊天室信息 服务实现类
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-01
 */
@Service
public class ChatsContentServiceImpl extends ServiceImpl<ChatsContentMapper, ChatsContent> implements ChatsContentService {

    @Resource
    ChatsContentMapper chatsContentMapper;

    /**
     * @param cid
     * @Param: [id]
     * @return: java.util.List<org.dragonwings.school.modular.system.entity.ChatsContent>
     * @Author: liyangyang
     * @Date: 2023/5/1 17:32
     * @Description: 通过关联cid查询对应的聊天记录
     */
    @Override
    public List<ChatsContent> subGetAllContentByCid(Long cid) {
        QueryWrapper<ChatsContent> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("cid",cid);
        List<ChatsContent> list = baseMapper.selectList(queryWrapper);
        return list;
    }
}
