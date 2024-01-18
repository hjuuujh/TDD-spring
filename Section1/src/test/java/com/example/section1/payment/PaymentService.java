package com.example.section1.payment;

import com.example.section1.order.Order;

class PaymentService {
    private final PaymentPort paymentPort;

    PaymentService(PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    public void payment(final PaymentRequest request) {
        // 반환받은 order에 new payment생성
        Order order = paymentPort.getOrder(request.orderId());

        // 이 payment를 가지고 paymentport에게 pay하라고 시킬것
        final Payment payment = new Payment(order, request.cardNumber());

        paymentPort.pay(payment.getPrice(), payment.getCardNumber());
        //pay가 되면 저장
        paymentPort.save(payment);
    }
}
