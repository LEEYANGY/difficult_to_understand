package org.dragonwings.school.modular.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;
import org.dragonwings.school.modular.system.entity.ChatsContent;

import java.util.List;

/**
 * <p>
 * 聊天室信息 服务类
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-01
 */
public interface ChatsContentService extends IService<ChatsContent> {
    /**
     * @Param: [id]
     * @return: java.util.List<org.dragonwings.school.modular.system.entity.ChatsContent>
     * @Author: liyangyang
     * @Date: 2023/5/1 17:32
     * @Description: 通过关联cid查询对应的聊天记录
     */
    List<ChatsContent> subGetAllContentByCid(Long cid);
}
