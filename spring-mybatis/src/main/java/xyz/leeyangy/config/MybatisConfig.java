package xyz.leeyangy.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @Package: xyz.leeyangy.config
 * @Author: LEEYANGYANG
 * @Create: 2022/10/10 8:48
 * @Description:
 */
public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean ssfb=new SqlSessionFactoryBean();
//        配置别名
        ssfb.setTypeAliasesPackage("xyz.leeyangy.domain");
//        配置数据源
        ssfb.setDataSource(dataSource);
        return ssfb;
    }
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc=new MapperScannerConfigurer();
//        映射mapper
        msc.setBasePackage("xyz.leeyangy.dao");
        return msc;
    }

}
/**
 *     引入外部db.properties  -- 旧配置
 *     <properties resource="db.properties"/>
 *     此过程已经在SpringConfig中配置
 *     <settings>
 *        日志
 *         <setting name="logImpl" value="STDOUT_LOGGING"/>
 *     </settings>
 *     起别名  -- 旧配置
 *     <typeAliases>
 *         <package name="xyz.leeyangy.domain"/>
 *     </typeAliases>
 *     起别名  -- 旧配置
 *
 *     配置开发环境
 *     <environments default="mysql">
 *         <environment id="mysql">
 *             事务管理
 *             <transactionManager type="JDBC"/>
 *
 *             数据源 -- 旧配置
 *             <dataSource type="POOLED">
 *                 连接信息
 *                 <property name="driver" value="${jdbc.driver}"/>
 *                 <property name="url" value="${jdbc.url}"/>
 *                 <property name="username" value="${jdbc.user}"/>
 *                 <property name="password" value="${jdbc.passwd}"/>
 *             </dataSource>
 *             数据源 -- 旧配置
 *
 *         </environment>
 *     </environments>
 *
 *     引用mapper.xml文件  -- 旧配置
 *     <mappers>
 *         <mapper resource="mappers/AccountMapper.xml"/>
 *     </mappers>
 *     引用mapper.xml文件  -- 旧配置
 *
 * </configuration>
 */