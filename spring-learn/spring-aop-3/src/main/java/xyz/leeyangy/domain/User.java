package xyz.leeyangy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Package: xyz.leeyangy.domain
 * @Author: LEEYANGYANG
 * @Create: 2022/10/17 17:55
 * @Description:
 */
@Data
//添加无参构造方法
@NoArgsConstructor
//添加全参数构造方法
@AllArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String name;

//    public User() {
//    }

//    public User(Integer id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
}
