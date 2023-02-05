package com.meng.library.mongodb.service;


import com.meng.library.mongodb.entiy.Article;
import com.meng.library.mongodb.param.ArticleParam;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import java.util.List;

public interface ArticleService {

    /**
     * 插入数据
     *
     * @param articleParam
     * @return
     */
    Article edit(ArticleParam articleParam);

    /**
     * 根据id删除
     *
     * @param articleParam
     * @return
     */
    DeleteResult delete(ArticleParam articleParam);

    /**
     * 根据id修改
     *
     * @param articleParam
     * @return
     */
    UpdateResult update(ArticleParam articleParam);

    /**
     * 查询一条
     *
     * @param articleParam
     * @return
     */
    Article search(ArticleParam articleParam);

    /**
     * 分页查询
     *
     * @param articleParam
     * @return
     */
    List<Article> page(ArticleParam articleParam);

    /**
     * 统计
     *
     * @return
     */
    Long count();


}
