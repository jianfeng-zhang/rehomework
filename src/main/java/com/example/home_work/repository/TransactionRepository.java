package com.example.home_work.repository;


import com.example.home_work.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    public List<Transaction> findAllByCustomerIdAndTransactionDateBetween(Integer customerId, Date from, Date to);
}
