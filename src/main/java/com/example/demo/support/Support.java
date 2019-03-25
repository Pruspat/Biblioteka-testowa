package com.example.demo.support;

public class Support {

    private Integer id;
    private Integer customerId;
    private String content;
    private String replay;
    private boolean status;

    public Support() {
    }

    public Support(Integer id, Integer customerId, String content, boolean status, String replay) {
        this.id = id;
        this.customerId = customerId;
        this.content = content;
        this.status = status;
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
}
