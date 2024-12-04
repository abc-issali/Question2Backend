package com.nssf.practical.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nssf.practical.dtos.ErrorResponse;
import com.nssf.practical.dtos.PaymentRequest;
import com.nssf.practical.entities.Transactions;
import com.nssf.practical.services.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/initiatePayment", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> intiatePayment(@RequestBody PaymentRequest paymentRequest){
        try {
            return paymentService.makePayment(paymentRequest);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("Error occurred. Try again", "500"), 
            HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/getPaymentById", produces = "application/json")
    public ResponseEntity<?> getPaymentById(@RequestParam int id){
        try {
            return paymentService.getPaymentById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("Failed to retrieve payment by Id",
             "500"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/getAllPayments", produces = "application/json")
    public ResponseEntity<?> getPayments(){
        try {
            return paymentService.getAllPayments();
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("Error occurred. Try again", "500"), 
            HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
