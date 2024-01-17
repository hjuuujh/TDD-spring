package com.example.section1.order;

import com.example.section1.product.Product;

interface OrderPort {
    Product getProductById(final Long productId);

    void save(final Order order);
}
