package xyz.leeyangy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Package: xyz.leeyangy.config
 * @Author: LEEYANGYANG
 * @Create: 2022/10/10 0:08
 * @Description:
 */
@Configuration
public class JdbcConfig {
    //    获取要管理的对象   把方法返回值写成bean
//    添加@Bean表示当前返回值是一个bena
    @Bean
    public DataSource dataSource(){
        DruidDataSource ds=new DruidDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/student_db?serverTimezone=PRC");
        ds.setUsername("");
        ds.setPassword("");
        return ds;
    }
}
