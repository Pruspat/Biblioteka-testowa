package com.example.demo.support;

public class Support {

    private Integer id;
    private Integer customerId;
    private String customerName;
    private String customerSurname;
    private String content;
    private String replay;
    private boolean status;
    private Integer workerId;

    public Support() {
    }

    public Support(Integer id, Integer customerId, String customerName, String customerSurname, String content, boolean status, String replay) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.content = content;
        this.status = status;
        this.replay = replay;
    }

    public Support(Integer id,Integer customerId, String customerName, String customerSurname, String content, String replay, boolean status) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.content = content;
        this.replay = replay;
        this.status = status;
    }

    public Support(Integer id, Integer customerId, String customerName, String customerSurname, String content, String replay, boolean status, Integer workerId) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.content = content;
        this.replay = replay;
        this.status = status;
        this.workerId = workerId;
    }

    public Support(Integer id, String replay) {
        this.id = id;
        this.replay = replay;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplay() {
        return replay;
    }

    public void setReplay(String replay) {
        this.replay = replay;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }
}
