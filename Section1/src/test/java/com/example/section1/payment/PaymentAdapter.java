package com.example.section1.payment;

import com.example.section1.order.Order;
import com.example.section1.product.DiscountPolicy;
import com.example.section1.product.Product;

class PaymentAdapter implements PaymentPort {
    private final PaymentGateway paymentGateway; // 나중에는 api호출로 해결, 결제완료가 됐다는 가정하에 테스트
    private final PaymentRepository paymentRepository;

    PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Order getOrder(final Long orderId) {
        return new Order(new Product("상품1", 1000, DiscountPolicy.NONE), 2);
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
