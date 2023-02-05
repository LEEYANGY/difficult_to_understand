package xyz.leeyangy;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.leeyangy.config.SpringConfig;

import javax.sql.DataSource;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testDs(){
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource);
    }
}

