package com.example.demo.borrow;

import com.example.demo.author.AuthorEntity;

import java.util.Date;
import java.util.List;

public class Borrow {

    private Integer id;
    private List<AuthorEntity> authors;
    private String title;
    private Date dateOfBorrow;
    private Date dateOfReturn;
    private String status;
    private Integer mark;
    private String review;

    public Borrow() {
    }

    public Borrow(Integer id, Integer mark) {
        this.id = id;
        this.mark = mark;
    }

    public Borrow(Integer id, String review) {
        this.id = id;
        this.review = review;
    }

    public Borrow(List<AuthorEntity> authors, String title, Date dateOfBorrow, Date dateOfReturn, String status) {
        this.authors = authors;
        this.title = title;
        this.dateOfBorrow = dateOfBorrow;
        this.dateOfReturn = dateOfReturn;
        this.status = status;
    }

    public Borrow(List<AuthorEntity> authors, String title, Date dateOfBorrow, Date dateOfReturn, String status, Integer mark, String review) {
        this.authors = authors;
        this.title = title;
        this.dateOfBorrow = dateOfBorrow;
        this.dateOfReturn = dateOfReturn;
        this.status = status;
        this.mark = mark;
        this.review = review;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorEntity> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfBorrow() {
        return dateOfBorrow;
    }

    public void setDateOfBorrow(Date dateOfBorrow) {
        this.dateOfBorrow = dateOfBorrow;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}

