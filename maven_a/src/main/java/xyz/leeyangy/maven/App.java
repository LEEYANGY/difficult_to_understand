package xyz.leeyangy.maven;

/**
 * 依赖传递原则：
 *     在 A 依赖 B 依赖 C 的前提下，C 是否能够传递依赖到 A，取决于 B 依赖 C 时候使用的依赖范围以及配置
 *        B 依赖 C 使用的是 compile 范围，可以传递，
 *        B 依赖 C 使用的是 test 或 provided 范围，不能传递，所以需要这样的jar包时， 就必须在需要的地方明确配置依赖才可以
 *        B 依赖 C 时，若配置了以下标签，则不能传递
 *
 *        <dependency>
 *             <groupId>org.junit.jupiter</groupId>
 *             <artifactId>junit-jupiter-api</artifactId>
 *             <version>5.10.1</version>
 *             <scope>test</scope>
 *             <optional>test</optional>
 *         </dependency>
 *
 *
 *     依赖传递终止：
 *        非 compile 范围进行依赖传递
 *        使用 optional 配置终止传递
 *        依赖冲突（传递的依赖已经存在）
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
