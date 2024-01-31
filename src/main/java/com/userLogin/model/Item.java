package com.userLogin.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    private int id;
    private String title;
    private String photoURL;
    private double price;
    private int stock;

    public Item(int id, String title, String photoURL, double price, int stock) {
        this.id = id;
        this.title = title;
        this.photoURL = photoURL;
        this.price = price;
        this.stock = stock;
    }

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

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
