package com.marco.model;

public class ProductReview {
    // fields
    private String userName;
    private int rating;

    //constructor
    public ProductReview(String userName, int rating) {
        this.userName = userName;
        this.rating = rating;
    }

    // methods
    public String getUserName() {
        return userName;
    }

    public int getRating() {
        return rating;
    }
}
