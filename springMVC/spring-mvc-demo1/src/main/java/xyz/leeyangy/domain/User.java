package xyz.leeyangy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @Package: xyz.leeyangy.domain
 * @Author: LEEYANGYANG
 * @Create: 2022/10/21 15:58
 * @Description: {code: 200, message:"Success", data:{要传给前端的数据}}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private HttpStatus statusCode;
    private String username;
    private String password;
    private String sex;
    private String age;
    private String email;
}
