package xyz.leeyangy.security_learn1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xyz.leeyangy.security_learn1.mapper")
public class SecurityLearn1Application {

    public static void main(String[] args) {
        SpringApplication.run(SecurityLearn1Application.class, args);
    }

}
