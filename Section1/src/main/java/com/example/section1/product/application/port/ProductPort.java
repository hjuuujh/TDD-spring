package com.example.section1.product.application.port;

import com.example.section1.product.domain.Product;

// interface로 만들고 구현은 adapter에서
public interface ProductPort {
    void save(final Product product);

    Product getProduct(Long productId);
}
