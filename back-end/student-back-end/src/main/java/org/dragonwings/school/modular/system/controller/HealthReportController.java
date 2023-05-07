package org.dragonwings.school.modular.system.controller;


import org.dragonwings.school.framework.response.ResponseData;
import org.dragonwings.school.framework.socket.WebSocketServer;
import org.dragonwings.school.modular.system.entity.HealthReport;
import org.dragonwings.school.modular.system.service.HealthReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 日志记录
     */
    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);

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
        log.info("数据进来了{}", healthReport);
        if (healthReportService.save(healthReport)) {
            return ResponseData.success(200);
        } else {
            return ResponseData.error(500);
        }
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
        log.info("用户id===={},查询记录id===={}", userId, hid);
        return ResponseData.success(200);
    }

}

