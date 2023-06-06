//package xyz.leeyangy.config;
//
//import com.alibaba.cloud.nacos.ribbon.NacosRule;
//import com.netflix.loadbalancer.IRule;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//
///**
// * @Author liyangyang
// * @Date: 2023/04/18 16:36
// * @Package xyz.leeyangy.config
// * @Version 1.0
// * @Description:
// */
//
//@Configuration
//public class RestTemplates {
//
//    @Bean
//    @LoadBalanced
//    public RestTemplate getRestTemplate(){
//        return new  RestTemplate();
//    }
//
//    // 权重
////    @Bean
////    public IRule getRule(){
////        return new NacosRule();
////    }
//}
