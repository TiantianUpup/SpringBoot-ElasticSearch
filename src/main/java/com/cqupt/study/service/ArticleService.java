package com.cqupt.study.service;

import com.cqupt.study.entity.Article;

/**
 * 文章service接口
 * @author hetiantian
 * @date 2018/06/23
 * */
public interface ArticleService {
    void saveArticle();
    Article findById();
}
