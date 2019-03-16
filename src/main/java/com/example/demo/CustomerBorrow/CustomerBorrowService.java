package com.example.demo.CustomerBorrow;

import com.example.demo.authBook.AuthBookEntity;
import com.example.demo.author.AuthorEntity;
import com.example.demo.book.Book;
import com.example.demo.book.BookEntity;
import com.example.demo.borrow.BorrowEntity;
import com.example.demo.customer.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerBorrowService {

    @Autowired
    CustomerBorrowRepository customerBorrowRepository;

    public void createRelation(Integer customerId, List<BorrowEntity>  borrowEntityList) {


        for (BorrowEntity borrowEntity : borrowEntityList) {
            CustomerBorrowEntity customerBorrowEntity = new CustomerBorrowEntity();
            customerBorrowEntity.setBorrowId(borrowEntity.getId());
            customerBorrowEntity.setCustomerId(customerId);
            customerBorrowRepository.save(customerBorrowEntity);
        }
    }
}
