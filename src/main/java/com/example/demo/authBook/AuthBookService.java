package com.example.demo.authBook;

import com.example.demo.author.AuthorEntity;
import com.example.demo.book.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthBookService {

    @Autowired
    AuthBookRepository authBookRepository;


    public void createRelation(BookEntity bookEntity, List<AuthorEntity> authorEntityList) {


        for (AuthorEntity authorEntity : authorEntityList) {
            AuthBookEntity authBookEntity = new AuthBookEntity();
            authBookEntity.setBookId(bookEntity.getId());
            authBookEntity.setAuthorId(authorEntity.getId());
            authBookRepository.save(authBookEntity);
        }
    }

    public void removeRelation(Integer bookId){
        authBookRepository.removeByBookId(bookId);
    }
}
