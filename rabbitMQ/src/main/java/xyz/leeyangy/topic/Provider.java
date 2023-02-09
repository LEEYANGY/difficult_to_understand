package xyz.leeyangy.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;
import xyz.leeyangy.utils.RabbitMQUtil;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * @Author liyangyang
 * @Date: 2023/02/08/4:24
 * @Package xyz.leeyangy.topic
 * @Version 1.0
 * @Description: 生产者代码
 */
public class Provider {

    /**
     * @Param: []
     * @return: void
     * @Author: liyangyang
     * @Date: 2023/2/8 4:26
     * @Description: 生产消息代码
     */
    @Test
    public void testProvider() throws IOException, TimeoutException {
//        创建连接
        Connection connection = RabbitMQUtil.getConnection();
//        获取连接通道
        Channel channel = connection.createChannel();

//        将声明通道指定交换机
//        参数1：交换机名称
//        参数2：交换机类型  direct 路由模式
//        参数3：
//        参数4：
        channel.exchangeDeclare("topics", "topic");

//        发送消息
        String routingKey = "save.user.ok";

//        发布消息
//        参数1： 交换机名称
//        参数2： 路由键
//        参数3： 消息额外设置
//        参数4: 消息具体内容
        channel.basicPublish("topics", routingKey, null, ("这是topic模型发布的，基于route key{ " + routingKey +" "+ new Date() +" }发送消息").getBytes());
//        关闭连接
        RabbitMQUtil.closeConnectionAndChannel(channel, connection);
    }
}
