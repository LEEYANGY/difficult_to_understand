package xyz.leeyangy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author liyangyang
 * @Date: 2023/02/14 2:26
 * @Package xyz.leeyangy.pojo
 * @Version 1.0
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String password;
}
