package xyz.leeyangy.school.modular.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.leeyangy.school.framework.response.ResponseData;
import xyz.leeyangy.school.modular.system.entity.HealthReport;
import xyz.leeyangy.school.modular.system.mapper.HealthReportMapper;
import xyz.leeyangy.school.modular.system.service.HealthReportService;

/**
 * <p>
 * 健康信息上报 服务实现类
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-02
 */
@Service
public class HealthReportServiceImpl extends ServiceImpl<HealthReportMapper, HealthReport> implements HealthReportService {
    /**
    * @Param: [healthReport]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 0:28
    * @Description: TODO 该接口可以复用
    */
    @Override
    public ResponseData addHealthReport(HealthReport healthReport) {
        // 插入成功返回受影响行数》=1即为成功
        if (baseMapper.insert(healthReport)==1) {
            return ResponseData.success(200);
        } else {
            return ResponseData.error(500);
        }
    }

    /**
    * @Param: [userId, hid]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 0:37
    * @Description: 获取健康信息详细信息
    */
    @Override
    public ResponseData getHealthRecordDetail(Long userId, Long hid) {

        HealthReport healthRecordDetail = new LambdaQueryChainWrapper<HealthReport>(baseMapper)
                .eq(HealthReport::getSponsorId, userId)
                .eq(HealthReport::getId, hid)
                .one();
        if (!ObjectUtil.isNull(healthRecordDetail)){
            return ResponseData.success(200,"获取成功",healthRecordDetail);
        }else {
            return ResponseData.error(404,"请求内容不存在",null);
        }

    }
}
