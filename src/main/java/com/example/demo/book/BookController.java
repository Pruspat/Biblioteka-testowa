package com.example.demo.book;

import com.example.demo.authBook.AuthBookEntity;
import com.example.demo.authBook.AuthBookRepository;
import com.example.demo.authBook.AuthBookService;
import com.example.demo.author.AuthorEntity;
import com.example.demo.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    AuthBookService authBookService;
    @Autowired
    AuthBookRepository authBookRepository;

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public HttpStatus addBook(@RequestBody BookContentHolder bookContentHolder) {

        System.out.println(bookContentHolder.getBookEntity().getTitle());
        for (AuthorEntity authorEntity : bookContentHolder.getAuthorEntityList()) {
           System.out.println(authorEntity.getName());
        }

        bookRepository.save(bookContentHolder.getBookEntity());

        for (AuthorEntity authorEntity : bookContentHolder.getAuthorEntityList()) {
            authorRepository.save(authorEntity);
        }
        authBookService.createRelation(bookContentHolder.getBookEntity(),bookContentHolder.getAuthorEntityList());

        return HttpStatus.CREATED;
    }

    @RequestMapping(value ="/all", method = RequestMethod.POST)
    public List<BookContentHolder> listBooks(){

        List<BookContentHolder> bookWithAuthorList = new ArrayList<>();
        List<BookEntity> listOfBooks = bookRepository.findAll();
        List<AuthBookEntity> authBookEntitiesList = new ArrayList<>();
        List<AuthorEntity> bookAuthors = new ArrayList<>();
        for (BookEntity book: listOfBooks) {

            authBookEntitiesList = authBookRepository.findAllByBookId(book.getId());

            for (AuthBookEntity authBookEntity : authBookEntitiesList) {
                bookAuthors.add(authorRepository.findById(authBookEntity.getAuthorId()));
            }

            BookContentHolder bookContentHolder = new BookContentHolder(book, bookAuthors);
            bookWithAuthorList.add(bookContentHolder);
//            bookAuthors.clear();
        }

        return bookWithAuthorList;
    }

    @RequestMapping(value = "/remove/{id}",method = RequestMethod.GET)
    public HttpStatus removeBook(@PathVariable Integer id){
        bookRepository.deleteById(id);
        authBookService.removeRelation(id);
        return HttpStatus.OK;
    }
}
