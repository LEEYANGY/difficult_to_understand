package xyz.leeyangy.school.modular.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import xyz.leeyangy.school.framework.response.ResponseData;
import xyz.leeyangy.school.modular.system.entity.HealthReport;
import xyz.leeyangy.school.modular.system.service.HealthReportService;

import javax.annotation.Resource;

/**
 * <p>
 * 健康信息上报 前端控制器
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-02
 */
@RestController
@RequestMapping("/system/health")
public class HealthReportController {

    @Resource
    HealthReportService healthReportService;

    /***
     * @Param: [healthReport]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/7 20:11
     * @Description: 健康信息上报接口
     */
    @PostMapping("/healthReport")
    public ResponseData healthReport(@RequestBody HealthReport healthReport) {
        return healthReportService.addHealthReport(healthReport);
    }

    /***
     * @Param: [userId, hid]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/7 20:14
     * @Description: 该接口是复用
     *
     *      hid查询自己的记录id，如果为空默认给自己全部数据
     *      hid不为空，查询指定记录
     */
    @GetMapping("/getHealthRecord/{userId}/{hid}")
    public ResponseData getHealthRecord(@PathVariable Long userId, @PathVariable Long hid) {
        return healthReportService.getHealthRecordDetail(userId,hid);
    }

    // TODO 管理员
    /**
     * @Param: [id]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/10 1:36
     * @Description: 获取用户的健康详细信息
     */
    @GetMapping("/admin/getUserHealthDetailById/{id}")
    public ResponseData getUserHealthDetailById(@PathVariable Long id) {
        return ResponseData.success(
                200,
                "获取成功",
                healthReportService.getById(id));
    }

    @GetMapping("/admin/getHealthTotal")
    public ResponseData getHealthTotal(){
        return ResponseData.success(200,"获取成功",healthReportService.count());
    }

    @GetMapping("/admin/getAllUserHealth/{page}/{limit}")
    public ResponseData getAllUserHealth(@PathVariable Integer page, @PathVariable Integer limit) {
        if (page == null || page < 1) page = 1;
        if (limit == null || limit <= 1) limit = 10;
//        分页查询
//        Page<HealthReport> healthReportPage = healthReportService.page(new Page<HealthReport>(page, limit), new QueryWrapper<HealthReport>().orderByDesc("id"));
        return ResponseData.success(
                200, "获取成功",
                healthReportService.page(new Page<HealthReport>(page, limit),
                        new QueryWrapper<HealthReport>().orderByDesc("id")));
    }

    /**
     * @Param: [id]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/10 2:35
     * @Description: 删除
     */
    @DeleteMapping("/admin/delUserHealthById/{id}")
    public ResponseData delUserHealthById(@PathVariable Long id) {
        if (id == 0 && healthReportService.getById(id) == null) {
            return ResponseData.error(501);
        } else {
            return ResponseData.success(200, "删除成功", healthReportService.removeById(id));
        }
    }

}

