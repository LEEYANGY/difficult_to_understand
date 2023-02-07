package xyz.leeyangy.helloworld.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

/**
 * @Author liyangyang
 * @Date: 2023/02/08/5:31
 * @Package xyz.leeyangy.helloworld.utils
 * @Version 1.0
 * @Description: RabbitMQ 连接工具类
 */
public class RabbitMQUtil {

    //  创建连接工厂
    private static ConnectionFactory connectionFactory;

    static {
//        静态代码块,在类加载时候执行一次(因为开销特别大,故写到静态代码块中)
        connectionFactory = new ConnectionFactory();
//            设置主机
        connectionFactory.setHost("localhost");
//          设置端口
        connectionFactory.setPort(5672);
//           设置虚拟机
        connectionFactory.setVirtualHost("/null");
//           设置用户名和密码
        connectionFactory.setUsername("null");
        connectionFactory.setPassword("null");
    }

    //    定义提供连接对象方法
    public static Connection getConnection() {
        try {
//            建立连接
            return connectionFactory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //    定义关闭连接方法
    public static void closeConnectionAndChannel(Channel channel, Connection connection) {
        try {
            if (channel != null) channel.close();
            if (connection != null) connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
