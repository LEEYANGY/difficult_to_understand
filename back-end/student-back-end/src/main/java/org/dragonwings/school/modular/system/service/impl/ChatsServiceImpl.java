package org.dragonwings.school.modular.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dragonwings.school.modular.system.entity.ChatsContent;
import org.dragonwings.school.modular.system.mapper.ChatsContentMapper;
import org.dragonwings.school.modular.system.mapper.ChatsMapper;
import org.dragonwings.school.modular.system.entity.Chats;
import org.dragonwings.school.modular.system.service.ChatsService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * <p>
 * 聊天室信息 服务实现类
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-01
 */
@Service
public class ChatsServiceImpl extends ServiceImpl<ChatsMapper, Chats> implements ChatsService {

    @Resource
    ChatsMapper chatsMapper;

    @Resource
    ChatsContentMapper chatsContentMapper;

    /**
     * @param gid
     * @Param: [id]
     * @return: org.dragonwings.school.modular.system.entity.Chats
     * @Author: liyangyang
     * @Date: 2023/5/1 2:58
     * @Description: 通过聊天室的id查询对应的聊天记录
     */
    @Override
    public Chats findChatContentByGid(Long gid) {
        return chatsMapper.findChatContentByGid(gid);
    }

    /**
     * @param gid
     * @Param: [id]
     * @return: org.dragonwings.school.modular.system.entity.Chats
     * @Author: liyangyang
     * @Date: 2023/5/1 2:58
     * @Description: 通过聊天室的id查询对应的聊天记录
     */
    @Override
    public Chats subFindChatContentByGid(Long gid) {
        QueryWrapper<Chats> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gid", gid);
        Chats chats = baseMapper.selectOne(queryWrapper);
        if (!ObjectUtils.isEmpty(chats)) {
            List<ChatsContent> chatsContents = chatsContentMapper.subGetAllContentByCid(chats.getId());
            if (!ObjectUtils.isEmpty(chatsContents)) {
                chats.setChatsContentList(chatsContents);
                return chats;
            } else {
                System.out.println("聊天记录为空");
                return chats;
            }
        } else {
            System.out.println("没有对应的群组");
            return null;
        }

    }
}
