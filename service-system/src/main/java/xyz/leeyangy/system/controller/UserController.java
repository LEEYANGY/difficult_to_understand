package xyz.leeyangy.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import xyz.leeyangy.common.result.R;
import xyz.leeyangy.model.dto.SysUserDto;
import xyz.leeyangy.model.vo.SysUserQueryVo;
import xyz.leeyangy.system.service.SysUserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@Api(tags = "用户管理")
public class UserController {

    @Resource
    private SysUserService userService;

    @GetMapping("/login/code")
    @ApiOperation(value = "获取验证码")
    public R getCode() {
        Map<String, Integer> vcode = new HashMap<>();
        vcode.put("vc", 6666);
        return R.ok(vcode);
    }

    /**
     * @Param: [sysUserDto]
     * @return: xyz.leeyangy.common.result.R<xyz.leeyangy.model.vo.SysUserQueryVo>
     * @Author: liyangyang
     * @Date: 2023/9/18 14:37
     * @Description: 用户登录，查询不为null返回vo，查询为空返回null
     */
//    @PostMapping("/login")
//    @ApiOperation(value = "用户登录")
//    public R<SysUserQueryVo> login(@RequestBody SysUserDto sysUserDto) {
//        SysUserQueryVo userQueryVo = userService.login(sysUserDto);
//        if ( userQueryVo!= null) {
//            return R.ok(userQueryVo);
//        }else {
//            return R.fail();
//        }
//    }
    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public R<Map<String, Object>> login(@RequestBody SysUserDto sysUserDto) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("token","admin-token");
        return R.ok(maps);
    }

    /**
    * @Param: []
    * @return: xyz.leeyangy.common.result.R<java.util.Map<java.lang.String,java.lang.Object>>
    * @Author: liyangyang
    * @Date: 2023/9/19 0:39
    * @Description: 获取用户信息
    */
    @GetMapping("/info")
    public R<Map<String, Object>> getUserInfo() {
        Map<String, Object> maps = new HashMap<>();
        maps.put("roles", "[\"admin\"]");
        maps.put("introduction", "I am a super administaror");
        maps.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        maps.put("name", "Super admin leeyangy");
        return R.ok(maps);
    }

}
