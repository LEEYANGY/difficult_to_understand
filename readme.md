[//]: # (文档有不足之处，以代码内部为准)
# 项目介绍
<H1> 通用权限管理 </H1>  

# 1.介绍  
权限管理是所有后台系统都会涉及的一个重要组成部分，而权限管理的核心流程是相似的，如果每个后
台单独开发一套权限管理系统，就是重复造轮子，是人力的极大浪费，本项目就是针对这个问题，提供
了一套通用的权限解决方案。
项目服务器端架构：SpringBoot + MyBatisPlus + SpringSecurity
前端架构：Node.js + Npm + Vue + ElementUI + Axios

# 2.核心技术

|    Component      |  Description    |
|    ----    |  ----    |
|  基础框架 (Framework)   |  SpringBoot  |
|  数据库 (Database)    |  MySQL  |
|  权限控制 (Security)    |  Spring Security  |
|  全局日志记录 (Logging)    |  AOP  |
|  前端模板 (Frontend Template)    |  vue-admin-template  |
|  前端技术 (Frontend Technologies)    | Node.js, Npm, Vue, ElementUI, Axios  |

## 搭建父子项目

整体层次架构:  
auth 根目录，管理子模块：  
├─.idea  
├─common通用模块 公共类父模块    
│  ├─common-log  系统操作日志模块  
│  ├─common-util 核心工具类  
│  └─service-util service模块工具类   
│  └─spring-security：spring-security业务模块  
├─model 实体类模块  
└─service-system 系统权限模块  

auth项目依赖进行版本锁定  
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>
<groupId>com.example</groupId>
<artifactId>auth-parent</artifactId>
<packaging>pom</packaging>
<version>1.0-SNAPSHOT</version>
<modules>
<module>common</module>
<module>model</module>
<module>service-system</module>
</modules>
<parent>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-parent</artifactId>
<version>2.3.6.RELEASE</version>
</parent>
<properties>
<java.version>1.8</java.version>
<alibaba.version>2.2.0.RELEASE</alibaba.version>
<mybatis-plus.version>3.4.1</mybatis-plus.version>
<mysql.version>8.0.25</mysql.version>
<knife4j.version>2.0.8</knife4j.version>
<jwt.version>0.7.0</jwt.version>
<fastjson.version>1.2.79</fastjson.version>
</properties>
<!--配置dependencyManagement锁定依赖的版本-->
<dependencyManagement>
<dependencies>
<!--mybatis-plus 持久层-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>${mybatis-plus.version}</version>
</dependency>
    <!--mysql-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>${mysql.version}</version>
    </dependency>
    <!--knife4j-->
    <dependency>
        <groupId>com.github.xiaoymin</groupId>
        <artifactId>knife4j-spring-boot-starter</artifactId>
        <version>${knife4j.version}</version>
    </dependency>
    <!--jjwt-->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt</artifactId>
        <version>${jwt.version}</version>
    </dependency>
    <!--fastjson-->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
        <version>${fastjson.version}</version>
    </dependency>
</dependencies>
</dependencyManagement>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```
common 公共父模块  
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
http://maven.apache.org/xsd/maven-4.0.0.xsd">
<parent>
    <artifactId>auth-parent</artifactId>
    <groupId>com.example</groupId>
    <version>1.0-SNAPSHOT</version>
</parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>common</artifactId>
    <packaging>pom</packaging>
    <modules>
        <module>service-util</module>
        <module>common-util</module>
    </modules>
</project>

```

common-util 模块  
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
http://maven.apache.org/xsd/maven-4.0.0.xsd">
<parent>
<artifactId>common</artifactId>
<groupId>com.example</groupId>
<version>1.0-SNAPSHOT</version>
</parent>
<modelVersion>4.0.0</modelVersion>
<artifactId>common-util</artifactId>
<packaging>jar</packaging>
<dependencies>
    <dependency>
        <groupId>org.example</groupId>
        <artifactId>model</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
    </dependency>
</dependencies>
</project>
```
service-util 模块  
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
http://maven.apache.org/xsd/maven-4.0.0.xsd">
<parent>
<artifactId>common</artifactId>
<groupId>com.example</groupId>
<version>1.0-SNAPSHOT</version>
</parent>
<modelVersion>4.0.0</modelVersion>
<artifactId>service-util</artifactId>
<dependencies>
    <dependency>
        <groupId>org.example</groupId>
        <artifactId>common-util</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
    </dependency>
    <!--mysql-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
    <!--    swagger文档-->
    <dependency>
        <groupId>com.github.xiaoymin</groupId>
        <artifactId>knife4j-spring-boot-starter</artifactId>
    </dependency>

</dependencies>
</project>
```
model 模块  
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
http://maven.apache.org/xsd/maven-4.0.0.xsd">
<parent>
<artifactId>auth-parent</artifactId>
<groupId>com.example</groupId>
<version>1.0-SNAPSHOT</version>
</parent>
<modelVersion>4.0.0</modelVersion>
<artifactId>model</artifactId>
    <dependencies>
        <!--lombok用来简化实体类-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-spring-boot-starter</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <scope>provided</scope>
        </dependency>
    </dependencies>
</project>
```

service-system 模块  
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
http://maven.apache.org/xsd/maven-4.0.0.xsd">
<parent>
<artifactId>auth-parent</artifactId>
<groupId>com.example</groupId>
<version>1.0-SNAPSHOT</version>
</parent>
<modelVersion>4.0.0</modelVersion>
<artifactId>service-system</artifactId>
<packaging>jar</packaging>
    <dependencies>
        <dependency>
            <groupId>org.example</groupId>
            <artifactId>service-util</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <build>
        <finalName>${project.artifactId}</finalName>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

```
service-system 模块
application.yml  
```yaml
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl # 查看日志

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/auth?characterEncoding=utf-8&useSSL=false
    username: root
    password: root
```
添加启动类  
```java
@MapperScan(basePackages = "com.example.system.mapper")
@SpringBootApplication
public class ServiceAuthApplication {
public static void main(String[] args) {
    SpringApplication.run(ServiceAuthApplication.class, args);
    }
}
```
model 实体类
```java
package com.example.model.system;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.model.base.BaseEntity;
import lombok.Data;
@Data
@TableName("sys_role")
public class SysRole extends BaseEntity {
    private static final long serialVersionUID = 1L;
    //角色名称
    @TableField("role_name")
    private String roleName;
    //角色编码
    @TableField("role_code")
    private String roleCode;
    //描述
    @TableField("description")
    private String description;
}

```
Mapper类  
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
}

