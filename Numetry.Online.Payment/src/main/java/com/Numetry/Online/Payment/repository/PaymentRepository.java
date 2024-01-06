package com.Numetry.Online.Payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.Numetry.Online.Payment.entity.Payment;

@RestController
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
