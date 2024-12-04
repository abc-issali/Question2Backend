package com.nssf.practical.dtos;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {
    private BigDecimal amount;
    private String currency;
    private String paymentMethod;

    public PaymentRequest(BigDecimal amount, String currency, String paymentMethod){
        this.amount = amount;
        this.currency = currency;
        this.paymentMethod = paymentMethod;
    }
}
