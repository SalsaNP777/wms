package com.enigma.wms_api.repository;

import com.enigma.wms_api.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findByTransDateBetween(Date startDate, Date endDate);

    Page<Transaction> findAll(Specification<Transaction> specification, Pageable pageable);
}
