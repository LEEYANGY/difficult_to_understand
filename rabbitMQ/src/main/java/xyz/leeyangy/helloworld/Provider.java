package xyz.leeyangy.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;
import xyz.leeyangy.helloworld.utils.RabbitMQUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author liyangyang
 * @Date: 2023/02/08/4:24
 * @Package xyz.leeyangy.helloworld
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

//        绑定对应消息队列
//        参数1： 队列名称，如果不存在，则自动创建
//        参数2：用来定义队列特性是否要持久化 true  持久化队列  false 不持久化
//        参数3：是否独占队列 true 独占，false 不独占
//        参数4： 是否在消费完成后自动删除队列 true 删除  false 不删除
//        参数5：额外附加参数
        channel.queueDeclare("hello", false, false, false, null);

//        发布消息
//        参数1：交换机名称
//        参数2： 队列名称
//        参数3：残敌消息额外设置
//        参数4: 消息具体内容
        channel.basicPublish("", "hello", null, "hello rabbitmq".getBytes());

//        关闭连接
        RabbitMQUtil.closeConnectionAndChannel(channel, connection);
    }
}