修改 service-uitl 模块
```java
package com.example.system.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
import java.util.ArrayList;
import java.util.List;

/**
 * knife4j配置信息
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {
    @Bean
    public Docket adminApiConfig() {
        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("token")
                .description("用户token")
                .defaultValue("")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        pars.add(tokenPar.build());
//添加head参数end
        Docket adminApi = new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .apiInfo(adminApiInfo())
                .select()
//只显示admin路径下的页面
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .paths(PathSelectors.regex("/admin/.*"))
                .build()
                .globalOperationParameters(pars);
        return adminApi;
    }

    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("后台管理系统-API文档")
                .description("本文档描述了后台管理系统微服务接口定义")
                .version("1.0")
                .contact(new Contact("example", "http://example.com",
                        "example@qq.com"))
                .build();
    }
}
```
controller
```java
package com.example.system.controller;
import com.example.system.service.SysRoleService;
import com.example.common.R.R;
import com.example.model.system.SysRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    
    @ApiOperation(value = "获取全部角色列表")
    @GetMapping("findAll")
    public R<List<SysRole>> findAll() {
    List<SysRole> roleList = sysRoleService.list();
    return R.ok(roleList);
    }
}
```

统一返回类和全局异常拦截  
common-util  
```java
package com.example.common.result;
import lombok.Data;
/**
* 全局统一返回结果类
*
*/
@Data
public class R<T> {
    //返回码
    private Integer code;
    //返回消息
    private String message;
    //返回数据
    private T data;
    public R(){}
    // 返回数据
    protected static <T> R<T> build(T data) {
    R<T> R = new R<T>();
    if (data != null)
    R.setData(data);
    return R;
    }
    public static <T> R<T> build(T body, Integer code, String message) {
    R<T> R = build(body);
    R.setCode(code);
        R.setMessage(message);
        return R;
    }
    public static <T> R<T> build(T body, RCodeEnum RCodeEnum) {
        R<T> R = build(body);
        R.setCode(RCodeEnum.getCode());
        R.setMessage(RCodeEnum.getMessage());
        return R;
    }
    public static<T> R<T> ok(){
        return R.ok(null);
    }
    /**
     * 操作成功
     * @param data baseCategory1List
     * @param <T>
     * @return
     */
    public static<T> R<T> ok(T data){
        R<T> R = build(data);
        return build(data, RCodeEnum.SUCCESS);
    }
    public static<T> R<T> fail(){
        return R.fail(null);
    }
    /**
     * 操作失败
     * @param data
     * @param <T>
     * @return
     */
    public static<T> R<T> fail(T data){
        R<T> R = build(data);
        return build(data, RCodeEnum.FAIL);
    }
    public R<T> message(String msg){
        this.setMessage(msg);
        return this;
    }
    public R<T> code(Integer code){
        this.setCode(code);
        return this;
    }
}
```

