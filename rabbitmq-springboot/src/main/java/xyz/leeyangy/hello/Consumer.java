//package xyz.leeyangy.hello;
//
//import org.springframework.amqp.rabbit.annotation.Queue;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * @Author liyangyang
// * @Date: 2023/02/10/6:02
// * @Package xyz.leeyangy.hello
// * @Version 1.0
// * @Description: 一对一模型
// */
//
//@Component
//@RabbitListener(queuesToDeclare = @Queue(value = "hello", durable = "true", autoDelete = "true"))
//public class Consumer {
//
//    @RabbitHandler
//    public void receive(String message) {
//        System.out.println("message = " + message);
//    }
//}
