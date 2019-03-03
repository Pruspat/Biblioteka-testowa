package com.example.demo.book;

public class Book {

    private String title;
    private String type;
    private Long isbnNr;
    private String name;
    private String surname;
    private Boolean isBorrowed;

    public Book(String title, String type, Long isbnNr,Boolean isBorrowed) {
        this.title = title;
        this.type = type;
        this.isbnNr = isbnNr;
        this.isBorrowed = isBorrowed;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        isBorrowed = borrowed;
    }
}
