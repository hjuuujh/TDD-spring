package com.example.section1.order.application.port;

import com.example.section1.order.domain.Order;
import com.example.section1.product.domain.Product;

public interface OrderPort {
    Product getProductById(final Long productId);

    void save(final Order order);
}
