package com.nssf.practical.entities;

import java.math.BigDecimal;
import java.time.LocalTime;

import com.nssf.practical.enums.Payment_Method;
import com.nssf.practical.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int id;

    @Column(name = "amount", nullable = false)
    public BigDecimal amount;

    @Column(name = "curency", nullable = false)
    public String currency;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name="payment_method")
    private Payment_Method paymentMethod;

    @Column(name = "created_at", nullable = false)
    public LocalTime createdAt;

    @Column(name = "updated_at", nullable = true)
    public LocalTime updateAt;

    public void setStatus(Status pending) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
    }
}
