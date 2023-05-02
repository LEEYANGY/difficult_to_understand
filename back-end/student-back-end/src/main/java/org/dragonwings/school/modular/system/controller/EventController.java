package org.dragonwings.school.modular.system.controller;


import org.dragonwings.school.framework.respone.ResponseData;
import org.dragonwings.school.modular.system.entity.Event;
import org.dragonwings.school.modular.system.service.EventService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/cafeAdd")
    public ResponseData cafeAdd(@RequestBody Event event){
        boolean save = eventService.save(event);
        if (!ObjectUtils.isEmpty(save)){
            return ResponseData.success(200,"添加成功",null);
        }
        return ResponseData.error(500,"添加失败",null);
    }
}

