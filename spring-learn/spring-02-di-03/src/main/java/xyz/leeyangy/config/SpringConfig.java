package xyz.leeyangy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @Package: xyz.leeyangy.config
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 19:08
 * @Description:
 */
//配置注解
@Configuration
@ComponentScan("xyz.leeyangy")
@PropertySource("classpath:db.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {
}

