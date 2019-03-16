package com.example.demo.CustomerBorrow;

import com.example.demo.borrow.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerBorrowRepository extends JpaRepository<BorrowEntity,Long> {

    List<CustomerBorrowEntity> findAllByCustomerId(Integer id);
    CustomerBorrowEntity save(CustomerBorrowEntity customerBorrowEntity);
}
