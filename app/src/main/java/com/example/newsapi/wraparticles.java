package com.example.newsapi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class wraparticles {

    @SerializedName("articles")
    ArrayList<Article> article;

    public ArrayList<Article> getArticle() {
        return article;
    }
    public void setArticle(ArrayList<Article> article) {
        this.article = article;
    }
}
