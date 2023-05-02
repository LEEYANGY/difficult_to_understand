package org.dragonwings.school.modular.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.dragonwings.school.modular.system.entity.Event;
import org.dragonwings.school.modular.system.mapper.EventMapper;
import org.dragonwings.school.modular.system.service.EventService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * @param sponsor_id
     * @Param: [sponsor_id]
     * @return: java.util.List<org.dragonwings.school.modular.system.entity.Event>
     * @Author: liyangyang
     * @Date: 2023/5/2 22:07
     * @Description: 查询指定人的申请记录
     */
    @Override
    public List<Event> getAllBySponsorId(String sponsor_id) {
        QueryWrapper<Event> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sponsor_id", sponsor_id);
        queryWrapper.orderByDesc("id");
        List<Event> events = baseMapper.selectList(queryWrapper);
        return events;
    }
}
