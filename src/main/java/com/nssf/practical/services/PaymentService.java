package com.nssf.practical.services;

import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nssf.practical.dtos.ErrorResponse;
import com.nssf.practical.dtos.PaymentRequest;
import com.nssf.practical.entities.Transactions;
import com.nssf.practical.enums.Payment_Method;
import com.nssf.practical.enums.Status;
import com.nssf.practical.repositories.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public ResponseEntity<?> getPaymentById(int id){
        try {
            return paymentRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            // log error on file and database
            throw e;
        }
    }

    public ResponseEntity<?> getAllPayments(){
        try {
            return (ResponseEntity<?>) paymentRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            // log error on file and database
            return new ResponseEntity<>(new ErrorResponse("Failed to retrieve payments.", 
            "500"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> makePayment(PaymentRequest paymentRequest){
        try {
            Transactions transaction = new Transactions();
            transaction.setAmount(paymentRequest.geAmount());
            transaction.setCurrency(paymentRequest.getCurrency());
            transaction.setStatus(Status.pending);
            transaction.setPaymentMethod(paymentRequest.getPaymentMethod());
            transaction.setCreatedAt(LocalTime.now());

            paymentRepository.save(transaction);
        } catch (Exception e) {
            e.printStackTrace();
            // log error on file and database
            // Return appropriate response to caller
            return new ResponseEntity<>(new ErrorResponse("Payment processing failed.", 
            "500"), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}
