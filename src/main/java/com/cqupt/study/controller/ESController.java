package com.cqupt.study.controller;

import com.cqupt.study.entity.Article;
import com.cqupt.study.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用es查询的控制类
 * @author hetiantian
 * @date 2018/06/23
 * */
@RestController
public class ESController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/saveArticle")
    public String saveArticle() {
        articleService.saveArticle();
        return "success";
    }

    @GetMapping("/getArticle")
    public Article getArticle() {
        Article article = articleService.findById();
        return article;
    }
}
