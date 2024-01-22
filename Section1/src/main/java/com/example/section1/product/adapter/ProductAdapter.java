package com.example.section1.product.adapter;

import com.example.section1.product.application.port.ProductPort;
import com.example.section1.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
class ProductAdapter implements ProductPort {
    private final ProductRepository productRepository;

    // 생성자로 주입
    ProductAdapter(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(final Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(final Long productId){
        // 상품을 조회하고 없으면 throw를 던짐
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다"));
    }
}
