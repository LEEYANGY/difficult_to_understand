package com.meng.library.mongodb.param;

import com.meng.library.utils.base.BaseParam;
import lombok.Data;

import java.util.Date;

@Data
public class ArticleParam extends BaseParam {

    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文字内容
     */
    private String content;

    /**
     * 作者
     */
    private String author;

    /**
     * 来源
     */
    private String source;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改
     */
    private Date updateTime;
}
