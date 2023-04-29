package org.dragonwings.school.modular.system.service.impl;

import org.dragonwings.school.modular.system.entity.UserClass;
import org.dragonwings.school.modular.system.mapper.UserClassMapper;
import org.dragonwings.school.modular.system.service.UserClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生关联班级表 服务实现类
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
@Service
public class UserClassServiceImpl extends ServiceImpl<UserClassMapper, UserClass> implements UserClassService {

}
