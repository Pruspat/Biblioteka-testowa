package com.example.demo.book;

import com.example.demo.borrow.BorrowEntity;

import javax.persistence.*;

@Entity
@Table(name = "BookTable")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String type;
    private Long isbnNr;
    private Integer workerId;
    private Boolean isBorrowed;
    private String img;

    public BookEntity() {
    }

    public BookEntity(String title, String type, Long isbnNr, Integer workerId, Boolean isBorrowed) {
        this.title = title;
        this.type = type;
        this.isbnNr = isbnNr;
        this.workerId = workerId;
        this.isBorrowed = isBorrowed;
    }

    public BookEntity(String title, String type, Long isbnNr, Integer workerId, Boolean isBorrowed, String img) {
        this.title = title;
        this.type = type;
        this.isbnNr = isbnNr;
        this.workerId = workerId;
        this.isBorrowed = isBorrowed;
        this.img = img;
    }

    public BookEntity(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
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
