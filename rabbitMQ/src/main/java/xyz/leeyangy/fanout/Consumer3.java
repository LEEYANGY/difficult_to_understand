package xyz.leeyangy.fanout;

import com.rabbitmq.client.*;
import xyz.leeyangy.utils.RabbitMQUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author liyangyang
 * @Date: 2023/02/08/5:06
 * @Package xyz.leeyangy.fanout
 * @Version 1.0
 * @Description: 消费者获取消息
 */
public class Consumer3 {

    /**
     * @Param: []
     * @return: void
     * @Author: liyangyang
     * @Date: 2023/2/8 5:06
     * @Description: 测试消费者获取消息
     */
//    @Test
    public static void main(String[] args) throws IOException, TimeoutException {
//        创建连接
        Connection connection = RabbitMQUtil.getConnection();
//        创建通道
        Channel channel = connection.createChannel();
//        绑定交换机
        channel.exchangeDeclare("register","fanout");

//        临时队列
        String tempQueue = channel.queueDeclare().getQueue();

//        绑定交换机队列
        channel.queueBind(tempQueue,"register","");

//        消费消息
//        参数1: 消费那个队列消息
//        参数2: 开始消息的自动确认机制
//        参数3: 消费时回调接口
        channel.basicConsume(tempQueue, true, new DefaultConsumer(channel) {
            @Override
//            最后一个参数:消息队列中取出消息
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费消息："+new String(body));
            }
        });

//        关闭连接
//        RabbitMQUtil.closeConnectionAndChannel(channel, connection);
    }

}
