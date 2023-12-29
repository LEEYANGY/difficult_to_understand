package xyz.leeyangy.maven.test.pojo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @ProjectName : maven_base
 * @Package : xyz.leeyangy.maven.test.pojo
 * @ClassName : MavenTest
 * @Author : leeyangy
 * @CreateTime : 2023/12/29 18:26
 * @Version : 1.0
 * @Description : 测试的类名最好是以Test开头或者Test结尾，方法名test开头
 * @Modify_log :
 */
public class MavenTest {

    @Test
    public void testAssert(){
        int a=10;
        int b=10;
//        Assertions.assertEquals(a+b,30);
        Assertions.assertEquals(a+b,20);
    }

}
