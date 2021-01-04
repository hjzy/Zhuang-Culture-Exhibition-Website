package com.train.gdmt.markdown.service;

import com.train.gdmt.markdown.mapper.ArticleMapper;
import com.train.gdmt.markdown.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {


    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleService(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public boolean publishArticle(Article article) {
        int res = articleMapper.insertArticle(article);
        if(res > 0) {
            return true;
        }
        return false;
    }


    public Article getArticleById(int id) {
        return articleMapper.getArticleById(id);
    }

}
