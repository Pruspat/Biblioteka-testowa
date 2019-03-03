package com.example.demo.author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    AuthorEntity findById(Integer id);
}
