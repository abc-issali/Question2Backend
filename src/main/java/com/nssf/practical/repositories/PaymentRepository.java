package com.nssf.practical.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nssf.practical.entities.Transactions;

@Repository
public interface PaymentRepository extends JpaRepository<Transactions, Integer> {
    Optional<Transactions> findById(String id);

    List<Transactions> findAll();
}
