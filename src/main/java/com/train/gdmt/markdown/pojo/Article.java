package com.train.gdmt.markdown.pojo;

import lombok.Data;

@Data
public class Article {

    private int id;

    private String title;

    private String author;

    private String content;

    private String ArticleViewUrl;

    private String ArticleDeleteUrl;

    private String ArticleEditUrl;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getArticleViewUrl() {
        ArticleViewUrl = "/article/view/" + id;
        return ArticleViewUrl;
    }

    public String getArticleDeleteUrl() {
        ArticleDeleteUrl = "/article/delete/" + id;
        return ArticleDeleteUrl;
    }

    public String getArticleEditUrl() {
        ArticleEditUrl = "/article/toEdit/" + id;
        return ArticleEditUrl;
    }

}