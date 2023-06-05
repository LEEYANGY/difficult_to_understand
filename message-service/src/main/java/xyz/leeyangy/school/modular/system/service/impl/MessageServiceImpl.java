package xyz.leeyangy.school.modular.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import xyz.leeyangy.school.modular.system.entity.Message;
import xyz.leeyangy.school.modular.system.mapper.MessageMapper;
import org.springframework.stereotype.Service;
import xyz.leeyangy.school.modular.system.service.MessageService;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * <p>
 * 广播消息message 服务实现类
 * </p>
 *
 * @author liyangyang
 * @since 2023-05-01
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
