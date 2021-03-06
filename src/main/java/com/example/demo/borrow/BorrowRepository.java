package com.example.demo.borrow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface BorrowRepository  extends JpaRepository<BorrowEntity,Long> {

    List<BorrowEntity> findAllByCustomerId(Integer cutomerId);

    @Modifying
    @Transactional
    @Query("UPDATE BorrowEntity SET status = ?2, date_of_return = ?3 WHERE id = ?1")
    int changeAsReturned(Integer id, String status, Date returnDate);

    @Modifying
    @Transactional
    @Query("UPDATE BorrowEntity SET mark = ?2 WHERE id = ?1")
    int setMark(Integer id, Integer mark);

    @Modifying
    @Transactional
    @Query("UPDATE BorrowEntity SET review = ?2 WHERE id = ?1")
    int setReview(Integer id, String review);




    List<BorrowEntity> findAll();

    List<BorrowEntity> findAllByBookId(Integer bookId);

    BorrowEntity findById(Integer id);
}
