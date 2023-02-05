package xyz.leeyangy.pojo;

/**
 * @Package: xyz.leeyangy.pojo
 * @Author: LEEYANGYANG
 * @Create: 2022/10/11 15:02
 * @Description:
 */
public class User {
    private String name;
    private Integer id;

//    public User() {
//    }

    public User(String name, Integer id) {
        System.out.println("---- 使用了有参构造 ----");
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
