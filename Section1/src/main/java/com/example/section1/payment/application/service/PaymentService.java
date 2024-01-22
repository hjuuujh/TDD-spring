package com.example.section1.payment.application.service;

import com.example.section1.order.domain.Order;
import com.example.section1.payment.application.port.PaymentPort;
import com.example.section1.payment.domain.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
class PaymentService {
    private final PaymentPort paymentPort;

    PaymentService(final PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> payment(@RequestBody final PaymentRequest request) {
        // 반환받은 order에 new payment생성
        final Order order = paymentPort.getOrder(request.orderId());

        // 이 payment를 가지고 paymentport에게 pay하라고 시킬것
        final Payment payment = new Payment(order, request.cardNumber());

        paymentPort.pay(payment.getPrice(), payment.getCardNumber());
        //pay가 되면 저장
        paymentPort.save(payment);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
