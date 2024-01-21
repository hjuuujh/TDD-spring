package com.example.section1.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

interface PaymentRepository extends JpaRepository<Payment, Long>{

}
