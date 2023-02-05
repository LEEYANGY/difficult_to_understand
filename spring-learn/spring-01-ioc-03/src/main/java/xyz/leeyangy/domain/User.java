package xyz.leeyangy.domain;

import lombok.Data;

/**
 * @Package: xyz.leeyangy.domain
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 16:35
 * @Description:
 */
@Data
public class User {
    private Integer id;
    private String name;

    public User() {
        System.out.println("--- 使用了无参构造 ---");
    }

    public User(Integer id, String name) {
        System.out.println("--- 使用了有参构造 ---");
        this.id = id;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
        System.out.println("--- 使用了set注入 id ---");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("--- 使用了set注入 name ---");
    }
}
