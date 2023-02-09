package xyz.leeyangy.workquene;

import com.rabbitmq.client.*;
import xyz.leeyangy.utils.RabbitMQUtil;

import java.io.IOException;

/**
 * @Author liyangyang
 * @Date: 2023/02/10/0:38
 * @Package xyz.leeyangy.workquene
 * @Version 1.0
 * @Description:
 */
public class Consumer1 {
    public static void main(String[] args) throws IOException {
//        获取连接
        Connection connection = RabbitMQUtil.getConnection();
//        获取频道
        Channel channel = connection.createChannel();

//        绑定队列
        channel.queueDeclare("work",true,false,false,null);
//        获取消息
        channel.basicConsume("work",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费消息====>"+new String(body));
            }
        });
//        关闭连接
//        RabbitMQUtil.closeConnectionAndChannel(channel,connection);
    }
}
