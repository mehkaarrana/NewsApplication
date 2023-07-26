package com.ranag.newesapp;

import java.util.ArrayList;

public class MainNews {
    private String status,titalResults;
    ArrayList<ModelClass> articles;

    public MainNews(String status, String titalResults, ArrayList<ModelClass> articles) {
        this.status = status;
        this.titalResults = titalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitalResults() {
        return titalResults;
    }

    public void setTitalResults(String titalResults) {
        this.titalResults = titalResults;
    }

    public ArrayList<ModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ModelClass> articles) {
        this.articles = articles;
    }
}
