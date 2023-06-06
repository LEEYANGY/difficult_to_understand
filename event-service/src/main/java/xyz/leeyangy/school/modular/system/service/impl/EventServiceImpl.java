package xyz.leeyangy.school.modular.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.ObjectUtils;
import xyz.leeyangy.school.framework.response.ResponseData;
import xyz.leeyangy.school.modular.system.entity.Event;
import xyz.leeyangy.school.modular.system.mapper.EventMapper;
import xyz.leeyangy.school.modular.system.service.EventService;
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

    /**
     * @Param: [event]
     * @return: xyz.leeyangy.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/6/6 2:05
     * @Description: 添加或修改
     */
    @Override
    public ResponseData cafeAdd(Event event) {
        System.out.println(event);
//        判断需要添加还是修改
        if (event.getId() != null) {
            if (baseMapper.updateById(event)>=1) {
                return ResponseData.success(200, "更新成功", null);
            }else {
                return ResponseData.error(500, "更新失败", null);
            }
        }else {
             if (baseMapper.insert(event)>=1) {
                return ResponseData.success(200, "添加成功", null);
            }else {
                 return ResponseData.error(500, "添加失败", null);
             }
        }
    }

    /**
    * @Param: [sponsorId]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 2:10
    * @Description: 查询用户的申请记录数
    */
    @Override
    public ResponseData getTotal(String sponsorId) {
        if (sponsorId.equals("") || sponsorId == null) {
            return ResponseData.error(500, "传递参数有误，请检查", null);
        } else {
            //        获取符合条件的记录数
            Integer count = new LambdaQueryChainWrapper<Event>(baseMapper)
                    .eq(Event::getSponsorId, sponsorId)
                    .count();
            return ResponseData.success(200, "获取记录数成功", count);
        }
    }

    /**
    * @Param: [event]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 2:21
    * @Description: 更新
    */
    @Override
    public ResponseData updateRecord(Event event) {
        if (!ObjectUtils.isEmpty(event) && event.getId() != 0) {
            if (baseMapper.updateById(event)>=1) {
                return ResponseData.success(200, "更新成功", null);
            }else {
                return ResponseData.error(500, "更新失败", null);
            }
        } else {
            return ResponseData.error(404, "没有该资源", null);
        }
    }


    /**
    * @Param: [id]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 2:23
    * @Description: 查询我的申请记录
    */
    @Override
    public ResponseData getMyCafeDetailRecord(Integer id) {
        Event event = baseMapper.selectOne(new QueryWrapper<Event>().eq("id", id));
        if (!ObjectUtils.isEmpty(event)) {
            return ResponseData.success(200, "资源请求成功", event);
        } else {
            return ResponseData.error(404, "请求资源不存在", event);
        }
    }


    /**
    * @Param: [sponsorId, page, limit]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 2:26
    * @Description: 分页查询我的神奇记录
    */
    @Override
    public ResponseData getMyCafeRecord(String sponsorId, Integer page, Integer limit) {
        //        将错误的设置自动调整
        if (sponsorId == null) return ResponseData.error(500, "错误参数", null);
        if (page == null || page < 1) page = 1;
        if (limit == null || limit <= 1) limit = 10;
        List<Event> list = new LambdaQueryChainWrapper<Event>(baseMapper)
                .eq(Event::getSponsorId, sponsorId)
                .list();
        return ResponseData.success(200, "获取成功", list);
    }
}
