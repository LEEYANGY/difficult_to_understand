package xyz.leeyangy.school.modular.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.ObjectUtils;
import xyz.leeyangy.school.framework.response.ResponseData;
import xyz.leeyangy.school.framework.response.ResponseResult;
import xyz.leeyangy.school.modular.system.entity.Zone;
import xyz.leeyangy.school.modular.system.mapper.ZoneMapper;
import org.springframework.stereotype.Service;
import xyz.leeyangy.school.modular.system.service.ZoneService;

/**
 * <p>
 * 校园动态表 服务实现类
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
@Service
public class ZoneServiceImpl extends ServiceImpl<ZoneMapper, Zone> implements ZoneService {

    /**
     * @Param: [page, limit]
     * @return: xyz.leeyangy.school.framework.response.ResponseResult
     * @Author: liyangyang
     * @Date: 2023/6/6 1:35
     * @Description:
     */
    @Override
    public ResponseResult getAllArticleByPage(Integer page, Integer limit) {

        //        防止错误传递
        if (page == null || page < 1) page = 1;
        if (limit == null || limit <= 1) limit = 10;

//        分页查询
        Page<Zone> pages = new Page<>(page, limit);
        QueryWrapper<Zone> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        //        zoneService
        Page<Zone> zonePage = baseMapper.selectPage(pages, queryWrapper);
        return new ResponseResult(200, "资源请求成功", zonePage);
    }

    /**
     * @Param: [userId, page, limit]
     * @return: xyz.leeyangy.school.framework.response.ResponseResult
     * @Author: liyangyang
     * @Date: 2023/6/6 1:41
     * @Description: 分页查询我的动态内容
     */
    @Override
    public ResponseResult getMyArticleByPage(Long userId, Integer page, Integer limit) {
        //        防止错误传递
        if (page == null || page < 1) page = 1;
        if (limit == null || limit <= 1) limit = 10;

//        分页查询
        Page<Zone> zonePage =
                new LambdaQueryChainWrapper<Zone>(baseMapper)
                        .eq(Zone::getSponsorId, userId)
                        .orderByDesc(Zone::getId)
                        .page(new Page<>(page, limit));

        return new ResponseResult(200, "资源请求成功", zonePage);
    }


    /**
     * @Param: [id]
     * @return: xyz.leeyangy.school.framework.response.ResponseResult
     * @Author: liyangyang
     * @Date: 2023/6/6 1:52
     * @Description: 查询动态内容
     */
    @Override
    public ResponseResult getDetailById(Integer id) {

//        查询详细内容
        Zone detail = new LambdaQueryChainWrapper<Zone>(baseMapper)
                .eq(Zone::getId, id)
                .one();
//        非空判断
        if (!ObjectUtils.isEmpty(detail)) {
            System.out.println(detail);
            return new ResponseResult(200, "资源请求成功", detail);
        } else {
            return new ResponseResult(404, "请求资源不存在", null);
        }
    }

    /**
     * @Param: [zone]
     * @return: xyz.leeyangy.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/6/6 1:55
     * @Description: 添加或修改动态内容
     */
    @Override
    public ResponseData addZone(Zone zone) {
        //        id == 0 || id == null 就认为是需要添加，反正修改
        if (zone.getId() == 0 || zone.getId() == null) {
//            重置id，让数据库给它自增
            zone.setId(null);
            if (baseMapper.insert(zone) >= 1) {
                return ResponseData.success(200, "添加成功", null);
            } else {
                return ResponseData.success(500, "添加失败", null);
            }
//            这里是需要修改
        } else {
            if (baseMapper.update(zone, new QueryWrapper<Zone>().eq("id", zone.getId())) >= 1) {
                return ResponseData.success(200, "修改成功", null);
            } else {
                return ResponseData.error(500, "修改失败", null);
            }
        }
    }
}
