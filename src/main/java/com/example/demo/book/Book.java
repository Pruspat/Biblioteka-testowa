package com.example.demo.book;

public class Book {

    private String title;
    private String type;
    private Long isbnNr;
    private Boolean isBorrowed;
    private String img;

    public Book(String title, String type, Long isbnNr,Boolean isBorrowed) {
        this.title = title;
        this.type = type;
        this.isbnNr = isbnNr;
        this.isBorrowed = isBorrowed;

    }

    public Book(String title, String type, Long isbnNr, Boolean isBorrowed, String img) {
        this.title = title;
        this.type = type;
        this.isbnNr = isbnNr;
        this.isBorrowed = isBorrowed;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getIsbnNr() {
        return isbnNr;
    }

    public void setIsbnNr(Long isbnNr) {
        this.isbnNr = isbnNr;
    }


    public Boolean getBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
