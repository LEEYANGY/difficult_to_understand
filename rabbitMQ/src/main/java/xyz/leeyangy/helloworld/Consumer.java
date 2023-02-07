package xyz.leeyangy.helloworld;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author liyangyang
 * @Date: 2023/02/08/5:06
 * @Package xyz.leeyangy.helloworld
 * @Version 1.0
 * @Description: 消费者获取消息
 */
public class Consumer {

    /**
     * @Param: []
     * @return: void
     * @Author: liyangyang
     * @Date: 2023/2/8 5:06
     * @Description: 测试消费者获取消息
     */
//    @Test
    public static void main(String[] args) throws IOException, TimeoutException {
        //        创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
//        设置主机
        connectionFactory.setHost("localhost");
//        设置端口
        connectionFactory.setPort(5672);
//        设置虚拟机
        connectionFactory.setVirtualHost("/null");
//        设置用户名和密码
        connectionFactory.setPassword("null");
        connectionFactory.setUsername("null");

//        建立连接
        Connection connection = connectionFactory.newConnection();

//        创建通道
        Channel channel = connection.createChannel();
//        绑定消息队列
        channel.queueDeclare("hello", false, false, false, null);

//        消费消息
//        参数1: 消费那个队列消息
//        参数2: 开始消息的自动确认机制
//        参数3: 消费时回调接口
        channel.basicConsume("hello", true, new DefaultConsumer(channel) {
            @Override
//            最后一个参数:消息队列中取出消息
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        });

//        关闭连接  注释的话,该程序会一直等待消息
//        channel.close();
//        connection.close();

    }


}
