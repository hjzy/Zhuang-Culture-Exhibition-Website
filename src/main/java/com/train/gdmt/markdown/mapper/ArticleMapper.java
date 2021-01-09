package com.train.gdmt.markdown.mapper;

import com.train.gdmt.announcement.model.Announcement;
import com.train.gdmt.markdown.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    public int insertArticle(Article article);


    public Article getArticleById(int id);

    List<Article> getAllArticle();

    List<Article> searchArticle(String titleStr);

    public int deleteArticle(int id);

    public int updateArticle(Article article);

    public  List<Article> getArticleByType(int type);
}
