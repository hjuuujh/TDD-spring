package com.example.section1.product;

// interface로 만들고 구현은 adapter에서
interface ProductPort {
    void save(final Product product);

    Product getProduct(Long productId);
}
