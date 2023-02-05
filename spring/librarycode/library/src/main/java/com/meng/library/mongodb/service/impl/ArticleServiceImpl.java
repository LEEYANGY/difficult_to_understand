package com.meng.library.mongodb.service.impl;

import com.meng.library.mongodb.entiy.Article;
import com.meng.library.mongodb.param.ArticleParam;
import com.meng.library.mongodb.service.ArticleService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    //    @Qualifier(value = "secondaryMongoTemplate")
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Article edit(ArticleParam articleParam) {
        //时间戳
        articleParam.setId(System.currentTimeMillis());
        //创建时间
        articleParam.setCreateTime(new Date());
        //修改时间
        articleParam.setUpdateTime(new Date());
        Article article = new Article();
        BeanUtils.copyProperties(articleParam, article);
        return mongoTemplate.save(article);
    }

    @Override
    public DeleteResult delete(ArticleParam articleParam) {
        //条件构造器
        Query query = new Query(Criteria.where("_id").is(articleParam.getId()));
        return mongoTemplate.remove(query, Article.class);
    }

    @Override
    public UpdateResult update(ArticleParam articleParam) {
        articleParam.setUpdateTime(new Date());
        Article article = new Article();
        BeanUtils.copyProperties(articleParam, article);
        //条件构造器
        Query query = new Query(Criteria.where("_id").is(articleParam.getId()));
        //更新方法
        Update update = new Update();
        update.set("title", article.getTitle());
        update.set("content", article.getContent());
        update.set("author", article.getAuthor());
        update.set("source", article.getSource());
        return mongoTemplate.updateFirst(query, update, Article.class);
    }

    @Override
    public Article search(ArticleParam articleParam) {
        //条件构造器
        Query query = new Query(Criteria.where("_id").is(articleParam.getId()));
        return mongoTemplate.findOne(query, Article.class);
    }

    @Override
    public List<Article> page(ArticleParam articleParam) {
        //分页插件
        Pageable pageable = PageRequest.of(articleParam.getPageNo(), articleParam.getPageSize());
        //条件构造器
        Query query = new Query(Criteria.where("state").is(1));
        //排序
        Sort sort = Sort.by(Sort.Direction.ASC, "createTime");
        return mongoTemplate.find(query.with(sort).with(pageable), Article.class);
    }

    @Override
    public Long count() {
        Query query = new Query();
        return mongoTemplate.count(query, Article.class);
    }

}
