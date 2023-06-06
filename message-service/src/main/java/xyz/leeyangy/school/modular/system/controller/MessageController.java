package xyz.leeyangy.school.modular.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import xyz.leeyangy.school.framework.response.ResponseData;
import xyz.leeyangy.school.modular.system.entity.Message;
import xyz.leeyangy.school.modular.system.service.MessageService;

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

    /**
    * @Param: []
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 15:12
    * @Description: 查询全部
    */
    @GetMapping
    public ResponseData getMessage(){
        return ResponseData.success(200,"获取成功",messageService.list());
    }

    @GetMapping("/admin/getTotal")
    public ResponseData getTotal(){
        return ResponseData.success(200,"获取成功",messageService.count());
    }

    /**
     * @Param: [message]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/10 2:55
     * @Description: 新增/修改 复用接口
     */
    @PostMapping("/admin/editMessage")
    public ResponseData editMessage(@RequestBody Message message) {
//        id==0是新增
        if (message.getId() == 0) {
            messageService.save(message);
        } else {
            messageService.updateById(message);
        }
        return ResponseData.success(200);
    }

    /***
     * @Param: [id]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/10 2:55
     * @Description: 通过id删除通知
     */
    @DeleteMapping("/admin/delMessage/{id}")
    public ResponseData delMessage(@PathVariable Long id) {
        if (id == 0 || messageService.getById((id)) == null) {
            return ResponseData.error(501);
        }
        return ResponseData.success(200, "删除成功", messageService.removeById(id));
    }

    /**
    * @Param: [id]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 13:36
    * @Description:
    */
    @GetMapping("/admin/getDetail/{id}")
    public ResponseData getDetail(@PathVariable Long id) {
        if (id==0){
            return ResponseData.error(404,"请求资源不存在",null);
        }
        return ResponseData.success(
                200,
                "获取成功",
                messageService.getById(id));
    }

}

