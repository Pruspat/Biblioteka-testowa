package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.internal.CustomizerRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public HttpStatus addCustomer(@RequestBody CustomerEntity customerEntity) {
            customerEntity.setRole("user");
            System.out.println(customerEntity.getId());
            customerRepository.save(customerEntity);
        return HttpStatus.CREATED;
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HttpStatus loginCustomer(@RequestBody CustomerEntity customerEntity) {
            customerEntity.setRole("user");
            System.out.println(customerEntity.getId());
            customerRepository.save(customerEntity);
        return HttpStatus.OK;
    }

}
