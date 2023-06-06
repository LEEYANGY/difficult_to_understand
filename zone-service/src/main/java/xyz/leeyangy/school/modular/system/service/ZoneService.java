package xyz.leeyangy.school.modular.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fasterxml.jackson.core.JsonProcessingException;
import xyz.leeyangy.school.framework.response.ResponseData;
import xyz.leeyangy.school.framework.response.ResponseResult;
import xyz.leeyangy.school.modular.system.entity.Zone;

/**
 * <p>
 * 校园动态表 服务类
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
public interface ZoneService extends IService<Zone> {

    /**
    * @Param: [page, limit]
    * @return: xyz.leeyangy.school.framework.response.ResponseResult
    * @Author: liyangyang
    * @Date: 2023/6/6 1:34
    * @Description: 分页查询所有动态记录
    */
    ResponseResult getAllArticleByPage(Integer page, Integer limit);

    /**
    * @Param: [userId, page, limit]
    * @return: xyz.leeyangy.school.framework.response.ResponseResult
    * @Author: liyangyang
    * @Date: 2023/6/6 1:40
    * @Description: 分页查询我的动态记录
    */
    ResponseData getMyArticleByPage(Long userId, Integer page, Integer limit);

    /**
    * @Param: [id]
    * @return: xyz.leeyangy.school.framework.response.ResponseResult
    * @Author: liyangyang
    * @Date: 2023/6/6 1:48
    * @Description: 查询动态详细信息
    */
    ResponseResult getDetailById(Integer id);

    /**
    * @Param: [zone]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 1:55
    * @Description: 添加或修改动态
    */
    ResponseData addZone(Zone zone);
}
