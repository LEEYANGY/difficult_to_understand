package xyz.leeyangy.service;

import xyz.leeyangy.pojo.User;
import xyz.leeyangy.respone.ResponseResult;

/**
 * @Author liyangyang
 * @Date: 2023/02/24 12:45
 * @Package xyz.leeyangy.service.impl
 * @Version 1.0
 * @Description:
 */
public interface LoginService {

    ResponseResult login(User user);

    ResponseResult logout();

//     ResponseData login(User user);
}
