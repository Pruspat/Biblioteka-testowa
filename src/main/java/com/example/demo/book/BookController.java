package com.example.demo.book;

import com.example.demo.authBook.AuthBookService;
import com.example.demo.author.AuthorEntity;
import com.example.demo.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public HttpStatus addBook(@RequestBody BookContentHolder bookContentHolder) {

       bookRepository.save(bookContentHolder.getBookEntity());
        for (AuthorEntity authorEntity : bookContentHolder.getAuthorEntityList()) {
            authorRepository.save(authorEntity);
        }
        authBookService.createRelation(bookContentHolder.getBookEntity(),bookContentHolder.getAuthorEntityList());
        return HttpStatus.CREATED;
    }

    @RequestMapping(value ="/all", method = RequestMethod.POST)
    public List<BookEntity> listBooks(){

        return bookRepository.findAll();
    }

    @RequestMapping(value = "/remove/{id}",method = RequestMethod.GET)
    public HttpStatus removeBook(@PathVariable Integer id){
        bookRepository.deleteById(id);
        authBookService.removeRelation(id);
        return HttpStatus.OK;
    }
}
