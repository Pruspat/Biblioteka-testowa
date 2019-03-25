package com.example.demo.support;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface SupportRepository extends JpaRepository<SupportEntity,Long> {

    SupportEntity findByCustomerId(Integer id);

    SupportEntity findById(Integer id);

    List<SupportEntity> findAllByStatus(boolean status);

    List<SupportEntity> findAllByCustomerId(Integer customerId);

    @Modifying
    @Transactional
    @Query("UPDATE SupportEntity SET replay = ?2, status = true WHERE id = ?1")
    int setReplay(Integer id, String replay);

}
