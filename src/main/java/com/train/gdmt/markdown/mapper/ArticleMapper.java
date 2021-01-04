package com.train.gdmt.markdown.mapper;

import com.train.gdmt.markdown.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {

    public int insertArticle(Article article);


    public Article getArticleById(int id);

}
