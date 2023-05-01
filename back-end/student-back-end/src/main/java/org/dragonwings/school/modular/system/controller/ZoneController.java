package org.dragonwings.school.modular.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.dragonwings.school.framework.respone.ResponseData;
import org.dragonwings.school.framework.socket.WebSocketServer;
import org.dragonwings.school.modular.system.entity.Chats;
import org.dragonwings.school.modular.system.entity.ChatsContent;
import org.dragonwings.school.modular.system.entity.Zone;
import org.dragonwings.school.modular.system.mapper.ChatsContentMapper;
import org.dragonwings.school.modular.system.mapper.ChatsMapper;
import org.dragonwings.school.modular.system.mapper.ZoneMapper;
import org.dragonwings.school.modular.system.service.ChatsService;
import org.dragonwings.school.modular.system.service.ZoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    ChatsMapper chatsMapper;

    @Resource
    ChatsContentMapper chatsContentMapper;

    /**
     * 日志记录
     */
    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);

    /**
     * 分页查询
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/getAllArticle/{page}/{limit}")
    public ResponseData getAllArticle(@PathVariable Integer page, @PathVariable Integer limit) {
        System.out.println("请求了动态接口");
        if (page == null || page < 1) {
            page = 1;
        }
        System.out.println("page====" + page + "==== limit====" + limit);
//        获取总记录
        int count = zoneService.count();

        if (page >= (count / limit + 1)) {
            System.out.println("超过最大页码");
//            return ResponseData.error(401, "超出最大页码范围", null);
        }
        if (limit == null || limit <= 1) {
            limit = 10;
        }
//        分页查询
        Page<Zone> pages = new Page<>(page, limit);
        QueryWrapper<Zone> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
//        zoneService
        Page<Zone> zonePage = zoneMapper.selectPage(pages, queryWrapper);
        return ResponseData.success(200, "资源请求成功", zonePage);
    }

    @GetMapping("/getMaxTotal")
    public ResponseData getMaxTotal() {
        return ResponseData.success(200, "获取成功", zoneService.count());
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

    //    查询所有聊天记录
    @GetMapping("/getChatContent/{gid}")
//    @PreAuthorize("@myExpression.hasAuthority('student')")
    public ResponseData getChatContent(@PathVariable Long gid) {
        log.info("请求了获取某群组的全部聊天接口");
        if (gid != null) {
//            Chats chats = chatsService.findChatContentByGid(gid);
//            组装多条件查询
//            Chats chats = chatsMapper.subFindChatContentByGid(gid);
//            if (!ObjectUtils.isEmpty(chats)) {
//                log.info("群id：{}",chats.getId());
//                List<ChatsContent> chatsContents = chatsContentMapper.subGetAllContentByCid(chats.getId());
//                if (!ObjectUtils.isEmpty(chatsContents)) {
//                    chats.setChatsContentList(chatsContents);
//                    return ResponseData.success(200, "请求资源成功", chats);
//                }
//            } else {
//                return ResponseData.error(404, "请求资源不存在", null);
//            }
            Chats chats = chatsService.subFindChatContentByGid(gid);
            if (!ObjectUtils.isEmpty(chats)){
                return ResponseData.success(200, "请求资源成功", chats);
            }else {
                return ResponseData.error(404, "请求资源不存在", null);
            }
        }
        return ResponseData.error(500, "请求异常，请联系管理员", null);
    }
//    获取所有在线成员
//    @GetMapping()

}

