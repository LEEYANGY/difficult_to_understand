package com.meng.library.mongodb.controller;


import com.meng.library.mongodb.param.ArticleParam;
import com.meng.library.mongodb.service.ArticleService;
import com.meng.library.utils.base.RequestResult;
import com.meng.library.utils.constant.ResultConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actricle")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 增加
     *
     * @param articleParam
     * @return
     */
    @RequestMapping("/edit")
    public RequestResult edit(@RequestBody ArticleParam articleParam) {
        try {
            return RequestResult.succ(articleService.edit(articleParam));
        } catch (Exception e) {
            return RequestResult.fail(ResultConstant.ADDFAIL);
        }
    }

    /**
     * 删除
     *
     * @param articleParam
     * @return
     */
    @RequestMapping("/delete")
    public RequestResult delete(@RequestBody ArticleParam articleParam) {
        try {
            return RequestResult.succ(articleService.delete(articleParam));
        } catch (Exception e) {
            return RequestResult.fail(ResultConstant.DELETEFAIL);
        }
    }

    /**
     * 修改
     *
     * @param articleParam
     * @return
     */
    @RequestMapping("/updata")
    public RequestResult updata(@RequestBody ArticleParam articleParam) {
        try {
            return RequestResult.succ(articleService.update(articleParam));
        } catch (Exception e) {
            return RequestResult.fail(ResultConstant.UPDATAFAIL);
        }
    }

    /**
     * 查询
     *
     * @param articleParam
     * @return
     */
    @RequestMapping("/search")
    public RequestResult search(@RequestBody ArticleParam articleParam) {
        try {
            return RequestResult.succ(articleService.search(articleParam));
        } catch (Exception e) {
            return RequestResult.fail(ResultConstant.SEARCHFAIL);
        }
    }

    /**
     * 分页
     *
     * @param articleParam
     * @return
     */
    @RequestMapping("/page")
    public RequestResult page(@RequestBody ArticleParam articleParam) {
        try {
            return RequestResult.succ(articleService.page(articleParam));
        } catch (Exception e) {
            return RequestResult.fail(ResultConstant.SEARCHFAIL);
        }
    }

    /**
     * 统计
     *
     * @return
     */
    @RequestMapping("/count")
    public RequestResult count() {
        try {
            return RequestResult.succ(articleService.count());
        } catch (Exception e) {
            return RequestResult.fail(ResultConstant.FAIL);
        }
    }

}
