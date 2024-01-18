package com.example.section1.payment;

import java.util.HashMap;
import java.util.Map;

class PaymentRepository {
    private Long sequence = 1L;
    private Map<Long, Payment> persistence = new HashMap<>();

    public void save(final Payment payment) {
        payment.assignId(++sequence);
        persistence.put(payment.getId(), payment);
    }
}
