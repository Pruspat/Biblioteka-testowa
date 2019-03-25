package com.example.demo.borrow;

import com.example.demo.book.BookEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Borrow")
public class BorrowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer customerId;
    private Integer bookId;
    private Date dateOfBorrow;
    private Date dateOfReturn;
    private String status;
    private Integer mark;
    private String review;
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "bookId",targetEntity = BookEntity.class)
//    private List<BookEntity> booksList = new ArrayList<>();

//    public List<BookEntity> getBooksList() {
//        return booksList;
//    }
//
//    public void setBooksList(List<BookEntity> booksList) {
//        this.booksList = booksList;
//    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
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
