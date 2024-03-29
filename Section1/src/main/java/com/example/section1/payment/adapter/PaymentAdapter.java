package com.example.section1.payment.adapter;

import com.example.section1.order.domain.Order;
import com.example.section1.order.adapter.OrderRepository;
import com.example.section1.payment.application.port.PaymentPort;
import com.example.section1.payment.domain.Payment;
import org.springframework.stereotype.Component;

@Component
class PaymentAdapter implements PaymentPort {
    private final PaymentGateway paymentGateway; // 나중에는 api호출로 해결, 결제완료가 됐다는 가정하에 테스트
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    PaymentAdapter(final PaymentGateway paymentGateway, final PaymentRepository paymentRepository, final OrderRepository orderRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrder(final Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("주문이 존재하지 않습니다."));
    }

    @Override
    public void pay(final int totalPrice, final String cardNumber) {
        paymentGateway.execute(totalPrice, cardNumber);
    }

    @Override
    public void save(final Payment payment) {
        paymentRepository.save(payment);
    }
}