```java
package com.example.common.result;
import lombok.Getter;
/**
 * 统一返回结果状态信息类
 *
 */
@Getter
public enum RCodeEnum {
    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    SERVICE_ERROR(2012, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    ILLEGAL_REQUEST(205, "非法请求"),
    REPEAT_SUBMIT(206, "重复提交"),
    ARGUMENT_VALID_ERROR(210, "参数校验异常"),
    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限"),
    ACCOUNT_ERROR(214, "账号不正确"),
    PASSWORD_ERROR(215, "密码不正确"),
    LOGIN_MOBLE_ERROR( 216, "账号不正确"),
    ACCOUNT_STOP( 217, "账号已停用"),
    NODE_ERROR( 218, "该节点下有子节点，不可以删除")
    ;
    private Integer code;
    private String message;
    private RCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
```

```java
package com.example.system.exception;
;
/**
* 全局异常处理类
*
*/
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.fail();
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.fail().message("执行了特定异常处理");
    }
    
    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public R error(AuthException e) {
        e.printStackTrace();
        return R.fail().message(e.getMessage()).code(e.getCode());
    }
}

```

创建自定义异常类  
```java
package com.example.system.execption;
import com.example.common.R.RCodeEnum;
import lombok.Data;
/**
 * 自定义全局异常类
 *
 */
@Data
public class AuthException extends RuntimeException {
    private Integer code;
    private String message;
    /**
     * 通过状态码和错误消息创建异常对象
     * @param code
     * @param message
     */
    public AuthException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    /**
     * 接收枚举类型对象
     * @param RCodeEnum
     */
    public AuthException(RCodeEnum RCodeEnum) {
        super(RCodeEnum.getMessage());
        this.code = RCodeEnum.getCode();
        this.message = RCodeEnum.getMessage();
    }
    @Override
    public String toString() {
        return "AuthException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
```





mp配置  
```java
package com.example.system.config;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import
        com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * MybatisPlus配置类
 *
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.example.system.mapper")
public class MybatisPlusConfig {
    /**
     *
     * @return
     */
    @Bean
    public MybatisPlusInterceptor addPaginationInnerInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//向Mybatis过滤器链中添加分页拦截器
        interceptor.addInnerInterceptor(new
                PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}

```




## MYSQL8
```mysql
create database auth;
use auth;
```
## 通用配置文件
```java


```

