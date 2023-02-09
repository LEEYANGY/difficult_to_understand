package xyz.leeyangy.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author liyangyang
 * @Date: 2023/02/10 6:24
 * @Package xyz.leeyangy.fanout
 * @Version 1.0
 * @Description: 广播模型
 */

@Component
public class FanoutConsumer {

    @RabbitListener(bindings = {
//            绑定消息队列
            @QueueBinding(
//                    创建临时队列
                    value = @Queue,
//                    绑定交换机
                    exchange = @Exchange(value = "logs", type = "fanout")
            )
    })
    public void receive1(String message) {
        System.out.println("消费者1: " + message);
    }

    @RabbitListener(bindings = {
//            绑定消息队列
            @QueueBinding(
//                    创建临时队列
                    value = @Queue,
//                    绑定交换机
                    exchange = @Exchange(value = "logs", type = "fanout")
            )
    })
    public void receive2(String message) {
        System.out.println("消费者2: " + message);
    }

}
