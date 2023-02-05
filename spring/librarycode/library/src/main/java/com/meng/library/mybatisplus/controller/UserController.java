package com.meng.library.mybatisplus.controller;

import com.meng.library.mybatisplus.entiy.User;
import com.meng.library.mybatisplus.param.UserParam;
import com.meng.library.mybatisplus.service.UserService;
import com.meng.library.utils.base.RequestResult;
import com.meng.library.utils.constant.ResultConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Nemo
 * @date 2021/06/29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页数据
     *
     * @param userParam
     * @return
     */
    @RequestMapping("/page")
    public RequestResult page(@RequestBody UserParam userParam) {

        try {
            return RequestResult.succ(userService.page(userParam));
        } catch (Exception e) {
            return RequestResult.fail(ResultConstant.SEARCHFAIL);
        }
    }

    /**
     * 分页条件查询
     *
     * @param userParam
     * @return
     */
    @RequestMapping("/pageSearch")
    public RequestResult pageSearch(@RequestBody UserParam userParam) {

        try {
            return RequestResult.succ(userService.pageSearch(userParam));
        } catch (Exception e) {
            return RequestResult.fail(ResultConstant.SEARCHFAIL);
        }
    }

    /**
     * 添加
     *
     * @param userParam
     * @return
     */
    @RequestMapping("/edit")
    public RequestResult edit(@RequestBody UserParam userParam) {

        try {
            return RequestResult.succ(userService.edit(userParam));
        } catch (Exception e) {
            return RequestResult.fail(ResultConstant.ADDFAIL);
        }
    }

    /**
     * 更新
     *
     * @param userParam
     * @return
     */
    @RequestMapping("/update")
    public RequestResult update(@RequestBody UserParam userParam) {

        try {
            return RequestResult.succ(userService.update(userParam));
        } catch (Exception e) {
            return RequestResult.fail(ResultConstant.UPDATAFAIL);
        }
    }

    /**
     * 删除
     *
     * @param userParam
     * @return
     */
    @RequestMapping("/deleteById")
    public RequestResult deleteById(@RequestBody UserParam userParam) {

        try {
            return RequestResult.succ(userService.delete(userParam));
        } catch (Exception e) {
            return RequestResult.fail(ResultConstant.DELETEFAIL);
        }
    }

    /**
     * 乐观锁
     */
    @RequestMapping("/version")
    public RequestResult version() {

        try {
            User byId = userService.getById("1409770335123283969");
            byId.setAccount("nemo");
            boolean b = userService.updateById(byId);
            return RequestResult.succ(b);
        } catch (Exception e) {
            return RequestResult.fail(ResultConstant.FAIL);
        }
    }
}
