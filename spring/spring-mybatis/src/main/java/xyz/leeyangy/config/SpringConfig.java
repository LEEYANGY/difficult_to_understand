package xyz.leeyangy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @Package: xyz.leeyangy.config
 * @Author: LEEYANGYANG
 * @Create: 2022/10/9 20:56
 * @Description:
 */
//配置注解
@Configuration
@ComponentScan("xyz.leeyangy")
@PropertySource("classpath:db.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {
}
