package com.example.demo.borrow;

import com.example.demo.CustomerBorrow.CustomerBorrowEntity;
import com.example.demo.CustomerBorrow.CustomerBorrowRepository;
import com.example.demo.CustomerBorrow.CustomerBorrowService;
import com.example.demo.authBook.AuthBookEntity;
import com.example.demo.authBook.AuthBookRepository;
import com.example.demo.author.AuthorEntity;
import com.example.demo.author.AuthorRepository;
import com.example.demo.book.BookEntity;
import com.example.demo.book.BookRepository;
import com.example.demo.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    AuthBookRepository authBookRepository;

    @Autowired
    CustomerBorrowService customerBorrowService;

    @Autowired
    CustomerBorrowRepository customerBorrowRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public HttpStatus addBorrow(@RequestBody Integer[] books) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        Integer customerId = customerRepository.findByEmail(currentUser).getId();

        List<BorrowEntity> borrowEntityList = new ArrayList<>();
        for (Integer id : books) {
            BorrowEntity borrowEntity = new BorrowEntity();
            //Save borrow entity
            if (!bookRepository.findById(id).getBorrowed()) {
                borrowEntity.setCustomerId(customerId);

                Date date = new Date(new Timestamp(System.currentTimeMillis()).getTime());
                borrowEntity.setBookId(id);
                borrowEntity.setDateOfBorrow(date);
                borrowEntity.setStatus("Nie oddano");
                borrowEntity.setReview("");
                borrowEntityList.add(borrowRepository.save(borrowEntity));

                //set is_borrowed equals false in bookEntity
                BookEntity book = bookRepository.findById(id);
                book.setBorrowed(true);
                bookRepository.save(book);
            } else {
                return HttpStatus.ALREADY_REPORTED;
            }
        }

        customerBorrowService.createRelation(customerId, borrowEntityList);
        return HttpStatus.CREATED;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<Borrow> listAllBorrows() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        System.out.println("Aktualny uzytkownik: " + currentUser);

        List<Borrow> borrowList = new ArrayList<>();
        List<AuthBookEntity> authBookEntitiesList;
        List<AuthorEntity> bookAuthors = new ArrayList<>();

        try {
            List<BorrowEntity> borrows = borrowRepository.findAllByCustomerId(customerRepository.findByEmail(currentUser).getId());

            for (BorrowEntity borrow : borrows) {

                authBookEntitiesList = authBookRepository.findAllByBookId(borrow.getBookId());

                for (AuthBookEntity authBookEntity : authBookEntitiesList) {
                    bookAuthors.add(authorRepository.findById(authBookEntity.getAuthorId()));
                }

                borrowList.add(new Borrow(
                        bookAuthors,
                        borrow.getId(),
                        bookRepository.findById(borrow.getBookId()).getTitle(),
                        borrow.getDateOfBorrow(),
                        borrow.getDateOfReturn(),
                        borrow.getStatus(),
                        borrow.getMark(),
                        borrow.getReview())
                );


            }
        } catch (NullPointerException e) {
            System.out.println(e + " w borrow/list");
        }

        return borrowList;
    }


    @RequestMapping(value = "/return/{customerId}", method = RequestMethod.GET)
    public HttpStatus returnBorrow(@PathVariable Integer customerId) {

            borrowRepository.changeAsReturned(customerId, "oddano", new Timestamp(System.currentTimeMillis()));
            BookEntity book = bookRepository.findById(borrowRepository.findById(customerId).getBookId());
            book.setBorrowed(false);
            bookRepository.save(book);

        return HttpStatus.OK;
    }

    @RequestMapping(value = "/mark", method = RequestMethod.POST)
    public Boolean markBorrow(@RequestBody Borrow borrow) {

        BorrowEntity borrowEntity = borrowRepository.findById(borrow.getId());

        if (borrowEntity.getStatus().equals("oddano") && borrowEntity.getMark() == null && borrow.getMark() <= 5 && 0 < borrow.getMark()) {
            borrowRepository.setMark(borrow.getId(), borrow.getMark());
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public Boolean reviewBorrow(@RequestBody Borrow borrow) {

        BorrowEntity borrowEntity = borrowRepository.findById(borrow.getId());

        if (borrowEntity.getStatus().equals("oddano") && borrowEntity.getReview().equals("")) {
            borrowRepository.setReview(borrow.getId(), borrow.getReview());
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "/avg-book/{bookId}", method = RequestMethod.GET)
    public Double getAvgMark(@PathVariable Integer bookId) {

        List<BorrowEntity> borrowEntityList = borrowRepository.findAllByBookId(bookId);
        Double sum = 0.0;
        Double counter = 0.0;

        for (BorrowEntity borrowEntity : borrowEntityList) {
            if(borrowEntity.getMark() != null){
                sum += borrowEntity.getMark();
                counter++;
            }
        }

        return sum / counter;
    }

    @RequestMapping(value = "/get-review/{bookId}", method = RequestMethod.GET)
    public List<String> getReview(@PathVariable Integer bookId) {
        List<BorrowEntity> borrowEntityList = borrowRepository.findAllByBookId(bookId);

        List<String> reviews = new ArrayList<>();
        for (BorrowEntity borrowEntity : borrowEntityList) {
            reviews.add(borrowEntity.getReview());
        }

        return reviews;
    }
}
