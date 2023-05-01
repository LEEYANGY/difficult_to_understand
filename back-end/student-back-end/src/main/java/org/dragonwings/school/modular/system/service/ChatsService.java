package org.dragonwings.school.modular.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;
import org.dragonwings.school.modular.system.entity.Chats;

/**
 * <p>
 * 聊天室信息 服务类
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-01
 */
public interface ChatsService extends IService<Chats> {

    /**
     * @Param: [id]
     * @return: org.dragonwings.school.modular.system.entity.Chats
     * @Author: liyangyang
     * @Date: 2023/5/1 2:58
     * @Description: 通过聊天室的id查询对应的聊天记录
     */
    Chats findChatContentByGid(Long gid);

    /**
     * @Param: [id]
     * @return: org.dragonwings.school.modular.system.entity.Chats
     * @Author: liyangyang
     * @Date: 2023/5/1 2:58
     * @Description: 通过聊天室的id查询对应的聊天记录
     */
    Chats subFindChatContentByGid(Long gid);

}
