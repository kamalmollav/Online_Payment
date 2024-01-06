package com.Numetry.Online.Payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Numetry.Online.Payment.entity.Payment;
import com.Numetry.Online.Payment.repository.PaymentRepository;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	 @Autowired
	    private PaymentRepository paymentRepository;

	    @GetMapping
	    public List<Payment> getAllPayments() {
	        return paymentRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public Payment getPaymentById(@PathVariable Long id) {
	        return paymentRepository.findById(id).orElse(null);
	    }

	    @PostMapping
	    public Payment createPayment(@RequestBody Payment payment) {
	        return paymentRepository.save(payment);
	    }

	    @PutMapping("/{id}")
	    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
	        Payment existingPayment = paymentRepository.findById(id).orElse(null);

	        if (existingPayment != null) {
	            existingPayment.setSource(updatedPayment.getSource());
	            existingPayment.setAmount(updatedPayment.getAmount());
	            existingPayment.setTransactionId(updatedPayment.getTransactionId());

	            return paymentRepository.save(existingPayment);
	        } else {
	            return null; // Handle not found case
	        }
	    }

	    @DeleteMapping("/{id}")
	    public void deletePayment(@PathVariable Long id) {
	        paymentRepository.deleteById(id);
	    }
}
