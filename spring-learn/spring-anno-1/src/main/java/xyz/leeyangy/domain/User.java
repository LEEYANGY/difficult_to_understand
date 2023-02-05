package xyz.leeyangy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package: xyz.leeyangy.domain
 * @Author: LEEYANGYANG
 * @Create: 2022/10/24 16:28
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
}
