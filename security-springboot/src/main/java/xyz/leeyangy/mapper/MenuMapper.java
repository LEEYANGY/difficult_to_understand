package xyz.leeyangy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import xyz.leeyangy.pojo.Menu;

import java.util.List;

/**
 * @Author liyangyang
 * @Date: 2023/04/02 19:23
 * @Package xyz.leeyangy.mapper
 * @Version 1.0
 * @Description: 权限菜单
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(Long userId);

}
