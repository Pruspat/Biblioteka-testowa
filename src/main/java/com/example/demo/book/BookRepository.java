package com.example.demo.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,Long> {

    void deleteById(Integer Id);
    List<BookEntity> findAll();
}
