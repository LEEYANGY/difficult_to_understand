package xyz.leeyangy.school.modular.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import xyz.leeyangy.school.framework.response.ResponseData;
import xyz.leeyangy.school.modular.system.entity.Event;
import xyz.leeyangy.school.modular.system.service.EventService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 自助审批事件表 前端控制器
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
@RestController
@RequestMapping("/system/event")
public class EventController {


    @Resource
    EventService eventService;

    /**
     * @Param: [event]
     * @return: org.dragonwings.school.framework.respone.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/2 21:36
     * @Description: 自助申请  TODO 待测试
     */
    @PostMapping("/cafeAdd")
    public ResponseData cafeAdd(@RequestBody Event event) {
        return eventService.cafeAdd(event);
    }


    /**
     * @Param: [sponsor_id]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/3 2:20
     * @Description: 查询用户的申请记录数
     */
    @GetMapping("/getTotal/{sponsor_id}")
    public ResponseData getTotal(@PathVariable String sponsor_id) {
        return eventService.getTotal(sponsor_id);
    }

    /**
     * @Param: [sponsor_id, page, limit]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/3 2:20
     * @Description: 分页查询
     */
    @GetMapping("/getMyCafeRecord/{sponsor_id}/{page}/{limit}")
    public ResponseData getMyCafeRecord(@PathVariable String sponsor_id, @PathVariable Integer page, @PathVariable Integer limit) {
        return eventService.getMyCafeRecord(sponsor_id,page,limit);
    }

    @GetMapping("/getMyCafeDetailRecord/{id}")
    public ResponseData getMyCafeDetailRecord(@PathVariable Integer id) {
        return eventService.getMyCafeDetailRecord(id);
    }

    /**
    * @Param: [event]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 2:22
    * @Description: 更新 TODO 待测试
    */
    @PutMapping("/updateRecord")
    public ResponseData updateRecord(@RequestBody Event event) {
        return eventService.updateRecord(event);
    }
}

