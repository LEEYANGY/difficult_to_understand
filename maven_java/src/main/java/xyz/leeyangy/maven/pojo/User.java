package xyz.leeyangy.maven.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ProjectName : maven_base
 * @Package : xyz.leeyangy.maven.pojo
 * @ClassName : User
 * @Author : leeyangy
 * @CreateTime : 2023/12/29 18:18
 * @Version : 1.0
 * @Description :
 * @Modify_log :
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
}
