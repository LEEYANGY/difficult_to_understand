package org.dragonwings;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author liyangyang
 * @Date: 2023/04/03 23:44
 * @Package org.dragonwings
 * @Version 1.0
 * @Description:
 */
public class StudentServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(StudentApplication.class);
    }
}
