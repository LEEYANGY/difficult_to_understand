package org.dragonwings.school.modular.system.mapper;

import org.apache.ibatis.annotations.Select;
import org.dragonwings.school.modular.system.entity.Chats;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 聊天室信息 Mapper 接口
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-01
 */
public interface ChatsMapper extends BaseMapper<Chats> {

    /**
     * @Param: [id]
     * @return: org.dragonwings.school.modular.system.entity.Chats
     * @Author: liyangyang
     * @Date: 2023/5/1 2:58
     * @Description: 通过聊天室的id查询对应的聊天记录
     */
    Chats findChatContentByGid(Long gid);

    @Select("select * from chats where gid=#{gid}")
    Chats subFindChatContentByGid(Long gid);
}
