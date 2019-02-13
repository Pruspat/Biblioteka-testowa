package com.example.demo.borrow;

import com.example.demo.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/borrow")
public class BorrowController {

    @Autowired
    BorrowRepository borrowRepository;

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public HttpStatus addBorrow(@RequestBody BorrowEntity borrowEntity){
            borrowEntity.setDateOfBorrow(new Timestamp(System.currentTimeMillis()));
            borrowEntity.setStatus("Nie oddano");
            borrowRepository.save(borrowEntity);
        return HttpStatus.CREATED;
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public List<BorrowEntity> listAllBorrows(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        System.out.println("Aktualny uzytkownik: "+currentUser);

        return borrowRepository.findAllByCustomerId(customerRepository.findByEmail(currentUser).getId());
    }


    @RequestMapping(value = "/return/{id}",method = RequestMethod.GET)
    public HttpStatus returnBorrow(@PathVariable Integer id){
        borrowRepository.changeAsReturned(id,"oddano",new Timestamp(System.currentTimeMillis()));
        return HttpStatus.OK;
    }
}
