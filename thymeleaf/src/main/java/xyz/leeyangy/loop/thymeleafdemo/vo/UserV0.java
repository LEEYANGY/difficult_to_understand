package xyz.leeyangy.loop.thymeleafdemo.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author LEEYANGY
 * @date 2022/2/14 20:06
 */
@Data
public class UserV0 {
    private String username;
    private Integer age;
    private Integer sex;
    private Boolean isVip;
    private Date createTime;
    private List<String> tags;
}
