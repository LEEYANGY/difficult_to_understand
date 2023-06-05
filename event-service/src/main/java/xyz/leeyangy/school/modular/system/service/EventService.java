package xyz.leeyangy.school.modular.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.leeyangy.school.framework.response.ResponseData;
import xyz.leeyangy.school.modular.system.entity.Event;

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

    /**
    * @Param: [event]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 2:04
    * @Description: 添加或修改
    */
    ResponseData cafeAdd(Event event);


    /**
    * @Param: [sponsorId]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 2:10
    * @Description: 查询用户的申请记录数
    */
    ResponseData getTotal(String sponsorId);


    /**
    * @Param: [event]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 2:18
    * @Description: 更新
    */
    ResponseData updateRecord(Event event);

    /**
    * @Param: [id]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 2:23
    * @Description: 查询我的申请记录
    */
    ResponseData getMyCafeDetailRecord(Integer id);


    /**
    * @Param: [sponsorId, page, limit]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 2:26
    * @Description: 分页查询我的申请记录
    */
    ResponseData getMyCafeRecord(String sponsorId, Integer page, Integer limit);
}
