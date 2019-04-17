package com.example.demo.authBook;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthBookRepository extends JpaRepository<AuthBookEntity, Long> {

    AuthBookEntity removeByBookId(Integer bookId);
    List<AuthBookEntity> findAllByBookId(Integer id);

    AuthBookEntity findByBookId(Integer id);
}
