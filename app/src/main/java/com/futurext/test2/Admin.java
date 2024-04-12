package com.futurext.test2;

public class Admin {
    private String bookName;
    private  String Category;
    private  Integer price;

    public Admin(String bookName, String category, Integer price) {
        this.bookName = bookName;
        this.Category = category;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
