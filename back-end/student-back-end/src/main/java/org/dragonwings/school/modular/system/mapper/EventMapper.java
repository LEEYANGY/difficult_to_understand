package org.dragonwings.school.modular.system.mapper;

import org.dragonwings.school.modular.system.entity.Event;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 自助审批事件表 Mapper 接口
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-02
 */
public interface EventMapper extends BaseMapper<Event> {

    /**
    * @Param: [sponsor_id]
    * @return: java.util.List<org.dragonwings.school.modular.system.entity.Event>
    * @Author: liyangyang
    * @Date: 2023/5/2 22:07
    * @Description: 查询指定人的申请记录
    */
    List<Event> getAllBySponsorId(String sponsor_id);

}
