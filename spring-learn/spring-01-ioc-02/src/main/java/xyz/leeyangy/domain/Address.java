package xyz.leeyangy.domain;

/**
 * @Package: xyz.leeyangy.domain
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 13:18
 * @Description:
 */
public class Address {
    private String address;

    public Address() {
        System.out.println("---- address 无参构造 ----");
    }

    public Address(String address) {
        System.out.println("---- 有参构造 ----");
        this.address = address;
    }

    public void setAddress(String address) {
        System.out.println("---- set注入address ----");
        this.address = address;
    }
}
