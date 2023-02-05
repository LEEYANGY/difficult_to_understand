package xyz.leeyangy.domain;

/**
 * @Package: xyz.leeyangy.domain
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 13:08
 * @Description:
 */
public class User {
    private Integer id;
    private String name;
    private Address address;

    public User() {
        System.out.println("---- 无参构造 ----");
    }

    public User(Integer id, String name, Address address) {
        System.out.println("---- 有参构造 ----");
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void setId(Integer id) {
        System.out.println("---- set注入id ----");
        this.id = id;
    }

    public void setName(String name) {
        System.out.println("---- set注入name ----");
        this.name = name;
    }

    public void setAddress(Address address) {
        System.out.println("---- set注入address ----");
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
