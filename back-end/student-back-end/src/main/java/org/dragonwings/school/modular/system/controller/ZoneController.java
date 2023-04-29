package org.dragonwings.school.modular.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.dragonwings.school.framework.respone.ResponseData;
import org.dragonwings.school.modular.system.entity.Zone;
import org.dragonwings.school.modular.system.mapper.ZoneMapper;
import org.dragonwings.school.modular.system.service.ZoneService;
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
        System.out.println("page===="+page+"==== limit===="+limit);
//        获取总记录
        int count = zoneService.count();

        if (page >= (count / limit +1)) {
            System.out.println("超过最大页码");
//            return ResponseData.error(401, "超出最大页码范围", null);
        }

        if (limit == null || limit <= 1) {
            limit = 10;
        }

//        分页查询
        Page<Zone> pages = new Page<>(page,limit);
        QueryWrapper<Zone> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
//        zoneService
        Page<Zone> zonePage = zoneMapper.selectPage(pages, queryWrapper);
        return ResponseData.success(200, "资源请求成功", zonePage);
    }

    @GetMapping("/getMaxTotal")
    public ResponseData getMaxTotal() {
        int count = zoneService.count();
        System.out.println("==== 获取最大记录数 ====" + count);
        return ResponseData.success(200, "获取成功", count);
    }

    @GetMapping("/getDetail/{id}")
    public ResponseData getDetail(@PathVariable Integer id) {
        System.out.println("请求了动态详细接口" + "   id=" + id);
        Zone detail = zoneService.getOne(new QueryWrapper<Zone>().eq("id", id));
        if (!ObjectUtils.isEmpty(detail)) {
            System.out.println(detail);
            return ResponseData.success(200, "资源请求成功", detail);
        } else {
            return ResponseData.error(404, "请求资源不存在", null);
        }
    }
}

