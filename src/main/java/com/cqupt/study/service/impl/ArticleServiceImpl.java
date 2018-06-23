package com.cqupt.study.service.impl;

import com.cqupt.study.dao.ArticleDao;
import com.cqupt.study.entity.Article;
import com.cqupt.study.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文章service实现类
 * @author hetiantian
 * @date 2018/06/23
 * */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public void saveArticle() {
        articleDao.save(Article.builder().id("1").title("title").content("This is content").build());
    }

    @Override
    public Article findById() {
        return articleDao.findById("1").get();
    }

    public void test() {
        articleDao.findById("1");
    }
}
