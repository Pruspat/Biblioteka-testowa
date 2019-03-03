package com.example.demo.borrow;

import com.example.demo.author.AuthorEntity;

import java.util.Date;
import java.util.List;

public class Borrow {

    private List<AuthorEntity> authors;
    private String title;
    private Date dateOfBorrow;
    private Date dateOfReturn;
    private String status;

    public Borrow(List<AuthorEntity> authors, String title, Date dateOfBorrow, Date dateOfReturn, String status) {
        this.authors = authors;
        this.title = title;
        this.dateOfBorrow = dateOfBorrow;
        this.dateOfReturn = dateOfReturn;
        this.status = status;
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
}
