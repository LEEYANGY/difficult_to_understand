package xyz.leeyangy.route;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author liyangyang
 * @Date: 2023/02/10 6:35
 * @Package xyz.leeyangy.route
 * @Version 1.0
 * @Description: 路由模型
 */

@Component
public class RouteConsumer {

    @RabbitListener(bindings = {
//            绑定消息队列
            @QueueBinding(
                    value = @Queue,
                    //  创建临时队列
                    exchange = @Exchange(value = "directs", type = "direct"),
                    key = {"info", "error", "warning"}

            )
    }
    )
    public void receive1(String message) {
        System.out.println("消费者1：" + message);
    }

    @RabbitListener(bindings = {
//            绑定消息队列
            @QueueBinding(
//                    创建临时队列
                    value = @Queue,
                    exchange = @Exchange(value = "directs", type = "direct"),
                    key = {"error"}
            )
    })
    public void receive2(String message) {
        System.out.println("消费者2: " + message);
    }


    @RabbitListener(bindings = {
//            绑定消息队列
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "directs", type = "direct"),
                    key = {"warning"}
            )
    })
    public void receive3(String message) {
        System.out.println("消费者3：" + message);
    }

}
