package org.dragonwings.school.modular.system.service.impl;

import org.dragonwings.school.modular.system.entity.Event;
import org.dragonwings.school.modular.system.mapper.EventMapper;
import org.dragonwings.school.modular.system.service.EventService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 自助审批事件表 服务实现类
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-02
 */
@Service
public class EventServiceImpl extends ServiceImpl<EventMapper, Event> implements EventService {

}
