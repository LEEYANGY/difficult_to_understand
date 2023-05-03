package org.dragonwings.school.modular.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.dragonwings.school.framework.response.ResponseData;
import org.dragonwings.school.framework.socket.WebSocketServer;
import org.dragonwings.school.modular.system.entity.Chats;
import org.dragonwings.school.modular.system.entity.Zone;
import org.dragonwings.school.modular.system.mapper.ZoneMapper;
import org.dragonwings.school.modular.system.service.ChatsService;
import org.dragonwings.school.modular.system.service.ZoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 校园动态表 前端控制器
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
@RestController
@RequestMapping("/system/zone")
public class ZoneController {

    @Resource
    ZoneService zoneService;

    @Resource
    ZoneMapper zoneMapper;

    @Resource
    ChatsService chatsService;

    /**
     * 日志记录
     */
    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);

    /**
     * @Param: [page, limit]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/3 1:26
     * @Description: 分页查询
     */
    @GetMapping("/getAllArticle/{page}/{limit}")
    public ResponseData getAllArticle(@PathVariable Integer page, @PathVariable Integer limit) {
//        防止错误传递
        if (page == null || page < 1) page = 1;
        if (limit == null || limit <= 1) limit = 10;

//        分页查询
        Page<Zone> pages = new Page<>(page, limit);
        QueryWrapper<Zone> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
//        zoneService
        Page<Zone> zonePage = zoneMapper.selectPage(pages, queryWrapper);
        return ResponseData.success(200, "资源请求成功", zonePage);
    }

    /**
     * @Param: []
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/3 1:26
     * @Description: 获取最大记录数
     */
    @GetMapping("/getMaxTotal")
    public ResponseData getMaxTotal() {
        return ResponseData.success(200, "获取成功", zoneService.count());
    }


    /**
     * @Param: [userId]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/3 23:17
     * @Description: 查询用户动态记录
     */
    @GetMapping("/getUserMaxTotal/{userId}")
    public ResponseData getUserMaxTotal(@PathVariable Long userId) {
        System.out.println(userId);
        return ResponseData.success(200, "获取成功", zoneService.count(new QueryWrapper<Zone>().eq("sponsor_id", userId)));
    }

    @GetMapping("/getMyArticle/{userId}/{page}/{limit}")
    public ResponseData getMyArticle(@PathVariable Long userId, @PathVariable Integer page, @PathVariable Integer limit) {
//        防止错误传递
        if (page == null || page < 1) page = 1;
        if (limit == null || limit <= 1) limit = 10;

//        分页查询
        Page<Zone> pages = new Page<>(page, limit);
        QueryWrapper<Zone> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sponsor_id", userId);
        queryWrapper.orderByDesc("id");
//        zoneService
        Page<Zone> zonePage = zoneMapper.selectPage(pages, queryWrapper);
        return ResponseData.success(200, "资源请求成功", zonePage);
    }

    @GetMapping("/getDetail/{id}")
    public ResponseData getDetail(@PathVariable Integer id) {
        Zone detail = zoneService.getOne(new QueryWrapper<Zone>().eq("id", id));
        if (!ObjectUtils.isEmpty(detail)) {
            System.out.println(detail);
            return ResponseData.success(200, "资源请求成功", detail);
        } else {
            return ResponseData.error(404, "请求资源不存在", null);
        }
    }

    /**
     * @Param: [zone]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/3 1:25
     * @Description: 这里服用了接口，在请求的时候进行id判断如果查不到数据，就做为添加
     */
    @PostMapping("/editZone")
    public ResponseData addZone(@RequestBody Zone zone) {
//        id == 0 || id == null 就认为是需要添加，反正修改
        if (zone.getId() == 0 || zone.getId() == null) {
//            重置id，让数据库给它自增
            zone.setId(null);
            if (zoneService.save(zone)) {
                return ResponseData.success(200, "添加成功", null);
            } else {
                return ResponseData.success(500, "添加失败", null);
            }
//            这里是需要修改
        } else {
            if (zoneService.update(zone, new QueryWrapper<Zone>().eq("id", zone.getId()))) {
                return ResponseData.success(200, "修改成功", null);
            } else {
                return ResponseData.error(500, "修改失败", null);
            }
        }
    }

    /**
     * @Param: [id]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/3 2:29
     * @Description: 通过id删除动态
     */
    @DeleteMapping("/delZone/{id}")
    public ResponseData delZone(@PathVariable Integer id) {
        if (zoneService.removeById(id)) {
            return ResponseData.success(200, "删除成功", null);
        } else {
            return ResponseData.error(500, "删除失败", null);
        }

    }

    /**
     * @Param: [gid]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/3 1:26
     * @Description: 查询所有聊天记录
     */
    @GetMapping("/getChatContent/{gid}")
//    @PreAuthorize("@myExpression.hasAuthority('student')")
    public ResponseData getChatContent(@PathVariable Long gid) {
        if (gid != null) {
            Chats chats = chatsService.subFindChatContentByGid(gid);
            if (!ObjectUtils.isEmpty(chats)) {
                return ResponseData.success(200, "请求资源成功", chats);
            } else {
                return ResponseData.error(404, "请求资源不存在", null);
            }
        }
        return ResponseData.error(500, "请求异常，请联系管理员", null);
    }
//    获取所有在线成员
//    @GetMapping()


}

