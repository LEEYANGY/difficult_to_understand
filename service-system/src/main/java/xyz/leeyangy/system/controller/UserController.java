package xyz.leeyangy.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import xyz.leeyangy.common.result.R;
import xyz.leeyangy.model.dto.SysUserDto;
import xyz.leeyangy.model.system.SysUser;
import xyz.leeyangy.model.vo.AssginRoleVo;
import xyz.leeyangy.model.vo.SysUserQueryVo;
import xyz.leeyangy.system.service.SysRoleService;
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
        maps.put("token", "admin-token");
        return R.ok(maps);
    }

    /**
     * @Param: []
     * @return: xyz.leeyangy.common.result.R<java.util.Map < java.lang.String, java.lang.Object>>
     * @Author: liyangyang
     * @Date: 2023/9/19 0:39
     * @Description: 获取用户信息
     */
    @GetMapping("/info")
    @ApiOperation(value = "获取用户信息")
    public R<Map<String, Object>> getUserInfo() {
        Map<String, Object> maps = new HashMap<>();
        maps.put("roles", "[\"admin\"]");
        maps.put("introduction", "I am a super administaror");
        maps.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        maps.put("name", "Super admin leeyangy");
        return R.ok(maps);
    }

    @PostMapping("/logout")
    @ApiOperation(value = "用户注销登录")
    public R logout(@RequestBody String token) {
        return R.ok();
    }

    @ApiOperation(value = "获取分页列表")
    @GetMapping("/{page}/{limit}")
    public R index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "userQueryVo", value = "查询对象", required = false)
            SysUserQueryVo userQueryVo) {
        Page<SysUser> pageParam = new Page<>(page, limit);
        IPage<SysUser> pageModel = userService.selectPage(pageParam,
                userQueryVo);
        return R.ok(pageModel);
    }

    @ApiOperation(value = "获取用户")
    @GetMapping("/get/{id}")
    public R get(@PathVariable Long id) {
        SysUser user = userService.getById(id);
        return R.ok(user);
    }

    @ApiOperation(value = "保存用户")
    @PostMapping("/save")
    public R save(@RequestBody SysUser user) {
        System.out.println("user = " + user);
        userService.save(user);
        return R.ok();
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("/update")
    public R updateById(@RequestBody SysUser user) {
        userService.updateById(user);
        return R.ok();
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/remove/{id}")
    public R remove(@PathVariable Long id) {
        userService.removeById(id);
        return R.ok();
    }

    @ApiOperation(value = "更新状态")
    @GetMapping("updateStatus/{id}/{status}")
    public R updateStatus(@PathVariable Long id, @PathVariable Integer status) {
        userService.updateStatus(id, status);
        return R.ok();
    }

}
