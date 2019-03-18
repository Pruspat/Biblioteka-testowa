package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.internal.CustomizerRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;


    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public CustomerController(CustomerRepository customerRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
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


}
