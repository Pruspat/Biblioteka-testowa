package com.example.demo.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,Long> {

    List<BookEntity> findAll();

    List<BookEntity> findAllByType(String type);

    BookEntity findById(Integer id);
}
