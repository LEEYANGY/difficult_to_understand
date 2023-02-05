package xyz.leeyangy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Package: xyz.leeyangy.config
 * @Author: LEEYANGYANG
 * @Create: 2022/10/10 0:08
 * @Description:
 */
@Configuration //添加这个注解可以被spring扫描到
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String username;
    @Value("${jdbc.passwd}")
    private String passwd;

//    获取要管理的对象   把方法返回值写成bean
//    添加@Bean表示当前返回值是一个bena
    @Bean
    public DataSource dataSource(){
        DruidDataSource ds=new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(passwd);
        return ds;
    }
}
