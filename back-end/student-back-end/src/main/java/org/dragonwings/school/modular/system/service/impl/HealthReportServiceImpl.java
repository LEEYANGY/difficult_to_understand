package org.dragonwings.school.modular.system.service.impl;

import org.dragonwings.school.modular.system.entity.HealthReport;
import org.dragonwings.school.modular.system.mapper.HealthReportMapper;
import org.dragonwings.school.modular.system.service.HealthReportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
