//package xyz.leeyangy.school.modular.system.controller;
//
//import cn.hutool.core.util.StrUtil;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import org.dragonwings.school.framework.response.ResponseData;
//import org.dragonwings.school.framework.response.ResponseResult;
//import org.dragonwings.school.framework.socket.WebSocketServer;
//import org.dragonwings.school.modular.system.entity.*;
//import org.dragonwings.school.modular.system.mapper.MessageMapper;
//import org.dragonwings.school.modular.system.service.EventService;
//import org.dragonwings.school.modular.system.service.HealthReportService;
//import org.dragonwings.school.modular.system.service.MessageService;
//import org.dragonwings.school.modular.system.service.UserService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.util.ObjectUtils;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @Author liyangyang
// * @Date: 2023/05/09 10:48
// * @Package org.dragonwings.school.modular.system.controller
// * @Version 1.0
// * @Description:
// */
//
//@RestController
//@RequestMapping("/admin")
//public class AdminController {
//
//    @Resource
//    UserService userService;
//
//    @Resource
//    EventService eventService;
//
//    @Resource
//    MessageService messageService;
//
//    @Resource
//    MessageMapper messageMapper;
//
//    /**
//    * @Param: [user, response]
//    * @return: org.dragonwings.school.framework.response.ResponseResult
//    * @Author: liyangyang
//    * @Date: 2023/5/10 2:53
//    * @Description: 管理员登录
//    */
//    @PostMapping("/login")
//    public ResponseResult login(@RequestBody User user, HttpServletResponse response) {
//        return userService.adminLogin(user, response);
//    }
//
//
//    /**
//     * 日志记录
//     */
//    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);
//
//    @Resource
//    HealthReportService healthReportService;
//
//    /***
//     * @Param: [healthReport]
//     * @return: org.dragonwings.school.framework.response.ResponseData
//     * @Author: liyangyang
//     * @Date: 2023/5/7 20:11
//     * @Description: 健康信息上报接口
//     */
//    @PutMapping("/healthReport")
//    public ResponseData healthReport(@RequestBody HealthReport healthReport) {
//        log.info("数据进来了{}", healthReport);
//        if (healthReportService.save(healthReport)) {
//            return ResponseData.success(200);
//        } else {
//            return ResponseData.error(500);
//        }
//    }
//
//    /**
//     * @Param: [id]
//     * @return: org.dragonwings.school.framework.response.ResponseData
//     * @Author: liyangyang
//     * @Date: 2023/5/10 1:36
//     * @Description: 获取用户的健康详细信息
//     */
//    @GetMapping("/getUserHealthDetailById/{id}")
//    public ResponseData getUserHealthDetailById(@PathVariable Long id) {
//        return ResponseData.success(
//                200,
//                "获取成功",
//                healthReportService.getOne(new QueryWrapper<HealthReport>().eq("id", id)));
//    }
//
//    @GetMapping("/getAllUserHealth/{page}/{limit}")
//    public ResponseData getAllUserHealth(@PathVariable Integer page, @PathVariable Integer limit) {
//        if (page == null || page < 1) page = 1;
//        if (limit == null || limit <= 1) limit = 10;
////        分页查询
////        Page<HealthReport> healthReportPage = healthReportService.page(new Page<HealthReport>(page, limit), new QueryWrapper<HealthReport>().orderByDesc("id"));
//        return ResponseData.success(
//                200, "获取成功",
//                healthReportService.page(new Page<HealthReport>(page, limit),
//                        new QueryWrapper<HealthReport>().orderByDesc("id")));
//    }
//
//    /**
//     * @Param: [id]
//     * @return: org.dragonwings.school.framework.response.ResponseData
//     * @Author: liyangyang
//     * @Date: 2023/5/10 2:35
//     * @Description: 删除
//     */
//    @DeleteMapping("/delUserHealthById/{id}")
//    public ResponseData delUserHealthById(@PathVariable Long id) {
//        if (id == 0 && healthReportService.getById(id) == null) {
//            return ResponseData.error(501);
//        } else {
//            return ResponseData.success(200, "删除成功", healthReportService.removeById(id));
//        }
//    }
//
//    /***
//     * @Param: [userId, hid]
//     * @return: org.dragonwings.school.framework.response.ResponseData
//     * @Author: liyangyang
//     * @Date: 2023/5/7 20:14
//     * @Description: 该接口是复用
//     *
//     *      hid查询自己的记录id，如果为空默认给自己全部数据
//     *      hid不为空，查询指定记录
//     */
////    @GetMapping("/getHealthRecord/{userId}/{hid}")
////    public ResponseData getHealthRecord(@PathVariable Long userId, @PathVariable Long hid) {
////        log.info("用户id===={},查询记录id===={}", userId, hid);
////        return ResponseData.success(200);
////    }
//
//    /**
//     * @Param: [sponsor_id]
//     * @return: org.dragonwings.school.framework.response.ResponseData
//     * @Author: liyangyang
//     * @Date: 2023/5/3 2:20
//     * @Description: 查询用户的申请记录数
//     */
//    @GetMapping("/getTotal")
//    public ResponseData getTotal() {
//        //        获取符合条件的记录数
//        return ResponseData.success(200, "获取记录数成功", eventService.count());
//    }
//
//    /**
//     * @Param: [sponsor_id, page, limit]
//     * @return: org.dragonwings.school.framework.response.ResponseData
//     * @Author: liyangyang
//     * @Date: 2023/5/3 2:20
//     * @Description: 分页查询用户的申请记录
//     */
//    @GetMapping("/getUserCafeRecord/{page}/{limit}")
////    @GetMapping("/getUserCafeRecord")
//    public ResponseData getUserCafeRecord(@PathVariable String limit, @PathVariable String page) {
//
//        QueryWrapper<Event> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("id");
//        return ResponseData.success(200, "", eventService.list(queryWrapper));
//    }
//
//    /**
//     * @Param: [id]
//     * @return: org.dragonwings.school.framework.response.ResponseData
//     * @Author: liyangyang
//     * @Date: 2023/5/9 11:16
//     * @Description: 获取指定的申请记录
//     */
//    @GetMapping("/getUserCafeDetailRecord/{id}")
//    public ResponseData getMyCafeRecord(@PathVariable Integer id) {
//        Event event = eventService.getOne(new QueryWrapper<Event>().eq("id", id));
//        if (!ObjectUtils.isEmpty(event)) {
//            return ResponseData.success(200, "资源请求成功", event);
//        } else {
//            return ResponseData.error(404, "请求资源不存在", null);
//        }
//    }
//
//    /**
//     * @Param: [event]
//     * @return: org.dragonwings.school.framework.response.ResponseData
//     * @Author: liyangyang
//     * @Date: 2023/5/9 11:16
//     * @Description: 修改用户的申请记录
//     */
//    @PutMapping("/updateRecord")
//    public ResponseData updateRecord(@RequestBody Event event) {
//        System.out.println(event);
//        if (!ObjectUtils.isEmpty(event) && event.getId() != 0) {
//            boolean b = eventService.updateById(event);
//            if (b) {
//                return ResponseData.success(200);
//            } else {
//                return ResponseData.error(500);
//            }
//        } else {
//            return ResponseData.error(404);
//        }
//
//    }
//
//    /***
//    * @Param: [id]
//    * @return: org.dragonwings.school.framework.response.ResponseData
//    * @Author: liyangyang
//    * @Date: 2023/5/10 2:56
//    * @Description: 通过id删除用户提交的申请
//    */
//    @DeleteMapping("/delUserApplyById/{id}")
//    public ResponseData delUserApplyById(@PathVariable Long id) {
//        if (eventService.removeById(id)) {
//            return ResponseData.success(200);
//        } else {
//            return ResponseData.error(501);
//        }
//    }
//
////      通知管理
//
//    /**
//     * @Param: []
//     * @return: org.dragonwings.school.framework.response.ResponseData
//     * @Author: liyangyang
//     * @Date: 2023/5/9 13:16
//     * @Description: 获取所有通知
//     */
//    @GetMapping("/getNotice")
//    public ResponseData getNotice() {
//        return ResponseData.success(200, "获取成功", messageService.list());
//    }
//
//    @GetMapping("/getDetail/{id}")
//    public ResponseData getDetail(@PathVariable Long id) {
//        return ResponseData.success(
//                200,
//                "获取成功",
//                messageMapper.selectOne(new QueryWrapper<Message>().eq("id", id)));
//    }
//
//    /***
//    * @Param: [message]
//    * @return: org.dragonwings.school.framework.response.ResponseData
//    * @Author: liyangyang
//    * @Date: 2023/5/10 2:55
//    * @Description: 新增/修改 复用接口
//    */
//    @PostMapping("/editMessage")
//    public ResponseData editMessage(@RequestBody Message message) {
////        id==0是新增
//        if (message.getId() == 0) {
//            messageService.save(message);
//        } else {
//            messageService.updateById(message);
//        }
//        return ResponseData.success(200);
//    }
//
//    /***
//    * @Param: [id]
//    * @return: org.dragonwings.school.framework.response.ResponseData
//    * @Author: liyangyang
//    * @Date: 2023/5/10 2:55
//    * @Description: 通过id删除通知
//    */
//    @DeleteMapping("/delMessage/{id}")
//    public ResponseData delMessage(@PathVariable Long id) {
//        if (id == 0 || messageMapper.selectOne(new QueryWrapper<Message>().eq("id", id)) == null) {
//            return ResponseData.error(501);
//        }
//        return ResponseData.success(200, "删除成功", messageMapper.deleteById(id));
//    }
//
//
//    //    用户管理
//    /***
//    * @Param: []
//    * @return: org.dragonwings.school.framework.response.ResponseData
//    * @Author: liyangyang
//    * @Date: 2023/5/10 2:54
//    * @Description: 获取用户数量
//    */
//    @GetMapping("/getUserTotal")
//    public ResponseData getUserTotal() {
//        return ResponseData.success(200, "获取成功", userService.count());
//    }
//
//    /***
//    * @Param: [page, limit]
//    * @return: org.dragonwings.school.framework.response.ResponseData
//    * @Author: liyangyang
//    * @Date: 2023/5/10 2:54
//    * @Description: 分页获取所有用户信息
//    */
//    @GetMapping("/getAllUser/{page}/{limit}")
//    public ResponseData getAllUser(@PathVariable Integer page, @PathVariable Integer limit) {
//        if (page == null || page < 1) page = 1;
//        if (limit == null || limit <= 1) limit = 10;
////        分页查询
//        Page<User> pages = new Page<>(page, limit);
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("id");
//        Page<User> userPage = userService.page(pages, queryWrapper);
//        return ResponseData.success(200, "获取成功", userPage);
//    }
//
//    /***
//    * @Param: [userId]
//    * @return: org.dragonwings.school.framework.response.ResponseData
//    * @Author: liyangyang
//    * @Date: 2023/5/10 2:54
//    * @Description: 通过用户id获取用户信息
//    */
//    @GetMapping("/getUserDetail/{userId}")
//    public ResponseData getUserDetail(@PathVariable Long userId) {
//        return ResponseData.success(
//                200
//                , "获取成功"
//                , userService.getOne(new QueryWrapper<User>().eq("user_id", userId)));
//    }
//
//    /***
//    * @Param: [user]
//    * @return: org.dragonwings.school.framework.response.ResponseData
//    * @Author: liyangyang
//    * @Date: 2023/5/10 2:53
//    * @Description: 更新用户信息
//    */
//    @PutMapping("/updateUserInfo")
//    public ResponseData updateUserInfo(@RequestBody User user) {
////        Hutool StrUtil
//        if (StrUtil.hasBlank(user.getPassword())) {
//            User getPassword = userService.getById(user.getId());
//            user.setPassword(getPassword.getPassword());
//        } else {
//            //            加密密码
//            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//            user.setPassword(encoder.encode(user.getPassword()));
//        }
//        if (userService.updateById(user)) {
//            return ResponseData.success(200);
//        } else {
//            return ResponseData.error(501);
//        }
//    }
//
//}
