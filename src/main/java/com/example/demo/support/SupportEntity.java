package com.example.demo.support;

import javax.persistence.*;

@Entity
@Table(name = "SupportTable")
public class SupportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer customerId;
    private String content;
    private String replay;
    private boolean status;

    public SupportEntity() {
    }

    public SupportEntity(Integer customerId, String content,  boolean status, String replay) {
        this.customerId = customerId;
        this.content = content;
        this.status = status;
        this.replay = replay;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
