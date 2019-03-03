package com.example.demo.borrow;

import com.example.demo.author.AuthorRepository;
import com.example.demo.book.BookEntity;
import com.example.demo.book.BookRepository;
import com.example.demo.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/borrow")
public class BorrowController {

    @Autowired
    BorrowRepository borrowRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public HttpStatus addBorrow(@RequestBody BorrowEntity borrowEntity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        Integer customerId = customerRepository.findByEmail(currentUser).getId();

        //Save borrow entity
        if (!bookRepository.findById(borrowEntity.getBookId()).getBorrowed()) {
            borrowEntity.setCustomerId(customerId);

            Date date = new Date(new Timestamp(System.currentTimeMillis()).getTime());
            System.out.println(date);
            borrowEntity.setDateOfBorrow(date);
            borrowEntity.setStatus("Nie oddano");
            borrowRepository.save(borrowEntity);

            //set is_borrowed equals false in bookEntity
            BookEntity book = bookRepository.findById(borrowEntity.getBookId());
            book.setBorrowed(true);
            bookRepository.save(book);
            return HttpStatus.CREATED;
        }else{
            return HttpStatus.ALREADY_REPORTED;
        }

    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<Borrow> listAllBorrows() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        System.out.println("Aktualny uzytkownik: " + currentUser);
        List<BorrowEntity> borrows = borrowRepository.findAllByCustomerId(customerRepository.findByEmail(currentUser).getId());
        List<Borrow> borrowList = new ArrayList<>();
        for (BorrowEntity borrow : borrows) {


            borrowList.add(new Borrow(
                    "Imie autora",
                    "Naziwsok autora",
                    bookRepository.findById(borrow.getBookId()).getTitle(),
                    borrow.getDateOfBorrow(),
                    borrow.getDateOfReturn(),
                    borrow.getStatus())
            );
        }

        return borrowList;
    }


    @RequestMapping(value = "/return/{id}", method = RequestMethod.GET)
    public HttpStatus returnBorrow(@PathVariable Integer id) {
        borrowRepository.changeAsReturned(id, "oddano", new Timestamp(System.currentTimeMillis()));

        BookEntity book = bookRepository.findById(borrowRepository.findById(id).getBookId());
        book.setBorrowed(false);
        bookRepository.save(book);
        return HttpStatus.OK;
    }
}
