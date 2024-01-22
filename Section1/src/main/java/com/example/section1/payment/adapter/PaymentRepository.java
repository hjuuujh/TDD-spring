package com.example.section1.payment.adapter;

import com.example.section1.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

interface PaymentRepository extends JpaRepository<Payment, Long>{

}
