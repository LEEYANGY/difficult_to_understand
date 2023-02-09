package xyz.leeyangy.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author liyangyang
 * @Date: 2023/02/10 6:47
 * @Package xyz.leeyangy.topic
 * @Version 1.0
 * @Description: 动态路由模型
 */

@Component
public class TopicConsumer {

    @RabbitListener(bindings = {
//            绑定消息队列
            @QueueBinding(
//                    获取队列
                    value = @Queue(durable = "true",autoDelete = "true"),
//                    绑定交换机
                    exchange = @Exchange(type = "topic", name = "topics"),
                    key = {"user.save","user.*"}
            )
    })
    public void receive1(String message) {
        System.out.println("消费者1: " + message);
    }

    @RabbitListener(bindings = {
//            绑定消息队列
            @QueueBinding(
//                    获取临时队列
                    value = @Queue,
//                    绑定交换机
                    exchange = @Exchange(type = "topic", name = "topics"),
                    key = {"order.#", "product.#", "user.*"}
            )
    })
    public void receive2(String message) {
        System.out.println("消费者2: " + message);
    }
}
