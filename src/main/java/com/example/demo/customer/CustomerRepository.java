package com.example.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findByEmail(String email);

    CustomerEntity findById(Integer id);

    List<CustomerEntity> findByRole(String role);

    List<CustomerEntity> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE CustomerEntity SET salary = ?2 WHERE id = ?1")
    int setSalary(Integer id, Float Salary);

    @Modifying
    @Transactional
    @Query("UPDATE CustomerEntity SET role = ?2 WHERE id = ?1")
    int setRole(Integer id, String role);

    @Modifying
    @Transactional
    @Query("UPDATE CustomerEntity SET is_public = ?2 WHERE id = ?1")
    int setIsPublic(Integer id, boolean is_public);

}
