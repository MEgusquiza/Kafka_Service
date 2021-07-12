package com.bank.repository;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.model.CreditPayment;



public interface CreditPaymentRepository {

    void save(CreditPayment creditPayment);
    Map<String, CreditPayment> findAll();
    CreditPayment findById(String id);
    void update(CreditPayment creditPayment);
    void delete(String id);
}
