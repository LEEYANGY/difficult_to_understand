package xyz.leeyangy;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RabbitmqSpringbootApplication.class)
@RunWith(SpringRunner.class)
class RabbitmqSpringbootApplicationTests {

    //	注入rabbitmqTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //	一对一模型
    @Test
    public void testHello() {
        rabbitTemplate.convertAndSend("hello", "hello world");
    }

    //    一对多模型
    @Test
    public void testWork() {
        for (int i = 1; i < 11; ++i) rabbitTemplate.convertAndSend("work", "work模型 " + i);
    }

    //    发布订阅 fanout模型
    @Test
    public void testFanOut() {
        rabbitTemplate.convertAndSend("logs", "", "fanout 模型发送消息 ");
    }

    //    路由模式
    @Test
    public void testRoute() {
        rabbitTemplate.convertAndSend("directs", "error", "路由模式");
    }

    //    topic 动态路由模式
    @Test
    public void testTopic() {
        rabbitTemplate.convertAndSend("topics", "user.save", "user.save 路由消息");
    }
}
