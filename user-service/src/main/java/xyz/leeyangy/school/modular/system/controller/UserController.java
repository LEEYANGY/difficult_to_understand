package xyz.leeyangy.school.modular.system.controller;

import xyz.leeyangy.school.framework.response.ResponseData;
import xyz.leeyangy.school.framework.response.ResponseResult;
import xyz.leeyangy.school.modular.system.entity.User;
import xyz.leeyangy.school.modular.system.feign.EventFeignService;
import xyz.leeyangy.school.modular.system.feign.HealthFeignService;
import xyz.leeyangy.school.modular.system.feign.ZoneFeignService;
import xyz.leeyangy.school.modular.system.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author liyangyang
 * @since 2023-04-12
 */
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * @Param: [user, response]
     * @return: org.dragonwings.school.framework.response.ResponseResult
     * @Author: liyangyang
     * @Date: 2023/5/3 1:29
     * @Description: 登录
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user, HttpServletResponse response) {
        return userService.login(user, response);
    }

    /**
     * @Param: [user, response]
     * @return: org.dragonwings.school.framework.response.ResponseResult
     * @Author: liyangyang
     * @Date: 2023/5/10 2:53
     * @Description: 管理员登录
     */
    @PostMapping("/admin/login")
    public ResponseResult adminLogin(@RequestBody User user, HttpServletResponse response) {
        return userService.adminLogin(user, response);
    }

    /**
     * @Param: []
     * @return: org.dragonwings.school.framework.response.ResponseResult
     * @Author: liyangyang
     * @Date: 2023/5/3 1:29
     * @Description: 注销
     */
    @GetMapping("/logout")
    public ResponseResult logout() {
        return userService.logout();
    }

//    TODO start 远程调用


    @Resource
    ZoneFeignService zoneFeignService;

    /**
    * @Param: [userId]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 21:53
    * @Description: 查询用户动态记录数
     * VUE MyZone.Vue
    */
    @GetMapping("/getMyZoneTotal/{userId}")
    public ResponseData getMyZoneTotal(@PathVariable("userId") Long userId){
        return zoneFeignService.getUserMaxTotal(userId);
    }

    /**
    * @Param: [userId, page, limit]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 21:31
    * @Description: 远程调用查询用户动态
     * VUE MyZone.Vue
    */
    @GetMapping("/getMyZone/{userId}/{page}/{limit}")
    public ResponseData getMyZone(@PathVariable("userId") Long userId,
                                  @PathVariable("page") Integer page,
                                  @PathVariable("limit") Integer limit){
        return zoneFeignService.getMyArticle(userId, page, limit);
    }


    @Resource
    HealthFeignService healthFeignService;

    /**
    * @Param: [userId, hid]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 21:58
    * @Description: 查询用户的健康上报信息
     * TODO 暂无使用
    */
    @GetMapping("/getUserHealthRecord/{userId}/{hid}")
    public ResponseData getUserHealthRecord(@PathVariable("userId") Long userId, @PathVariable("hid") Long hid){
        return healthFeignService.getHealthRecord(userId, hid);
    }

    @Resource
    EventFeignService eventFeignService;

    /**
    * @Param: [sponsor_id]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 22:01
    * @Description: 获取用户最大记录数
     * VUE RecordList.vue
    */
    @GetMapping("/getMyEventTotal/{sponsor_id}")
    public ResponseData getMyEventTotal(@PathVariable("sponsor_id") String sponsor_id){
        return eventFeignService.getTotal(sponsor_id);
    }

    /**
    * @Param: [sponsor_id, page, limit]
    * @return: xyz.leeyangy.school.framework.response.ResponseData
    * @Author: liyangyang
    * @Date: 2023/6/6 22:35
    * @Description: 查询我的申请记录
     * VUE RecordList.vue
    */
    @GetMapping("/getMyEventRecord/{sponsor_id}/{page}/{limit}")
    public ResponseData getMyEventRecord(@PathVariable("sponsor_id") String sponsor_id,
                                         @PathVariable("page") Integer page,
                                         @PathVariable("limit") Integer limit){
        return eventFeignService.getMyCafeRecord(sponsor_id, page, limit);
    }

//    TODO end

    /**
     * @Param: [userId]
     * @return: org.dragonwings.school.framework.response.ResponseResult
     * @Author: liyangyang
     * @Date: 2023/5/3 4:40
     * @Description: 获取用户信息
     */
    @GetMapping("/getUserInfo/{userId}")
    public ResponseResult getUserInfo(@PathVariable Long userId) {
        return userService.getUserInfo(userId);
    }

    /**
     * @Param: [user]
     * @return: org.dragonwings.school.framework.response.ResponseResult
     * @Author: liyangyang
     * @Date: 2023/5/3 19:02
     * @Description: 修改用户信息，该接口需要复用，比如说，在数据库中预先注册的用户，在首次登录之后需要请求此接口修改密码
     */
    @PutMapping("/putUserInfo")
    public ResponseResult putUserInfo(@RequestBody User user) {
        return userService.putUserInfo(user);
    }

    //    TODO 管理员功能
    /***
     * @Param: []
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/10 2:54
     * @Description: 获取用户数量
     */
    @GetMapping("/admin/getUserTotal")
    public ResponseData getUserTotal() {
        return ResponseData.success(200, "获取成功", userService.count());
    }

    /***
     * @Param: [page, limit]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/10 2:54
     * @Description: 分页获取所有用户信息
     */
    @GetMapping("/admin/getAllUser/{page}/{limit}")
    public ResponseData getAllUser(@PathVariable Integer page, @PathVariable Integer limit) {
        return userService.getAllUserByPage(page,limit);
    }

    /***
     * @Param: [user]
     * @return: org.dragonwings.school.framework.response.ResponseData
     * @Author: liyangyang
     * @Date: 2023/5/10 2:53
     * @Description: 更新用户信息
     */
    @PutMapping("/admin/updateUserInfo")
    public ResponseData updateUserInfo(@RequestBody User user) {
        return userService.updateUserInfo(user);
    }

}

