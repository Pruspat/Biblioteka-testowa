package com.example.demo.CustomerBorrow;


import javax.persistence.*;

@Entity
@Table(name="CustomerBorrow")
public class CustomerBorrowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer customerId;
    private Integer borrowId;

    public CustomerBorrowEntity() {
    }

    public CustomerBorrowEntity(Integer customerId, Integer borrowId) {
        this.customerId = customerId;
        this.borrowId = borrowId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }
}
