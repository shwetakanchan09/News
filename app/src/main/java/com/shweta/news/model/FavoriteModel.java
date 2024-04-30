package com.shweta.news.model;

public class FavoriteModel {

    public String title;
    public String name;
    public String urlToImage;

    public FavoriteModel(String title, String name, String urlToImage) {
        this.title = title;
        this.name = name;
        this.urlToImage = urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
