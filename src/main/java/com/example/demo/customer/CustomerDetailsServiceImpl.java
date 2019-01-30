package com.example.demo.customer;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class CustomerDetailsServiceImpl implements UserDetailsService {
    private CustomerRepository customerRepository;

    public CustomerDetailsServiceImpl(CustomerRepository customerRepository) {
       this.customerRepository = customerRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       CustomerEntity customerEntity = customerRepository.findByEmail("pruspat@gmail.com");

        if (customerEntity == null) {
            throw new UsernameNotFoundException(email);
        }
        System.out.println(customerEntity.getEmail());
        return new User(customerEntity.getEmail(), customerEntity.getPassword(), emptyList());
    }
}