package org.dragonwings.school.modular.system.service;

import org.dragonwings.school.modular.system.entity.Event;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 自助审批事件表 服务类
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-02
 */
public interface EventService extends IService<Event> {

    /**
     * @Param: [sponsor_id]
     * @return: java.util.List<org.dragonwings.school.modular.system.entity.Event>
     * @Author: liyangyang
     * @Date: 2023/5/2 22:07
     * @Description: 查询指定人的申请记录
     */
    List<Event> getAllBySponsorId(String sponsor_id);
}
