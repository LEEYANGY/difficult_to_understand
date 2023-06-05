package xyz.leeyangy.school.modular.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.leeyangy.school.framework.response.ResponseData;
import xyz.leeyangy.school.modular.system.entity.HealthReport;

/**
 * <p>
 * 健康信息上报 服务类
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-02
 */
public interface HealthReportService extends IService<HealthReport> {

    /**
    * @Param: [healthReport]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 0:35
    * @Description: 添加修改
    */
    ResponseData addHealthReport(HealthReport healthReport);

    /**
    * @Param: [userId, hid]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 0:35
    * @Description: 查询详细
    */
    ResponseData getHealthRecordDetail(Long userId, Long hid);
}
