package xyz.leeyangy.framework.modular.system.entity;

import lombok.Data;

/**
 * @Package: xyz.leeyangy.domain
 * @Author: LEEYANGYANG
 * @Create: 2022/10/31 19:14
 * @Description:
 */
@Data
public class User {

    private String username;
    private String password;
    private String token;
}
