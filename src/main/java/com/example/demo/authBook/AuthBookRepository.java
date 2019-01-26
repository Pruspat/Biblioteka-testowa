package com.example.demo.authBook;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthBookRepository extends JpaRepository<AuthBookEntity, Long> {

    AuthBookEntity removeByBookId(Integer bookId);
}
