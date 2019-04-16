package com.example.demo.customer;

import com.example.demo.book.BookEntity;
import com.example.demo.book.BookRepository;
import com.example.demo.borrow.Borrow;
import com.example.demo.borrow.BorrowEntity;
import com.example.demo.borrow.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.internal.CustomizerRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BorrowRepository borrowRepository;

    @Autowired
    BookRepository bookRepository;


    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public CustomerController(CustomerRepository customerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.customerRepository = customerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public HttpStatus addCustomer(@RequestBody CustomerEntity customerEntity) {
        customerEntity.setRole("user");
        customerEntity.setPassword(bCryptPasswordEncoder.encode(customerEntity.getPassword()));
        customerRepository.save(customerEntity);
        return HttpStatus.CREATED;
    }

    @RequestMapping(value = "/getRole", method = RequestMethod.GET)
    public String getRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();

        return customerRepository.findByEmail(currentUser).getRole();
    }

    @RequestMapping(value = "/getWorkers", method = RequestMethod.GET)
    public List<CustomerEntity> getWorkers() {
        List<CustomerEntity> customerEntities =customerRepository.findByRole("worker");
        return customerEntities;
    }

    @RequestMapping(value = "/setSalary", method = RequestMethod.POST)
    public HttpStatus setSalary(@RequestBody Customer customer) {

        customerRepository.setSalary(customer.getId(), customer.getSalary());
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<CustomerEntity> getUsers() {

        return customerRepository.findAll();
    }


    @RequestMapping(value = "/setRole", method = RequestMethod.POST)
    public HttpStatus setRole(@RequestBody Customer customer) {

        customerRepository.setRole(customer.getId(), customer.getRole());
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/publicBorrow", method = RequestMethod.GET)
    public List<Customer> showPublicBorrow() {

        List<BorrowEntity> borrowList = new ArrayList<>();
        List<Customer> result = new ArrayList<>();
        List<BookEntity> bookList = new ArrayList<>();


        List<CustomerEntity> customerEntities = customerRepository.findAll();

        for (CustomerEntity customerEntity : customerEntities) {

            if (customerRepository.findById(customerEntity.getId()).isPublic()) {
                borrowList = (borrowRepository.findAllByCustomerId(customerEntity.getId()));
                String name = customerRepository.findById(customerEntity.getId()).getName();
                String surname = customerRepository.findById(customerEntity.getId()).getSurname();

                for (BorrowEntity borrowEntity: borrowList) {
                    String title = bookRepository.findById(borrowEntity.getBookId()).getTitle();
                    String category = bookRepository.findById(borrowEntity.getBookId()).getType();

                    bookList.add(new BookEntity(title,category));
                }
                result.add(new Customer(name,surname,bookList));
            }
        }
        return result;
    }
    @RequestMapping(value = "/setPublic", method = RequestMethod.POST)
    public HttpStatus setPublicProfile(@RequestBody Customer customer) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();

        customerRepository.setIsPublic(customerRepository.findByEmail(currentUser).getId(),true);

        return HttpStatus.OK;
    }


}
