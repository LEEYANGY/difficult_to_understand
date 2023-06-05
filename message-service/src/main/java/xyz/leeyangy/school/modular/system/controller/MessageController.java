package xyz.leeyangy.school.modular.system.controller;


import xyz.leeyangy.school.framework.response.ResponseData;
import xyz.leeyangy.school.modular.system.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 广播消息message 前端控制器
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-01
 */
@RestController
@RequestMapping("/system/message")
public class MessageController {

    @Resource
    MessageService messageService;

    @GetMapping
    public ResponseData getMessage(){
        return ResponseData.success(200,"获取成功",messageService.list());
    }

}

