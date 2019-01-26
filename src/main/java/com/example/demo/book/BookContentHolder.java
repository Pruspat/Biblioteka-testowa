package com.example.demo.book;

import com.example.demo.author.AuthorEntity;

import java.util.List;

public class BookContentHolder {

    private BookEntity bookEntity;
    private List<AuthorEntity> authorEntityList;

    public BookContentHolder(BookEntity bookEntity, List<AuthorEntity> authorEntityList) {
        this.bookEntity = bookEntity;
        this.authorEntityList = authorEntityList;
    }

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    public List<AuthorEntity> getAuthorEntityList() {
        return authorEntityList;
    }

    public void setAuthorEntityList(List<AuthorEntity> authorEntityList) {
        this.authorEntityList = authorEntityList;
    }
}
