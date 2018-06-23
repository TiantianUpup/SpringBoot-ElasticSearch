package com.cqupt.study.dao;

import com.cqupt.study.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * 文章DAO层接口
 * @author hetiantian
 * @date 2018/06/23
 * */
@Repository
public interface ArticleDao extends ElasticsearchRepository<Article, String> {
}
