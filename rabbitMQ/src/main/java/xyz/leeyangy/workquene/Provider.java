package xyz.leeyangy.workquene;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;
import xyz.leeyangy.utils.RabbitMQUtil;

import java.io.IOException;

/**
 * @Author liyangyang
 * @Date: 2023/02/09/23:52
 * @Package xyz.leeyangy.workquene
 * @Version 1.0
 * @Description:
 */
public class Provider {

    @Test
    public void testProvider() throws IOException {
//        获取连接
        Connection connection = RabbitMQUtil.getConnection();
//        获取通道
        Channel channel = connection.createChannel();

//        通过通道声明队列
        channel.queueDeclare("work", true, false, false, null);

//        生产消息
        for (int i = 1; i < 11; ++i) channel.basicPublish("", "work", null, (i+"：hello work").getBytes());

//        关闭连接
        RabbitMQUtil.closeConnectionAndChannel(channel, connection);
    }
}
