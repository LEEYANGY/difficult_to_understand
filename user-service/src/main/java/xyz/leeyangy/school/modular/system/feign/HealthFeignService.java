package xyz.leeyangy.school.modular.system.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.leeyangy.school.framework.response.ResponseData;

/**
 * @Author liyangyang
 * @Date: 2023/06/06 21:46
 * @Package xyz.leeyangy.school.modular.system.feign
 * @Version 1.0
 * @Description: 远程调用功能
 */

@FeignClient(value = "health-service",path = "/system/health")
public interface HealthFeignService {

    /**
    * @Param: [userId, hid]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 21:48
    * @Description: 查询自己的所有记录
    */
    @GetMapping("/getHealthRecord/{userId}/{hid}")
    public ResponseData getHealthRecord(@PathVariable("userId") Long userId,
                                        @PathVariable("hid") Long hid);

}
