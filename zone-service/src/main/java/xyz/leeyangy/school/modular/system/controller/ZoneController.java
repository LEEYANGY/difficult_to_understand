package xyz.leeyangy.school.modular.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import xyz.leeyangy.school.framework.response.ResponseData;
import xyz.leeyangy.school.framework.response.ResponseResult;
import xyz.leeyangy.school.modular.system.entity.Zone;
import xyz.leeyangy.school.modular.system.mapper.ZoneMapper;
import xyz.leeyangy.school.modular.system.service.ZoneService;

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

    /**
     * @Param: [page, limit]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/3 1:26
     * @Description: 分页查询
     */
    @GetMapping("/getAllArticle/{page}/{limit}")
    public ResponseResult getAllArticle(@PathVariable Integer page, @PathVariable Integer limit) {
            return zoneService.getAllArticleByPage(page,limit);
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
    public ResponseData getUserMaxTotal(@PathVariable("userId") Long userId) {
        return ResponseData.success(200, "获取成功", zoneService.count(new QueryWrapper<Zone>().eq("sponsor_id", userId)));
    }

    /**
    * @Param: [userId, page, limit]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 1:33
    * @Description: 分页查询我的动态内容
    */
    @GetMapping("/getMyArticle/{userId}/{page}/{limit}")
    public ResponseData getMyArticle(@PathVariable("userId") Long userId, @PathVariable("page") Integer page, @PathVariable("limit") Integer limit) {
            return zoneService.getMyArticleByPage(userId,page,limit);
    }

    /**
    * @Param: [id]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 1:33
    * @Description: 获取动态详细信息
     * TODO 测试
    */
    @GetMapping("/getDetail/{id}")
    public ResponseResult getDetail(@PathVariable Integer id) {
       return zoneService.getDetailById(id);
    }

    /**
     * @Param: [zone]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/3 1:25
     * @Description: 这里服用了接口，在请求的时候进行id判断如果查不到数据，就做为添加
     * TODO 测试
     */
    @PostMapping("/editZone")
    public ResponseData addZone(@RequestBody Zone zone) {
        return zoneService.addZone(zone);
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
//        删除成功200，失败404
        return zoneService.removeById(id) ?
                ResponseData.success(200, "删除成功", null) :
                ResponseData.error(404, "删除失败", null);
    }

}

