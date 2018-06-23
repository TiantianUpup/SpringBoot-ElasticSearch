package com.cqupt.study.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * 文章实体类
 * @author hetiantian
 * @date 2018/06/23
 * */
@Builder
@Data
@Document(indexName = "blog",type = "article")
public class Article {
    /**
     * 主键
     * */
    @Id
    private String id;

    /**
     * 文章标题
     * */
    @Field
    private String title;

    /**
     * 文章内容
     * */
    @Field
    private String content;

    /**
     * 文章创建时间
     * */
    @Field
    private Long gmtCreate;
}
