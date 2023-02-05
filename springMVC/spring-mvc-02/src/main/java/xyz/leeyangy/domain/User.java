package xyz.leeyangy.domain;

import lombok.Data;

/**
 * @Package: xyz.leeyangy.domain
 * @Author: LEEYANGYANG
 * @Create: 2022/10/21 15:58
 * @Description:
 */
@Data
public class User {
    private String username;
    private String password;
    private String sex;
    private String age;
    private String email;
}
