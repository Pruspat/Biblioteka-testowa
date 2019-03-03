package com.example.demo.borrow;

import java.util.Date;

public class Borrow {

    private String authorName;
    private String authorSurname;
    private String title;
    private Date dateOfBorrow;
    private Date dateOfReturn;
    private String status;


    public Borrow(String authorName, String authorSurname, String title, Date dateOfBorrow, Date dateOfReturn, String status) {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.title = title;
        this.dateOfBorrow = dateOfBorrow;
        this.dateOfReturn = dateOfReturn;
        this.status = status;
    }


    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
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
