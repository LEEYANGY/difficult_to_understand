package xyz.leeyangy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Package: xyz.leeyangy.config
 * @Author: LEEYANGYANG
 * @Create: 2022/10/9 20:56
 * @Description:
 */
//配置注解
@Configuration
//单个properties
//@PropertySource("db.properties")
//多个properties
@PropertySource({"classpath:db.properties"})
//需要扫描的包 ,加上{}可以写多个包
@ComponentScan({"xyz.leeyangy.service","xyz.leeyangy.dao"})
public class SpringConfig {
}
