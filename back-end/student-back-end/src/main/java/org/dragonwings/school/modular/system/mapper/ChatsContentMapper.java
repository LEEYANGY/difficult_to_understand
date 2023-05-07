package org.dragonwings.school.modular.system.mapper;

import org.apache.ibatis.annotations.Select;
import org.dragonwings.school.modular.system.entity.ChatsContent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 聊天室信息 Mapper 接口
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-01
 */
public interface ChatsContentMapper extends BaseMapper<ChatsContent> {

    /**
     * @Param: [id]
     * @return: java.util.List<org.dragonwings.school.modular.system.entity.ChatsContent>
     * @Author: liyangyang
     * @Date: 2023/5/1 17:32
     * @Description: 通过关联cid查询对应的聊天记录
     */
    @Select("select * from sys_chats_content where cid=#{cid}")
    List<ChatsContent> subGetAllContentByCid(Long cid);



}
