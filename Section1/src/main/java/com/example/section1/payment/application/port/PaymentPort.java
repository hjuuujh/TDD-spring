package com.example.section1.payment.application.port;

import com.example.section1.order.domain.Order;
import com.example.section1.payment.domain.Payment;

public interface PaymentPort {
    Order getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
