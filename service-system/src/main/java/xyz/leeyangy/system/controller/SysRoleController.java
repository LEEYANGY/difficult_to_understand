package xyz.leeyangy.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import xyz.leeyangy.common.result.R;
import xyz.leeyangy.exception.AuthException;
import xyz.leeyangy.model.system.SysRole;
import xyz.leeyangy.model.vo.AssginRoleVo;
import xyz.leeyangy.model.vo.SysRoleQueryVo;
import xyz.leeyangy.system.service.SysRoleService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/role")
@Api(tags = "角色管理")
public class SysRoleController {

    //    注入service bean
    @Resource
    private SysRoleService sysRoleService;

    /**
     * @Param: []
     * @return: java.util.List<xyz.leeyangy.model.system.SysRole>
     * @Author: liyangyang
     * @Date: 2023/9/12 17:12
     * @Description: 获取所有角色
     */
    @ApiOperation(value = "获取所有角色")
    @GetMapping("/getAllRole")
    public List<SysRole> getAllRole() {
        return sysRoleService.list();
    }

    /**
     * @Param: []
     * @return: java.lang.Boolean
     * @Author: liyangyang
     * @Date: 2023/9/12 17:12
     * @Description: 批量删除
     */
    @ApiOperation(value = "删除角色")
    @DeleteMapping("/delAllRole")
    public Boolean delAllRole() {
        return sysRoleService.removeByIds(Arrays.asList(1, 2, 3, 4, 5));
    }

    /**
     * @Param: [sysRole]
     * @return: boolean
     * @Author: liyangyang
     * @Date: 2023/9/12 17:11
     * @Description: 通过角色id修改角色信息
     */
    @ApiOperation(value = "修改角色")
    @PutMapping("/putRoleById")
    public boolean putRoleById(@RequestBody SysRole sysRole) {
        return sysRoleService.updateById(sysRole);
    }

    /**
     * @Param: [sysRole]
     * @return: boolean
     * @Author: liyangyang
     * @Date: 2023/9/12 17:11
     * @Description: 添加角色
     */
    @ApiOperation(value = "添加角色")
    @PostMapping("/addRole")
    public boolean addRole(@RequestBody SysRole sysRole) {
        return sysRoleService.save(sysRole);
    }

    /**
     * @Param: []
     * @return: java.util.List<xyz.leeyangy.model.system.SysRole>
     * @Author: liyangyang
     * @Date: 2023/9/12 17:11
     * @Description: 分页查询
     */
    @ApiOperation(value = "获取分页列表")
    @GetMapping("/getRoleByPage/{currentPage}/{pageSize}")
    public R getRoleByPage(@ApiParam(name = "currentPage", value = "当前页码", required = true)
                           @PathVariable Long currentPage,
                           @ApiParam(name = "pageSize", value = "每页记录数", required = true)
                           @PathVariable Long pageSize,
                           @ApiParam(name = "roleQueryVo", value = "查询对象", required = false)
                           SysRoleQueryVo roleQueryVo) {
        System.out.println("roleQueryVo = " + roleQueryVo.getRoleName());
        Page<SysRole> pageParam = new Page<>(currentPage, pageSize);
        IPage<SysRole> pageModel = sysRoleService.selectPage(pageParam,
                roleQueryVo);
//        try {
//            int a = 110 / 0;
//        } catch (Exception e) {
//            throw new AuthException(30001,"你干嘛？");
//        }

        return R.ok(pageModel);
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "根据id获取角色信息")
    public R getRoleInfo(@PathVariable String id) {
        return R.ok(sysRoleService.getById(id));
    }

    @DeleteMapping("/remove/{id}")
    @ApiOperation(value = "根据id删除角色")
    public R removeRoleById(@PathVariable String id) {
        return R.ok(sysRoleService.removeById(id));
    }

    @PutMapping("/update")
    @ApiOperation(value = "根据id修改角色信息")
    public R updateRoleById(@RequestBody SysRole sysRole) {
        return R.ok(sysRoleService.updateById(sysRole));
    }

    @DeleteMapping("/batchRemove")
    @ApiOperation(value = "根据id修改角色信息")
    public R batchRemove(@RequestBody List<String> ids) {
        return R.ok(sysRoleService.removeByIds(ids));
    }

    @PostMapping("/save")
    @ApiOperation(value = "根据id修改角色信息")
    public R batchRemove(@RequestBody SysRole sysRole) {
        return R.ok(sysRoleService.save(sysRole));
    }

    /**
     * @Param: []
     * @return: xyz.leeyangy.common.result.R<java.util.List < xyz.leeyangy.model.system.SysRole>>
     * @Author: liyangyang
     * @Date: 2023/9/13 0:00
     * @Description: 使用统一返回类进行包装数据
     */
    @ApiOperation(value = "使用统一返回类进行包装数据")
    @GetMapping("/findAll")
    public R<List<SysRole>> findAll() {
        List<SysRole> roleList = sysRoleService.list();
        return R.ok(roleList);
    }

    @ApiOperation(value = "根据用户获取角色数据")
    @GetMapping("/toAssign/{userId}")
    public R toAssign(@PathVariable Long userId) {
        Map<String, Object> roleMap = sysRoleService.getRolesByUserId(userId);
        return R.ok(roleMap);
    }
    @ApiOperation(value = "根据用户分配角色")
    @PostMapping("/doAssign")
    public R doAssign(@RequestBody AssginRoleVo assginRoleVo) {
        sysRoleService.doAssign(assginRoleVo);
        return R.ok();
    }

}
