package com.train.gdmt.markdown.service;

import com.train.gdmt.markdown.mapper.ArticleMapper;
import com.train.gdmt.markdown.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public  List<Article> getArticleByType(int type) {
        return articleMapper.getArticleByType(type);
    }


    public  List<Article> getArticleByTypeLimitSize(int type,int size) {
        return articleMapper.getArticleByTypeLimitSize(type,size);
    }

    public List<Article> getAllArticle(){
        return articleMapper.getAllArticle();
    }

    public List<Article> searchArticle(String titleStr){
        return articleMapper.searchArticle(titleStr);
    }

    public boolean deleteArticleById(int id) {
        int res = articleMapper.deleteArticle(id);
        if(res > 0) {
            return true;
        }
        return false;
    }

    public boolean updateArticleById(Article article) {
        int res = articleMapper.updateArticle(article);
        if(res > 0) {
            return true;
        }
        return false;
    }

}
