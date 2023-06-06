package xyz.leeyangy.school.modular.system.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.leeyangy.school.framework.response.ResponseData;
import xyz.leeyangy.school.framework.response.ResponseResult;

/**
 * @Author liyangyang
 * @Date: 2023/06/06 20:49
 * @Package xyz.leeyangy.school.modular.system.feign
 * @Version 1.0
 * @Description: 远程调用功能
 */

@FeignClient(value = "zone-service",path = "/system/zone")
public interface ZoneFeignService {

    /**
    * @Param: [userId]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 21:39
    * @Description: 获取用户最大记录数
    */
    @GetMapping("/getUserMaxTotal/{userId}")
    public ResponseData getUserMaxTotal(@PathVariable("userId") Long userId);

    /**
    * @Param: [userId, page, limit]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 21:39
    * @Description: 分页查询用户动态
    */
    @GetMapping("/getMyArticle/{userId}/{page}/{limit}")
    public ResponseData getMyArticle(@PathVariable("userId") Long userId, @PathVariable("page") Integer page, @PathVariable("limit") Integer limit);

}
