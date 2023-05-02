package org.dragonwings.school.modular.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.dragonwings.school.framework.response.ResponseData;
import org.dragonwings.school.modular.system.entity.Event;
import org.dragonwings.school.modular.system.service.EventService;
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
     * @Description: 自助申请
     */
    @PostMapping("/cafeAdd")
    public ResponseData cafeAdd(@RequestBody Event event) {
        boolean save = eventService.save(event);
        if (!ObjectUtils.isEmpty(save)) {
            return ResponseData.success(200, "添加成功", null);
        }
        return ResponseData.error(500, "添加失败", null);
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
        if (sponsor_id.equals("") || sponsor_id == null) {
            return ResponseData.error(500, "传递参数有误，请检查", null);
        } else {
            //        获取符合条件的记录数
            QueryWrapper<Event> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("sponsor_id", sponsor_id);
            int count = eventService.count(queryWrapper);
            return ResponseData.success(200, "获取记录数成功", count);
        }
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
//        将错误的设置自动调整
        if (sponsor_id == null) return ResponseData.error(500, "错误参数", null);
        if (page == null || page < 1) page = 1;
        if (limit == null || limit <= 1) limit = 10;
        return ResponseData.success(200, "", eventService.getAllBySponsorId(sponsor_id));
    }

    @GetMapping("/getMyCafeDetailRecord/{id}")
    public ResponseData getMyCafeRecord(@PathVariable Integer id) {
        Event event = eventService.getOne(new QueryWrapper<Event>().eq("id", id));
        if (!ObjectUtils.isEmpty(event)) {
            return ResponseData.success(200, "资源请求成功", event);
        } else {
            return ResponseData.error(404, "请求资源不存在", event);
        }
    }

    @PutMapping("/updateRecord")
    public ResponseData updateRecord(@RequestBody Event event) {
        System.out.println(event);
        if (!ObjectUtils.isEmpty(event) && event.getId() != 0) {
            boolean b = eventService.updateById(event);
            if (b) {
                return ResponseData.success(200, "更新成功", null);
            }else {
                return ResponseData.error(500, "更新失败", null);
            }
        } else {
            return ResponseData.error(404, "没有该资源", null);
        }

    }
}

