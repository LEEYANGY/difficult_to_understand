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

@FeignClient(value = "event-service",path = "/system/event")
public interface EventFeignService {

    /**
    * @Param: [sponsor_id]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 21:47
    * @Description: 查询用户的申请记录数
    */
    @GetMapping("/getTotal/{sponsor_id}")
    public ResponseData getTotal(@PathVariable("sponsor_id") String sponsor_id);

    /**
    * @Param: [sponsor_id, page, limit]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 21:48
    * @Description: 查询用户的申请记录数
    */
    @GetMapping("/getMyCafeRecord/{sponsor_id}/{page}/{limit}")
    public ResponseData getMyCafeRecord(@PathVariable("sponsor_id") String sponsor_id,
                                        @PathVariable("page") Integer page,
                                        @PathVariable("limit") Integer limit);


}
