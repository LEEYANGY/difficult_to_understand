package xyz.leeyangy.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author liyangyang
 * @Date: 2023/02/10 6:12
 * @Package xyz.leeyangy.work
 * @Version 1.0
 * @Description: 一对多模型
 */

@Component
public class WorkConsumer {

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive1(String message) {
        System.out.println("消费者1: " + message);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String message) {
        System.out.println("消费者2: " + message);
    }

}
