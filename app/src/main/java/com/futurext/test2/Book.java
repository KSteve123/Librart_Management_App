package com.futurext.test2;

public class Book {
    private String bookName;
    private String category;
    private String price;
    public Book(){}

    public Book(String bookName, String category, String price) {
        this.bookName = bookName;
        this.category = category;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }
}
